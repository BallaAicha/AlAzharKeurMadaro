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
@Table(name = "Mois")
public class Mois {
    @Id
    @GeneratedValue
    private Long id;
    private String mois;
}