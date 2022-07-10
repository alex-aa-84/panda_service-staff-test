package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.TimesheetWipStatus;
import wwf.org.staff.service.TimesheetWipStatusService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/timesheetwipstatus")
public class TimesheetWipStatusController {

    @Autowired
    private TimesheetWipStatusService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<TimesheetWipStatus>> listData(){
        List<TimesheetWipStatus> data = service.listAllTimesheetWipStatus();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimesheetWipStatus> getData(@PathVariable("id") Long id){
        TimesheetWipStatus data = service.getTimesheetWipStatus(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<TimesheetWipStatus> createData(@Valid @RequestBody TimesheetWipStatus data, BindingResult result){

        TimesheetWipStatus dataBD = service.findByTimesheetWipStatus(data.getTimesheetWipStatus());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTimesheetWipStatus(data));
    }

    @PutMapping()
    public ResponseEntity<TimesheetWipStatus> updateData(@Valid @RequestBody TimesheetWipStatus data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        TimesheetWipStatus dataUp = service.updateTimesheetWipStatus(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteTimesheetWipStatus(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
