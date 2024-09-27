package org.etutoria.alazhar.entities;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "matiere_cours")
public class MatiereCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matiere_cours_id", nullable = false)
    private Long matiereCoursId;
    @Basic
    @Column(name = "matiere_name", nullable = false, length = 45)
    private String matiereName;
    @Basic
    @Column(name = "matiere_description", nullable = false, length = 64)
    private String matiereDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;
}