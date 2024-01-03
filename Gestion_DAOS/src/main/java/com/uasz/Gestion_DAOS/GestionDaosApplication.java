package com.uasz.Gestion_DAOS;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Service.maquette.ECService;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GestionDaosApplication implements CommandLineRunner {
	@Autowired
	private UEService ueService;
	@Autowired 
	private ECService ecService;

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}
	
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
		////////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < 5; i++) {
			ueService.ajouterUE(new UE(null, "Libelle "+ i, "Code " + i, i, i, null, new Date(System.currentTimeMillis()), null, null, null));
			
		}
		///////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < 5; i++) {
		ecService.ajouterEC(new EC(null, "Libelle "+ i, "Code " + i, null, null));
		}

	}

}
