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
@Table(name = "Paiement")
public class Paiement  extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String montant;
    @Enumerated(EnumType.STRING)
    private TypePaiment typePaiement;
    @ManyToOne
    @JoinColumn(name = "annee_id", nullable = false)
    private ANNEE annee;
    @ManyToOne
    @JoinColumn(name = "mois_id", nullable = false)
    private Mois mois;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

}