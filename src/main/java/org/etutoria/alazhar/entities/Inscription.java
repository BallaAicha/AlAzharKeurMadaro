package org.etutoria.alazhar.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "Inscription")
public class Inscription extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateInscription;
    private String montant;
    private String status;

    @ManyToOne
    @JoinColumn(name = "annee_id", nullable = false)
    private ANNEE annee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    private Classe classe;

    @OneToOne(mappedBy = "inscription")
    private Student student;

    public Inscription(String dateInscription, String montant, String status, ANNEE annee, Classe classe) {
        this.dateInscription = dateInscription;
        this.montant = montant;
        this.status = status;
        this.annee = annee;
        this.classe = classe;
    }
}