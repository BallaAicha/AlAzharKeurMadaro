package org.etutoria.alazhar.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "Student")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "date_naissance", nullable = false, length = 45)
    private String dateNaissance;

    @Basic
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Basic
    @Column(name = "genre", nullable = false, length = 45)
    private String genre;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Paiement> paiements = new HashSet<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FicheEleve> fiches = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tuteur_id", referencedColumnName = "tuteur_id", nullable = false)
    private Tuteur tuteur;

    @Setter
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "inscription_id", referencedColumnName = "id", nullable = false)
    private Inscription inscription;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public Student(String firstName, String lastName, String dateNaissance, String address, String genre, Tuteur tuteur, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateNaissance = dateNaissance;
        this.address = address;
        this.genre = genre;
        this.tuteur = tuteur;
        this.user = user;
    }

}