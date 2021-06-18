package miniBankProgekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//System.out.println("Запускаем  SpringApplication");
		SpringApplication.run(DemoApplication.class, args);
	//	System.out.println("Можно идти проверять страницу: http://localhost:8080/");
	}
}
