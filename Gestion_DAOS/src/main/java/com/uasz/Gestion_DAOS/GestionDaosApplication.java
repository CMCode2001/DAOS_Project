package com.uasz.Gestion_DAOS;

import java.util.ArrayList;
import java.util.List;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Modele.Constante.Jour;
import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Modele.emploi.Deroulement;
import com.uasz.Gestion_DAOS.Modele.emploi.Emploi;
import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Service.emploi.BatimentService;
import com.uasz.Gestion_DAOS.Service.emploi.DeroulementService;
import com.uasz.Gestion_DAOS.Service.emploi.EmploiService;
import com.uasz.Gestion_DAOS.Service.emploi.SalleService;
import com.uasz.Gestion_DAOS.Service.emploi.SeanceService;
import com.uasz.Gestion_DAOS.Service.maquette.ECService;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;
import com.uasz.Gestion_DAOS.Service.repartition.PerService;
import com.uasz.Gestion_DAOS.Service.repartition.RepartitionService;
import com.uasz.Gestion_DAOS.Service.repartition.VacataireService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GestionDaosApplication implements CommandLineRunner {
	@Autowired
	private UEService ueService;
	@Autowired 
	private ECService ecService;
	@Autowired
	private PerService perService;
	@Autowired
	private VacataireService vacataireService;
	@Autowired
	private DeroulementService deroulementService;
	@Autowired
	private EmploiService emploiService;
	@Autowired
	private SalleService salleService;
	@Autowired
	private SeanceService seanceService;
	@Autowired
	private BatimentService batimentService;
	@Autowired
	private RepartitionService repartitionService;

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
		//perRepository.saveAll(listPer);
		perService.ajouterPer(per1);
		perService.ajouterPer(per2);
		perService.ajouterPer(per3);
		perService.ajouterPer(per4);

		
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
		vacataireService.ajouter_vacataire(vac1);		
		vacataireService.ajouter_vacataire(vac2);		
		vacataireService.ajouter_vacataire(vac3);		
		vacataireService.ajouter_vacataire(vac4);	

		System.out.println("----------------------------------------------------------------");

		List<Batiment> batimentList = new ArrayList<Batiment>();
		Batiment batiment1 = new Batiment();
		batiment1.setCodeBatiment("BAT 01");
		batiment1.setLibelleBatiment("Batiment InfoLAB ");
		batiment1.setDescriptionBatiment("Batiment réservé au Etudiant Informatique");
		batiment1.setPositionBatiment("Côté EST ");
		// Instanciation 2
		Batiment batiment2 = new Batiment();
		batiment2.setCodeBatiment("BAT 02");
		batiment2.setLibelleBatiment("Batiment LABO-SUP ");
		batiment2.setDescriptionBatiment("Batiment réservé au Etudiant Physique-Chimie");
		batiment2.setPositionBatiment("Côté OUEST ");
		// Instanciation 3 avec des salles
		Batiment batiment3 = new Batiment();
		batiment3.setCodeBatiment("BAT 03");
		batiment3.setLibelleBatiment("Batiment E ");
		batiment3.setDescriptionBatiment("Batiment réservé aux Etudiants ");
		batiment3.setPositionBatiment("Côté NORD ");

		Batiment batiment4 = new Batiment();
		batiment4.setCodeBatiment("BAT 04");
		batiment4.setLibelleBatiment("Batiment D ");
		batiment4.setDescriptionBatiment("Batiment réservé aux Etudiants ");
		batiment4.setPositionBatiment("Côté SUD ");
		
		batimentList.add(batiment1); batimentList.add(batiment2); 
		batimentList.add(batiment3); batimentList.add(batiment4);
		batimentService.ajouterBat(batiment1);
		batimentService.ajouterBat(batiment2);
		batimentService.ajouterBat(batiment3);
		batimentService.ajouterBat(batiment4);

		System.out.println("----------------------------------------------------------------");

				// Instance initiale
		Deroulement deroulement1 = new Deroulement();
		deroulement1.setObjectifsDeroulement("Objectifs du déroulement 1");
		deroulement1.setDescriptionDeroulement("Description du déroulement 1");
		
		// Création de quatre nouvelles instances avec des valeurs dupliquées
		Deroulement deroulement2 = new Deroulement();
		deroulement2.setObjectifsDeroulement("Objectifs du déroulement 2");
		deroulement2.setDescriptionDeroulement("Description du déroulement 2");
		

		Deroulement deroulement3 = new Deroulement();
		deroulement3.setObjectifsDeroulement("Objectifs du déroulement 3");
		deroulement3.setDescriptionDeroulement("Description du déroulement 3");
		

		Deroulement deroulement4 = new Deroulement();
		deroulement4.setObjectifsDeroulement("Objectifs du déroulement 4");
		deroulement4.setDescriptionDeroulement("Description du déroulement 4");
		

		Deroulement deroulement5 = new Deroulement();
		deroulement5.setObjectifsDeroulement("Objectifs du déroulement 5");
		deroulement5.setDescriptionDeroulement("Description du déroulement 5");
		
		deroulementService.ajouter_Deroulement(deroulement1);
		deroulementService.ajouter_Deroulement(deroulement2);
		deroulementService.ajouter_Deroulement(deroulement3);
		deroulementService.ajouter_Deroulement(deroulement4);
		deroulementService.ajouter_Deroulement(deroulement5);

		System.out.println("----------------------------------------------------------------");

		// Instance initiale
		Emploi emploi1 = new Emploi();
		emploi1.setDureeEmploi(10);
		// Création de quatre nouvelles instances avec des valeurs dupliquées
		Emploi emploi2 = new Emploi();
		emploi2.setDureeEmploi(5);

		Emploi emploi3 = new Emploi();
		emploi3.setDureeEmploi(7);

		Emploi emploi4 = new Emploi();
		emploi4.setDureeEmploi(8);

		Emploi emploi5 = new Emploi();
		emploi5.setDureeEmploi(6);

		emploiService.ajouter_emploi(emploi1);
		emploiService.ajouter_emploi(emploi2);
		emploiService.ajouter_emploi(emploi3);
		emploiService.ajouter_emploi(emploi4);
		emploiService.ajouter_emploi(emploi5);

		System.out.println("----------------------------------------------------------------");

				// Instance initiale

		// Création de quatre nouvelles instances avec des valeurs dupliquées
		Salle salle1 = new Salle();
		salle1.setLibelleSalle("Salle de conférence");
		salle1.setCodeSalle("S001");
		salle1.setCapaciteSalle(100);
		salle1.setDescriptionSalle("Salle de conférence équipée pour les présentations");

		Salle salle2 = new Salle();
		salle2.setLibelleSalle("Salle de formation");
		salle2.setCodeSalle("S002");
		salle2.setCapaciteSalle(30);
		salle2.setDescriptionSalle("Salle de formation équipée pour les sessions de formation");
		

		Salle salle3 = new Salle();
		salle3.setLibelleSalle("Salle de réception");
		salle3.setCodeSalle("S003");
		salle3.setCapaciteSalle(200);
		salle3.setDescriptionSalle("Salle de réception pour les événements spéciaux");
		

		Salle salle4 = new Salle();
		salle4.setLibelleSalle("Salle polyvalente");
		salle4.setCodeSalle("S004");
		salle4.setCapaciteSalle(80);
		salle4.setDescriptionSalle("Salle polyvalente adaptée à divers usages");
		

		Salle salle5 = new Salle();
		salle5.setLibelleSalle("Salle de réunion");
		salle5.setCodeSalle("S005");
		salle5.setCapaciteSalle(50);
		salle5.setDescriptionSalle("Salle de réunion pour les réunions d'équipe");
		
		salleService.ajouter_Salle(salle1);
		salleService.ajouter_Salle(salle2);
		salleService.ajouter_Salle(salle3);
		salleService.ajouter_Salle(salle4);
		salleService.ajouter_Salle(salle5);

		System.out.println("----------------------------------------------------------------");
				// Instance initiale
		// Date de création de la séance

		// Création de quatre nouvelles instances avec des valeurs dupliquées
		Seance seance1 = new Seance();
		seance1.setJourSeance(Jour.LUNDI); // Remplacer par le jour de la semaine souhaité
		seance1.setDureeSeance(90);
		seance1.setDebutSeance(10);
		seance1.setFinSeance(11);
		seance1.setNumeroSeance(2);
		seance1.setEmploi(emploi1);

		Seance seance2 = new Seance();
		seance2.setJourSeance(Jour.MARDI);
		seance2.setDureeSeance(120);
		seance2.setDebutSeance(14);
		seance2.setFinSeance(16);
		seance2.setNumeroSeance(3);
		seance2.setEmploi(emploi2);


		Seance seance3 = new Seance();
		seance3.setJourSeance(Jour.MERCREDI);
		seance3.setDureeSeance(90);
		seance3.setDebutSeance(9);
		seance3.setFinSeance(10);
		seance3.setNumeroSeance(4);	
		seance3.setEmploi(emploi3);

		Seance seance4 = new Seance();
		seance4.setJourSeance(Jour.JEUDI);
		seance4.setDureeSeance(120);
		seance4.setDebutSeance(13);
		seance4.setFinSeance(15);
		seance4.setNumeroSeance(5);
		seance4.setEmploi(emploi4);


		Seance seance5 = new Seance();
		seance5.setJourSeance(Jour.VENDREDI);
		seance5.setDureeSeance(60); // Durée de la séance en minutes
		seance5.setDebutSeance(8); // Heure de début de la séance (en heures, ex: 8 pour 8h00)
		seance5.setFinSeance(9); // Heure de fin de la séance (en heures, ex: 9 pour 9h00)
		seance5.setNumeroSeance(1); // Numéro de la séance
		seance5.setEmploi(emploi5);
		
		seanceService.ajouter_Seance(seance1);
		seanceService.ajouter_Seance(seance2);
		seanceService.ajouter_Seance(seance3);
		seanceService.ajouter_Seance(seance4);
		seanceService.ajouter_Seance(seance5);


		System.out.println("----------------------------------------------------------------");
		Repartition repartition1 = new Repartition();
		repartition1.setDescriptionRepartition("Description de la répartition 1");
		

		Repartition repartition2 = new Repartition();
		repartition2.setDescriptionRepartition("Description de la répartition 2");
		

		Repartition repartition3 = new Repartition();
		repartition3.setDescriptionRepartition("Description de la répartition 3");
		

		Repartition repartition4 = new Repartition();
		repartition4.setDescriptionRepartition("Description de la répartition 4");
		

		Repartition repartition5 = new Repartition();
		repartition5.setDescriptionRepartition("Description de la répartition 5");
		
		repartitionService.ajouter_repartition(repartition1);
		repartitionService.ajouter_repartition(repartition2);
		repartitionService.ajouter_repartition(repartition3);
		repartitionService.ajouter_repartition(repartition4);
		repartitionService.ajouter_repartition(repartition5);

		System.out.println("----------------------------------------------------------------");
		// Création d'instances de la classe UE
		UE ue1 = new UE();
		ue1.setLibelleUE("Mathématiques");
		ue1.setCodeUE("MATH101");
		ue1.setCreditUE(6);
		ue1.setCoefficientUE(3);
		ue1.setDescriptionUE("Cours avancé de mathématiques");


		UE ue2 = new UE();
		ue2.setLibelleUE("Physique");
		ue2.setCodeUE("PHYS101");
		ue2.setCreditUE(6);
		ue2.setCoefficientUE(3);
		ue2.setDescriptionUE("Cours avancé de physique");


		UE ue3 = new UE();
		ue3.setLibelleUE("Informatique");
		ue3.setCodeUE("INFO101");
		ue3.setCreditUE(6);
		ue3.setCoefficientUE(3);
		ue3.setDescriptionUE("Cours avancé d'informatique");


		UE ue4 = new UE();
		ue4.setLibelleUE("Chimie");
		ue4.setCodeUE("CHIM101");
		ue4.setCreditUE(6);
		ue4.setCoefficientUE(3);
		ue4.setDescriptionUE("Cours avancé de chimie");

		ueService.ajouter_UE(ue1);
		ueService.ajouter_UE(ue2);
		ueService.ajouter_UE(ue3);
		ueService.ajouter_UE(ue4);

		// System.out.println("----------------------------------------------------------------");
		// System.out.println("----------------------------------------------------------------");
		// System.out.println("----------------------------------------------------------------");



	}

}
