package co.edu.javeriana.discovery.pica.inspection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PicaInspectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicaInspectionApplication.class, args);
	}

}
