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
@Table(name = "classes")
public class Classe extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private Long classId;
    @Basic
    @Column(name = "class_name", nullable = false, length = 45)
    private String className;
    @Basic
    @Column(name = "class_size", nullable = false)
    private int classSize;
    @Basic
    @Column(name = "class_bench", nullable = false)
    private int classBench;
    @OneToMany(mappedBy = "classe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
    @OneToMany(mappedBy = "classe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "niveau_id", referencedColumnName = "niveauId", nullable = false)
    private Niveau niveau;


    public Classe(String className, int classSize, int classBench, Niveau niveau) {
        this.className = className;
        this.classSize = classSize;
        this.classBench = classBench;
        this.niveau = niveau;
    }
}