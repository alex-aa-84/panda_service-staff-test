package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.TimesheetVersionSelect;
import wwf.org.staff.service.TimesheetVersionSelectService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/timesheetversionselect")
public class TimesheetVersionSelectController {

    @Autowired
    private TimesheetVersionSelectService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimesheetVersionSelect> getData(@PathVariable("id") Long id){
        TimesheetVersionSelect data = service.getTimesheetVersionSelect(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PutMapping()
    public ResponseEntity<TimesheetVersionSelect> updateDate(@Valid @RequestBody TimesheetVersionSelect data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        TimesheetVersionSelect dataUp = service.updateTimesheetVersionSelect(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }


}
