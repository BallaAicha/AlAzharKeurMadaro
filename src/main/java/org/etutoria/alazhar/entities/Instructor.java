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
@Table(name = "instructors")
public class Instructor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Long instructorId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "summary", nullable = false, length = 64)
    private String summary;
    @Basic
    @Column(name = "phone", nullable = false, length = 45)
    private String phone;
    @Basic
    @Column(name = "photo", nullable = false, length = 45)
    private String photo;
    @Basic
    @Column(name = "salary", nullable = false, length = 45)
    private String salary;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
    public Instructor(String firstName, String lastName, String summary, String phone, String photo, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.summary = summary;
        this.phone = phone;
        this.photo = photo;
        this.salary = salary;
    }

}
