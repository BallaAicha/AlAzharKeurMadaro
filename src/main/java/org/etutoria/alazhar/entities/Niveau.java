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
@Table(name = "niveaux")
public class Niveau extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long niveauId;
    @Basic
    @Column(name = "niveau_name", nullable = false, length = 45)
    private String niveauName;
    @Basic
    @Column(name = "mensualite", nullable = false)
    private double mensualite;
    @Basic
    @Column(name = "frais_inscription", nullable = false)
    private double fraisInscription;
    @Basic
    @Column(name = "frais_scolarite", nullable = false)
    private double fraisScolarite;
    @Basic
    @Column(name = "age_min", nullable = false)
    private int ageMin;
    @Basic
    @Column(name = "age_max", nullable = false)
    private int ageMax;
    @Basic
    @Column(name = "critere_admission", nullable = false, length = 45)
    private String critereAdmission;
    @Basic
    @Column(name = "critere_passage", nullable = false, length = 45)
    private String criterePassage;
    @OneToMany(mappedBy = "niveau", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Classe> classes = new HashSet<>();
    public Niveau(String niveauName, double mensualite, double fraisInscription, double fraisScolarite, int ageMin, int ageMax, String critereAdmission, String criterePassage) {
        this.niveauName = niveauName;
        this.mensualite = mensualite;
        this.fraisInscription = fraisInscription;
        this.fraisScolarite = fraisScolarite;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.critereAdmission = critereAdmission;
        this.criterePassage = criterePassage;
    }


}