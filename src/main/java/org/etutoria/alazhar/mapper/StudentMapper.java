package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.StudentDto;
import org.etutoria.alazhar.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentMapper {

    private final UserMapper userMapper;
    private final FicheEleveMapper ficheEleveMapper;
    private final InscriptionMapper inscriptionMapper;
    private final TuteurMapper tuteurMapper;
    private final PaiementMapper paiementMapper;

    public StudentMapper(UserMapper userMapper, FicheEleveMapper ficheEleveMapper, @Lazy InscriptionMapper inscriptionMapper, TuteurMapper tuteurMapper, PaiementMapper paiementMapper) {
        this.userMapper = userMapper;
        this.ficheEleveMapper = ficheEleveMapper;
        this.inscriptionMapper = inscriptionMapper;
        this.tuteurMapper = tuteurMapper;
        this.paiementMapper = paiementMapper;
    }

    public StudentDto fromStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        studentDto.setUser(userMapper.fromUser(student.getUser()));
        studentDto.setFiches(student.getFiches().stream().map(ficheEleveMapper::fromFicheEleve).collect(Collectors.toSet()));
        studentDto.setInscription(inscriptionMapper.fromInscription(student.getInscription()));
        studentDto.setTuteur(tuteurMapper.fromTuteur(student.getTuteur()));
        studentDto.setPaiements(student.getPaiements().stream().map(paiementMapper::fromPaiement).collect(Collectors.toSet()));
        return studentDto;
    }

    public Student fromStudentDto(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setUser(userMapper.fromUserDto(studentDto.getUser()));
        student.setFiches(studentDto.getFiches().stream().map(ficheEleveMapper::fromFicheEleveDto).collect(Collectors.toSet()));
        student.setInscription(inscriptionMapper.fromInscriptionDto(studentDto.getInscription()));
        student.setTuteur(tuteurMapper.fromTuteurDto(studentDto.getTuteur()));
        student.setPaiements(studentDto.getPaiements().stream().map(paiementMapper::fromPaiementDto).collect(Collectors.toSet()));
        return student;
    }
}