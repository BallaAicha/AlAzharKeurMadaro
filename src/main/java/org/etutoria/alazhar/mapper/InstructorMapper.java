package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.InstructorDto;
import org.etutoria.alazhar.entities.Instructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InstructorMapper {

    private final UserMapper userMapper;

    public InstructorMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public InstructorDto fromInstructor(Instructor instructor) {
        if (instructor == null) {
            return null;
        }
        InstructorDto instructorDto = new InstructorDto();
        BeanUtils.copyProperties(instructor, instructorDto);
        instructorDto.setUser(userMapper.fromUser(instructor.getUser()));
        instructorDto.setCourseIds(instructor.getCourses().stream()
                .map(course -> course.getCourseId())
                .collect(Collectors.toSet()));
        return instructorDto;
    }

    public Instructor fromInstructorDto(InstructorDto instructorDto) {
        if (instructorDto == null) {
            return null;
        }
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDto, instructor);
        instructor.setUser(userMapper.fromUserDto(instructorDto.getUser()));
        // Handle course mapping separately to avoid circular reference
        return instructor;
    }
}