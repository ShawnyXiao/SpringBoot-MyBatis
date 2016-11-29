package com.shawn;

import com.shawn.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot-MyBatis Application.
 *
 * @author Xiaoyue Xiao
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookMapper bookMapper;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
