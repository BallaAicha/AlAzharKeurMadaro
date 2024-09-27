package org.etutoria.alazhar.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "courses")
public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    @Basic
    @Column(name = "course_name", nullable = false, length = 45)
    private String courseName;
    @Basic
    @Column(name = "course_duration", nullable = false, length = 45)
    private String courseDuration;
    @Basic
    @Column(name = "course_description", nullable = false, length = 64)
    private String courseDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id", nullable = false)
    private Instructor instructor;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatiereCours> matiereCours = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    private Classe classe;

    public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor, Classe classe) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
        this.classe = classe;
    }
}