package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsFundingSource;
import wwf.org.staff.service.ProjectsFundingSourceService;
import wwf.org.staff.service.ProjectsService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/projectsfundingsource")
public class ProjectsFundingSourceController {

    @Autowired
    private ProjectsFundingSourceService service;

    @Autowired
    private ProjectsService servicePro;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<ProjectsFundingSource>> listData(){
        List<ProjectsFundingSource> data = service.listAllProjectsFundingSource();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectsFundingSource> getData(@PathVariable("id") Long id){
        ProjectsFundingSource data = service.getProjectsFundingSource(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/project/{id}")
    public ResponseEntity<List<ProjectsFundingSource>> getProject(@PathVariable("id") Long id){
        Projects projects = servicePro.getProjects(id);
        List<ProjectsFundingSource> data = service.findByProjectsId(projects.getId());
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<ProjectsFundingSource> createData(@Valid @RequestBody ProjectsFundingSource data, BindingResult result){

        ProjectsFundingSource dataBD = service.findByProjectsIdAndFundingSourceId(data.getProjects().getId(), data.getFundingSource().getId());


        if (!dataBD.getStatus().equalsIgnoreCase("INACTIVE")){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        if (null != dataBD){
            dataBD.setStatus("MODIFIED");
            dataBD.setLast_update_by(data.getLast_update_by());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.updateProjectsFundingSource(dataBD));
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createProjectsFundingSource(data));
        }


    }

    @PutMapping()
    public ResponseEntity<ProjectsFundingSource> updateData(@Valid @RequestBody ProjectsFundingSource data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        ProjectsFundingSource dataUp = service.updateProjectsFundingSource(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteProjectsFundingSource(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
