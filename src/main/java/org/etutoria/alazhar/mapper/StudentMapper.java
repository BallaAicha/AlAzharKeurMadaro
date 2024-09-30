package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.StudentDto;
import org.etutoria.alazhar.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    private final UserMapper userMapper;
    private final InscriptionMapper inscriptionMapper;
    private final TuteurMapper tuteurMapper;

    public StudentMapper(
            @Lazy UserMapper userMapper,
            @Lazy InscriptionMapper inscriptionMapper,
            @Lazy TuteurMapper tuteurMapper) {
        this.userMapper = userMapper;
        this.inscriptionMapper = inscriptionMapper;
        this.tuteurMapper = tuteurMapper;
    }

    public StudentDto fromStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        studentDto.setUser(userMapper.fromUser(student.getUser()));
        studentDto.setInscription(inscriptionMapper.fromInscription(student.getInscription()));
        studentDto.setTuteur(tuteurMapper.fromTuteur(student.getTuteur()));
        return studentDto;
    }

    public Student fromStudentDto(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setUser(userMapper.fromUserDto(studentDto.getUser()));
        student.setInscription(inscriptionMapper.fromInscriptionDto(studentDto.getInscription()));
        student.setTuteur(tuteurMapper.fromTuteurDto(studentDto.getTuteur()));
        return student;
    }
}