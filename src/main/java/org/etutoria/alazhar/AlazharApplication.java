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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
            Role userRole = new Role("USER");
            roleDao.save(userRole);

            // Create users
            User adminUser = new User("admin@example.com", "admin123");
            adminUser.assignRoleToUser(adminRole);
            userDao.save(adminUser);
            User normalUser = new User("user@example.com", "user123");
            normalUser.assignRoleToUser(userRole);
            userDao.save(normalUser);

            // Create tuteurs
            Tuteur tuteur1 = new Tuteur("John", "Doe", "123456789", "john.doe@example.com", "123 Main St");
            tuteurDao.save(tuteur1);
            Tuteur tuteur2 = new Tuteur("Jane", "Doe", "987654321", "jane.doe@example.com", "456 Main St");
            tuteurDao.save(tuteur2);

            // Create annees
            ANNEE annee1 = new ANNEE("2023-2024");
            anneeDao.save(annee1);
            ANNEE annee2 = new ANNEE("2024-2025");
            anneeDao.save(annee2);

            // Create niveaux
            Niveau niveau1 = new Niveau("CM1", 100.0, 50.0, 200.0, 6, 7, "Passer le test d'admission", "Réussir les examens");
            niveauDao.save(niveau1);
            Niveau niveau2 = new Niveau("CM2", 120.0, 60.0, 220.0, 7, 8, "Passer le test d'admission", "Réussir les examens");
            niveauDao.save(niveau2);

            // Create classes
            Classe classe1 = new Classe("CM1A", 30, 15, niveau1);
            classeDao.save(classe1);
            Classe classe2 = new Classe("CM2A", 25, 12, niveau2);
            classeDao.save(classe2);

            // Create instructors
            Instructor instructor1 = new Instructor("Jane", "Smith", "Experienced Math Teacher", "987654321", "jane_smith.jpg", "3000");
            instructor1.setUser(adminUser);
            instructorDao.save(instructor1);
            Instructor instructor2 = new Instructor("John", "Smith", "Experienced Science Teacher", "123456789", "john_smith.jpg", "3200");
            instructor2.setUser(normalUser);
            instructorDao.save(instructor2);

            // Create courses
            Course course1 = new Course("Mathématiques", "1 an", "Cours de mathématiques pour CM1", instructor1, classe1);
            courseDao.save(course1);
            Course course2 = new Course("Sciences", "1 an", "Cours de sciences pour CM2", instructor2, classe2);
            courseDao.save(course2);

            // Create and save inscriptions
            Inscription inscription1 = new Inscription("2023-09-01", "150", "Active", annee1, classe1);
            inscriptionDao.save(inscription1);
            Inscription inscription2 = new Inscription("2024-09-01", "160", "Active", annee2, classe2);
            inscriptionDao.save(inscription2);

            // Create students and assign inscriptions
            Student student1 = new Student("Alice", "Johnson", "2015-05-10", "456 Elm St", "F", tuteur1, adminUser);
            student1.setInscription(inscription1);
            studentDao.save(student1);
            Student student2 = new Student("Bob", "Smith", "2014-04-15", "789 Pine St", "M", tuteur2, normalUser);
            student2.setInscription(inscription2);
            studentDao.save(student2);

            // Create fiches
            FicheEleve fiche1 = new FicheEleve();
            fiche1.setTypeFiche(TypeFiche.ATTESTATION_SCOLAIRE);
            fiche1.setStudent(student1);
            fiche1.setAnnee(annee1);
            ficheDao.save(fiche1);
            FicheEleve fiche2 = new FicheEleve();
            fiche2.setTypeFiche(TypeFiche.ATTESTATION_SCOLAIRE);
            fiche2.setStudent(student2);
            fiche2.setAnnee(annee2);
            ficheDao.save(fiche2);

            // Create matieres
            MatiereCours matiere1 = new MatiereCours();
            matiere1.setMatiereName("Mathématiques");
            matiere1.setMatiereDescription("Description de la matière 1");
            matiere1.setCourse(course1);
            matiereDao.save(matiere1);
            MatiereCours matiere2 = new MatiereCours();
            matiere2.setMatiereName("Sciences");
            matiere2.setMatiereDescription("Description de la matière 2");
            matiere2.setCourse(course2);
            matiereDao.save(matiere2);

            // Create mois
            Mois mois1 = new Mois();
            mois1.setMois("Janvier");
            moisDao.save(mois1);
            Mois mois2 = new Mois();
            mois2.setMois("Février");
            moisDao.save(mois2);

            // Create payments
            Paiement payment1 = new Paiement();
            payment1.setMontant("150.0");
            payment1.setTypePaiement(TypePaiment.FRAIS_SCOLAIRE);
            payment1.setAnnee(annee1);
            payment1.setMois(mois1);
            payment1.setStudent(student1);
            paymentDao.save(payment1);
            Paiement payment2 = new Paiement();
            payment2.setMontant("160.0");
            payment2.setTypePaiement(TypePaiment.FRAIS_SCOLAIRE);
            payment2.setAnnee(annee2);
            payment2.setMois(mois2);
            payment2.setStudent(student2);
            paymentDao.save(payment2);
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}