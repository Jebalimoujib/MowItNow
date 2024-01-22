package com.mowitnow.demo;

import com.mowitnow.demo.application.ConsoleUi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(DemoApplication.class);
    @Autowired
    private  ConsoleUi consoleUi;

    public static void main(String[] args) throws IOException {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(DemoApplication.class, args);
        LOG.info("APPLICATION FINISHED");

    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");
        consoleUi.printTondeuse();
    }
}
