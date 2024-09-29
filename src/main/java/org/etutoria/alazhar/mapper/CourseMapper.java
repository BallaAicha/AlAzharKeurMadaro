package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.CourseDto;
import org.etutoria.alazhar.entities.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseMapper {

    private final MatiereCoursMapper matiereCoursMapper;
    private final ClasseMapper classeMapper;

    public CourseMapper(@Lazy MatiereCoursMapper matiereCoursMapper, @Lazy ClasseMapper classeMapper) {
        this.matiereCoursMapper = matiereCoursMapper;
        this.classeMapper = classeMapper;
    }

    public CourseDto fromCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseDto courseDto = new CourseDto();
        BeanUtils.copyProperties(course, courseDto);
        courseDto.setInstructorId(course.getInstructor().getInstructorId());
        courseDto.setMatiereCours(course.getMatiereCours().stream()
                .map(matiereCoursMapper::fromMatiereCours)
                .collect(Collectors.toSet()));
        // Avoid circular reference by not setting classe here
        return courseDto;
    }

    public Course fromCourseDto(CourseDto courseDto) {
        if (courseDto == null) {
            return null;
        }
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        // Handle instructor mapping separately to avoid circular reference
        course.setMatiereCours(courseDto.getMatiereCours().stream()
                .map(matiereCoursMapper::fromMatiereCoursDto)
                .collect(Collectors.toSet()));
        // Avoid circular reference by not setting classe here
        return course;
    }
}