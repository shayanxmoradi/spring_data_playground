package org.example.springcw;

import org.example.springcw.Service.StudentService;
import org.example.springcw.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringCwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCwApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentService studentService) {
        return args -> {
            studentService.findAll()
                    .forEach(System.out::println);
            System.out.println();
            List<Student> studentList = studentService.searchByName("shayan");
            System.out.printf("serarch res \n : " +
                              (studentList.isEmpty() ? "empty" : studentList.toString()));
            System.out.println();
        };
    }
}
