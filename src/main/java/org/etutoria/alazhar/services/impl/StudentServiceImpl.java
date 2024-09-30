package org.etutoria.alazhar.services.impl;
import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dao.StudentDao;
import org.etutoria.alazhar.dto.*;
import org.etutoria.alazhar.entities.*;
import org.etutoria.alazhar.mapper.*;
import org.etutoria.alazhar.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final UserService userService;
    private final StudentMapper studentMapper;
    private final InscriptionMapper inscriptionMapper;
    private final TuteurMapper tuteurMapper;
    private final StudentDao studentRepository;
    private final InscriptionService inscriptionService;
    private final TuteurService tuteurService;
    private final AnneeService anneeService;
    private final ClasseService classeService;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        logger.info("Starting createStudent method");

        // Create user and assign role
        logger.info("Creating user and assigning role");
        User user = userService.createUser(studentDto.getUser().getEmail(), studentDto.getUser().getPassword());
        userService.assignRoleToUser(user.getEmail(), "USER");

        // Convert StudentDto to Student entity and set the user
        logger.info("Converting StudentDto to Student entity");
        Student student = studentMapper.fromStudentDto(studentDto);
        student.setUser(user);

        // Retrieve or create the year
        logger.info("Retrieving or creating the year");
        AnneeDto annee = anneeService.findOrCreateAnnee(studentDto.getInscription().getAnnee().getAnnee());

        // Retrieve or create the class
        logger.info("Retrieving or creating the class");
        ClasseDto classeDto = studentDto.getInscription().getClasse();
        ClasseDto existingOrNewClasse = classeService.findOrCreateClasse(classeDto.getClassName());

        // Make the inscription
        logger.info("Making the inscription");
        studentDto.getInscription().setAnnee(annee);
        studentDto.getInscription().setClasse(existingOrNewClasse);
        student.setInscription(inscriptionMapper.fromInscriptionDto(
                inscriptionService.createInscription(studentDto.getInscription())));

        // Associate or create a tutor
        logger.info("Associating or creating a tutor");
        if (studentDto.getTuteur() != null) {
            student.setTuteur(tuteurMapper.fromTuteurDto(
                    tuteurService.createTuteur(studentDto.getTuteur())));
        } else {
            // Create a new tutor if not provided
            TuteurDto newTuteurDto = new TuteurDto();
            // Set necessary fields for the new tutor
            student.setTuteur(tuteurMapper.fromTuteurDto(
                    tuteurService.createTuteur(newTuteurDto)));
        }

        // Save the student entity
        logger.info("Saving the student entity");
        Student savedStudent = studentRepository.save(student);

        // Convert the saved Student entity back to StudentDto
        logger.info("Converting the saved Student entity back to StudentDto");
        return studentMapper.fromStudent(savedStudent);
    }
}