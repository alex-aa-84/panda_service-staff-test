package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.AttachmentFile;
import wwf.org.staff.service.AttachmentFileService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/attachmentfile")
public class AttachmentFileController {
    @Autowired
    private AttachmentFileService service;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<AttachmentFile>> listData(){
        List<AttachmentFile> data = service.listAllAttachmentFile();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AttachmentFile> getData(@PathVariable("id") Long id){
        AttachmentFile data = service.getAttachmentFile(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{reference}/{referenceId}")
    public ResponseEntity<List<AttachmentFile>> getAttachmentReference(@PathVariable("reference") String reference, @PathVariable("referenceId") Long referenceId){
        List<AttachmentFile> data = service.findByReferenceAndReferenceId(reference, referenceId);
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<AttachmentFile> createData(@Valid @RequestBody AttachmentFile data, BindingResult result){

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAttachmentFile(data));
    }

    @PutMapping()
    public ResponseEntity<AttachmentFile> updateDate(@Valid @RequestBody AttachmentFile data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        AttachmentFile dataUp = service.updateAttachmentFile(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteAttachmentFile(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
