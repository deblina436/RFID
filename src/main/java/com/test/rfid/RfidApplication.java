package com.test.rfid;

import java.awt.EventQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RfidApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RfidApplication.class, args);
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpringApplication.run(RfidApplication.class, args);
            }
        });
	}

}
