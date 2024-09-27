package org.etutoria.alazhar;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.etutoria.alazhar.dao.*;
import org.etutoria.alazhar.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableSpringDataWebSupport
@OpenAPIDefinition(
        info = @Info(
                title = "AlAzhar Application REST API Documentation",
                description = "AlAzhar App REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Ousmane MBACKE Dev JAVA & Flutter",
                        email = "usmanembacke@gmail.com",
                        url = "https://www.alazharkeurmadaro.org"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.alazharkeurmadaro.org"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "AlAzhar App REST API Documentation",
                url = "https://www.alazharkeurmadaro.org"
        )
)
public class AlazharApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlazharApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            AnneDao anneeDao,
            ClasseDao classeDao,
            CourseDao courseDao,
            FicheDao ficheDao,
            InscriptionDao inscriptionDao,
            InstructorDao instructorDao,
            MatiereDao matiereDao,
            MoisDao moisDao,
            NiveauDao niveauDao,
            PaymentDao paymentDao,
            RoleDao roleDao,
            StudentDao studentDao,
            TuteurDao tuteurDao,
            UserDao userDao) {
        return args -> {
            // Create roles
            Role adminRole = new Role("ADMIN");
            roleDao.save(adminRole);

            // Create user
            User adminUser = new User("admin@example.com", "admin123");
            adminUser.assignRoleToUser(adminRole);
            userDao.save(adminUser);

            // Create tuteur
            Tuteur tuteur1 = new Tuteur("John", "Doe", "123456789", "john.doe@example.com", "123 Main St");
            tuteurDao.save(tuteur1);

            // Create annee
            ANNEE annee1 = new ANNEE("2023-2024");
            anneeDao.save(annee1);

            // Create niveau
            Niveau niveau1 = new Niveau("CM1", 100.0, 50.0, 200.0, 6, 7, "Passer le test d'admission", "Réussir les examens");
            niveauDao.save(niveau1);

            // Create classe
            Classe classe1 = new Classe("CM1A", 30, 15, niveau1);
            classeDao.save(classe1);

            // Create instructor
            Instructor instructor1 = new Instructor("Jane", "Smith", "Experienced Math Teacher", "987654321", "jane_smith.jpg", "3000");
            instructor1.setUser(adminUser);
            instructorDao.save(instructor1);

            // Create course
            Course course1 = new Course("Mathématiques", "1 an", "Cours de mathématiques pour CM1", instructor1, classe1);
            courseDao.save(course1);

            // Create and save inscription
            Inscription inscription1 = new Inscription("2023-09-01", "150", "Active", annee1, classe1);
            inscriptionDao.save(inscription1);

            // Create student and assign inscription
            Student student1 = new Student("Alice", "Johnson", "2015-05-10", "456 Elm St", "F", tuteur1, adminUser);
            student1.setInscription(inscription1);
            studentDao.save(student1);

            // Create fiche
            FicheEleve fiche1 = new FicheEleve();
            fiche1.setTypeFiche(TypeFiche.ATTESTATION_SCOLAIRE);
            fiche1.setStudent(student1);
            fiche1.setAnnee(annee1);
            ficheDao.save(fiche1);

            // Create matiere
            MatiereCours matiere1 = new MatiereCours();
            matiere1.setMatiereName("Mathématiques");
            matiere1.setMatiereDescription("Description de la matière 1");
            matiere1.setCourse(course1);
            matiereDao.save(matiere1);

            // Create mois
            Mois mois1 = new Mois();
            mois1.setMois("Janvier");
            moisDao.save(mois1);

            // Create payment
            Paiement payment1 = new Paiement();
            payment1.setMontant("150.0");
            payment1.setTypePaiement(TypePaiment.FRAIS_SCOLAIRE);
            payment1.setAnnee(annee1);
            payment1.setMois(mois1);
            payment1.setStudent(student1);
            paymentDao.save(payment1);
        };
    }
}