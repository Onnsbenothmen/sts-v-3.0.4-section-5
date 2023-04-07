package com.ons.plats;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ons.plats.entities.Plat;
import com.ons.plats.service.PlatService;


@SpringBootApplication
public class PlatsApplication implements CommandLineRunner {
	@Autowired
	PlatService platService;

	public static void main(String[] args) {
		SpringApplication.run(PlatsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	/*platService.savePlat(new Plat("pizza", 2600.0, new Date()));
	platService.savePlat(new Plat("brika", 2800.0, new Date()));
	platService.savePlat(new Plat("crepes", 1100.600, new Date()));*/
	}

}
