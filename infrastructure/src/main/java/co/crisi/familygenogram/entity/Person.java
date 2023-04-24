package co.crisi.familygenogram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "person")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private Long id;

    @Column(name = "personal_id")
    @Include
    private Long personalId;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "mother_id")
    private Person mother;

    @OneToOne
    @JoinColumn(name = "father_id")
    private Person father;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}
