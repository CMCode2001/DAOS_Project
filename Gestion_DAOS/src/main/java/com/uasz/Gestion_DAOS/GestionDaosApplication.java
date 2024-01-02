package com.uasz.Gestion_DAOS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Repository.repartition.PerRepository;
import com.uasz.Gestion_DAOS.Repository.repartition.RepartitionRepository;
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
	@Autowired
	private PerRepository perRepository;
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
		System.out.println("-----------------------------------------------------");
//
			List<PER> repartitions = new ArrayList<PER>();
//
			PER per1 = new PER("A01");
			per1.setGradeEns("Maitre de conférence");
			per1.setNomEns("FAYE");
			per1.setPrenomEns("Youssou");

			PER per2 = new PER("A01");
			per2.setGradeEns("Maitre de conférence");
			per2.setNomEns("FAYE");
			per2.setPrenomEns("Youssou");

			PER per3 = new PER("A01");
			per3.setGradeEns("Maitre de conférence");
			per3.setNomEns("FAYE");
			per3.setPrenomEns("Youssou");

			PER per4 = new PER("A01");
			per4.setGradeEns("Maitre de conférence");
			per4.setNomEns("FAYE");
			per4.setPrenomEns("Youssou");

		repartitions.add(per1); repartitions.add(per2);repartitions.add(per3);repartitions.add(per4);
		perRepository.saveAll(repartitions);

	}

}
