package org.etutoria.alazhar.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ANNEE")
public class ANNEE {
    @Id
    @GeneratedValue
    private Long id;
    private String annee;
    public ANNEE(String annee) {
        this.annee = annee;
    }
}