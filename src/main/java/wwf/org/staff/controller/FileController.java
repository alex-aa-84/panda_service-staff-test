package wwf.org.staff.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import wwf.org.staff.message.FileMessage;
import wwf.org.staff.model.FileModel;
import wwf.org.staff.service.FileService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})

@RequestMapping(value="/admstaffwwf/file")

public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping()
    public ResponseEntity<FileMessage> uploadFiles(@RequestParam("files")MultipartFile[] files){

        String message = "";

        try{
            fileService.init();
        }catch (Exception e){
            message = "failed to created files: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }

        try{

            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file->{
                fileService.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            message += MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile",
                "").build().toString();

            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        }catch (Exception e){
            e.printStackTrace();
            message = "failed to upload files: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }

    @GetMapping(value = "/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename()+"\"").body(file);
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileModel>> getFiles(){
        List<FileModel> fileInfos = fileService.loadAll().map(path -> {
          String filename = path.getFileName().toString();
          String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile",
                  path.getFileName().toString()).build().toString();
          return new FileModel(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


    @DeleteMapping(value = "/{filename:.+}")
    public ResponseEntity<FileMessage> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = fileService.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }


}
