package com.uasz.Gestion_DAOS;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}
	@Autowired
	private UEService ueService;
	@Override

	public void run(String... args) throws Exception{
		log.info("\n\n"+
				"╔═╗╔═╗╔═╗╦  ╦╔═╗╔═╗╔╦╗╦╔═╗╔╗╔\n" +
				"╠═╣╠═╝╠═╝║  ║║  ╠═╣ ║ ║║ ║║║║\n" +
				"╩ ╩╩  ╩  ╩═╝╩╚═╝╩ ╩ ╩ ╩╚═╝╝╚╝\n" +
				"          ╦╔═╗               \n" +
				"          ║╚═╗               \n" +
				"          ╩╚═╝               \n" +
				"╔═╗╔╦╗╔═╗╦═╗╔╦╗╦╔╗╔╔═╗       \n" +
				"╚═╗ ║ ╠═╣╠╦╝ ║ ║║║║║ ╦       \n" +
				"╚═╝ ╩ ╩ ╩╩╚═ ╩ ╩╝╚╝╚═╝oooooo \n" +
				"                             \n" +
				"                             \n"
		);
		ueService.ajouterUE(new UE(
				null,
				"Reseaux & Telecoms",
				"INF351",
				3,
				2,
				new Date(System.currentTimeMillis()),
				null,
				null,
				null
		));
		ueService.ajouterUE(new UE(
				null,
				"Genies Logicielles",
				"INF351",
				3,
				2,
				new Date(System.currentTimeMillis()),
				null,
				null,
				null
		));
		ueService.ajouterUE(new UE(
				null,
				"Administration Systeme",
				"INF342",
				3,
				2,
				new Date(System.currentTimeMillis()),
				null,
				null,
				null
		));
		ueService.ajouterUE(new UE(
				null,
				"Anglais",
				"INF351",
				
				3,
				2,
				new Date(System.currentTimeMillis()),
				null,
				null,
				null
		));
		ueService.ajouterUE(new UE(
				null,
				"Base de donnees",
				"INF351",
				3,
				2,
				new Date(System.currentTimeMillis()),
				null,
				null,
				null
		));




	}

}
