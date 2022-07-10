package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.TimesheetCycle;
import wwf.org.staff.service.TimesheetCycleService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/timesheetcicle")
public class TimesheetCycleController {

    @Autowired
    private TimesheetCycleService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<TimesheetCycle>> listData(){
        List<TimesheetCycle> data = service.listAllTimesheetCycle();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimesheetCycle> getData(@PathVariable("id") Long id){
        TimesheetCycle data = service.getTimesheetCycle(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<TimesheetCycle> createData(@Valid @RequestBody TimesheetCycle data, BindingResult result){

        TimesheetCycle dataBD = service.findByFiscalYearAndMonthFiscalYear(data.getFiscalYear(), data.getMonthFiscalYear());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTimesheetCycle(data));
    }

    @PutMapping()
    public ResponseEntity<TimesheetCycle> updateData(@Valid @RequestBody TimesheetCycle data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        TimesheetCycle dataUp = service.updateTimesheetCycle(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteTimesheetCycle(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
