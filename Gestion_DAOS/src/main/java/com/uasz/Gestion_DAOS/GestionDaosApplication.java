package com.uasz.Gestion_DAOS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Repository.emploi.BatimentRepository;
import com.uasz.Gestion_DAOS.Repository.repartition.PerRepository;
import com.uasz.Gestion_DAOS.Repository.repartition.VacataireRepository;
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
	@Autowired
	private PerRepository perRepository;
	@Autowired
	private VacataireRepository vacataireRepository;
	@Autowired
	private BatimentRepository batimentRepository;

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
		///////////////////////////////////////////////////////////////////////////////
		
		
		System.out.println("----------------------------------------------------------------");
//
			List<PER> listPer = new ArrayList<PER>();
//
			PER per1 = new PER();
			per1.setMatriculePer("A01");
			per1.setGradeEns("Maitre de conférence");
			per1.setNomEns("FAYE");
			per1.setPrenomEns("Youssou");

			PER per2 = new PER();
			per2.setMatriculePer("A02");
			per2.setGradeEns("Titulaire");
			per2.setNomEns("CISSE");
			per2.setPrenomEns("Papa Alioune");

			PER per3 = new PER();
			per3.setMatriculePer("A03");
			per3.setGradeEns("Maitre de conférence");
			per3.setNomEns("DIENG");
			per3.setPrenomEns("Youssou");


			PER per4 = new PER();
			per4.setMatriculePer("A04");
			per4.setGradeEns("Assistant");
			per4.setNomEns("NDIAYE");
			per4.setPrenomEns("MARIE");

		listPer.add(per1); listPer.add(per2); listPer.add(per3); listPer.add(per4);
		perRepository.saveAll(listPer);
		
		System.out.println("----------------------------------------------------------------");
		List<Vacataire> listVac = new ArrayList<Vacataire>();
		
		Vacataire vac1 = new Vacataire();
		vac1.setSpecialite("Doctorant");
		vac1.setNomEns("MBOUP");
		vac1.setPrenomEns("Mor");
		vac1.setGradeEns("Assistant");

		Vacataire vac2 = new Vacataire();
		vac2.setSpecialite("Doctorant");
		vac2.setNomEns("BAKHOUM");
		vac2.setPrenomEns("Ana");
		vac2.setGradeEns("Assistant");

		Vacataire vac3 = new Vacataire();
		vac3.setSpecialite("Doctorant");
		vac3.setNomEns("GUEYE");
		vac3.setPrenomEns("Assane");
		vac3.setGradeEns("Assistant");

		Vacataire vac4 = new Vacataire();
		vac4.setSpecialite("Doctorant");
		vac4.setNomEns("DIENE");
		vac4.setPrenomEns("Serigne Mbacke");
		vac4.setGradeEns("Assistant");
		listVac.add(vac1); listVac.add(vac2); listVac.add(vac3); listVac.add(vac4);
		vacataireRepository.saveAll(listVac);
		System.out.println("----------------------------------------------------------------");

		List<Batiment> batimentList = new ArrayList<Batiment>();
		Batiment batiment1 = new Batiment();

		// Instanciation 2
		Batiment batiment2 = new Batiment();
		// Instanciation 3 avec des salles
		Batiment batiment3 = new Batiment();
		
		batimentRepository.saveAll(batimentList);
	}

}
