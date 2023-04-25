package co.crisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "co.crisi")
public class FamilyGenogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyGenogramApplication.class, args);
    }

}
