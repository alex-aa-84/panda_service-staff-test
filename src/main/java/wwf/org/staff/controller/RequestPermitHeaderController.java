package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.RequestPermitHeader;
import wwf.org.staff.service.RequestPermitHeaderService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/requestpermitheader")
public class RequestPermitHeaderController {
    @Autowired
    private RequestPermitHeaderService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<RequestPermitHeader>> listData(){
        List<RequestPermitHeader> data = service.listAllRequestPermitHeader();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RequestPermitHeader> getData(@PathVariable("id") Long id){
        RequestPermitHeader data = service.getRequestPermitHeader(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<List<RequestPermitHeader>> getDataUser(@PathVariable("id") Long id){
        List<RequestPermitHeader> data = service.findByUserId(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "numbersolict/{numbersolict}")
    public ResponseEntity<RequestPermitHeader> getDataNumberSolict(@PathVariable("numbersolict") String numbersolict){
        RequestPermitHeader data = service.findByNumberSolict(numbersolict);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "search/{day1}/{month1}/{year1}/{day2}/{month2}/{year2}/{status}/{userId}")
    public ResponseEntity<List<RequestPermitHeader>> getSearch(@PathVariable("day1") Integer day1, @PathVariable("month1") Integer month1, @PathVariable("year1") Integer year1, @PathVariable("day2") Integer day2, @PathVariable("month2") Integer month2, @PathVariable("year2") Integer year2, @PathVariable("status") Integer status, @PathVariable("userId") Long userId){
        
        java.util.Calendar fInicial = java.util.Calendar.getInstance();
        java.util.Calendar fFinal = java.util.Calendar.getInstance();
        if(day1 != 0){
            fInicial.set(java.util.Calendar.YEAR, year1);
            fInicial.set(java.util.Calendar.MONTH, month1);
            fInicial.set(java.util.Calendar.DAY_OF_MONTH, day1);
        }

        if(day2 != 0){
            fFinal.set(java.util.Calendar.YEAR, year2);
            fFinal.set(java.util.Calendar.MONTH, month2);
            fFinal.set(java.util.Calendar.DAY_OF_MONTH, day2);
        }
        
        List<RequestPermitHeader> bd;
       
        if(day1 == 0 && day2 == 0 && status != 0){
            System.out.println("aqui1");
            bd = service.findStatusRequest(status, userId);
        }else if(day1 == 0 && day2 != 0 && status != 0){
            System.out.println("aqui2");
            bd = service.findStatusRequestTo(status, fFinal.getTime(), userId);
        }else if(day1 != 0 && day2 == 0 && status != 0){
            System.out.println("aqui3");
            bd = service.findStatusRequestFrom(status, fInicial.getTime(), userId);
        }else if(day1 != 0 && day2 != 0 && status != 0){
            System.out.println("aqui4");
            bd = service.findStatusRequestFromTo(status, fInicial.getTime(), fFinal.getTime(), userId);
        }else if(day1 != 0 && day2 != 0 && status == 0){
            System.out.println("aqui5");
            System.out.println(fInicial.getTime());
            System.out.println(fFinal.getTime());
            System.out.println("aqui5");
            bd = service.findStatusRequestDate(fInicial.getTime(), fFinal.getTime(), userId);
        }else{
            System.out.println("aqui6");
            bd = service.findStatusRequestPendientes(userId);
        }
        
        return ResponseEntity.ok(bd);
    }

    @PostMapping()
    public ResponseEntity<RequestPermitHeader> createData(@Valid @RequestBody RequestPermitHeader data, BindingResult result){

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRequestPermitHeader(data));
    }

    @PutMapping()
    public ResponseEntity<RequestPermitHeader> updateData(@Valid @RequestBody RequestPermitHeader data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        RequestPermitHeader dataUp = service.updateRequestPermitHeader(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteRequestPermitHeader(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
