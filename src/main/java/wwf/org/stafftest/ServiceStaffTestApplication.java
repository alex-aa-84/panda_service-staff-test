package wwf.org.stafftest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceStaffTestApplication implements CommandLineRunner {


	public static void main(String[] args) {



		SpringApplication.run(ServiceStaffTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (String argValue : args){
			System.out.println("Parametro es: " + argValue);
		}
	}
}
