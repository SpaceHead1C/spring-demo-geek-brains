package ru.nd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot here for adding http server in application
 */

@SpringBootApplication
public class ApplicationLauncher
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
