package wwf.org.staff.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wwf.org.staff.model.User;

@FeignClient(name="service-tenant", url = "http://192.168.1.100:8080/tenantApiTs-v1.3")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/tenants/user/{id}")
    User getUser(@PathVariable("id") Long id);
}
