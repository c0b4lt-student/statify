package cours.cours_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoursSpringBootApplication {

    public static void main(String[] args) {
        System.out.println("Coucou, on lance le premier projet SB !");
        SpringApplication.run(CoursSpringBootApplication.class, args);
    }
}
