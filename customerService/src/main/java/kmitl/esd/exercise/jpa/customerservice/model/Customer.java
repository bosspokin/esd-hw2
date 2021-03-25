package kmitl.esd.exercise.jpa.customerservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Customer entity for persistence
 * javax persistence -> JPA -> Impl.: Hibernate -> Spring JPA includes Hibernate
 */
@Entity
@Table // class name is table name
@NoArgsConstructor // lombok creates constructor with no args
@Getter @Setter // lombok: Getter and setter for all properties
public class Customer {
    @Id // primary key in DB
    @Column
    private Long id; // id is primary key

    @Column
    @NotNull
    @Size(min = 3, max =240) // constraint: name is min. 3 char and max. 240 char
    private String name; // customer name

    @Transient
    private String tempRemark;

    @Column
    @Min(18)
    @Max(120) // age of a person is between 18 and 120
    @Transient // value will not be saved in the DB
    private int age; // age in years

    @Column
    @Past
    private LocalDate birthday;

    @Column
    @Pattern(regexp="\\(?\\d{0,3}\\)?\\d{3}--\\d{4}")
    private String phoneNumber;

    @Column
    @Pattern(regexp = ".*@.*\\..*")
    private String email; // customer's main email address

    @Column
    @Past // creation of a customer must be in the past
    private LocalDateTime creationDateTime;

    /**
     * Constructor with customer data: name and age
     * @param name name of the customer
     * @param age age in years
     */
    public Customer(@Size(min = 3, max = 240) String name, @Min(18) @Max(120) int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructor with main customer data
     * @param id customer id
     * @param name name of the customer
     * @param age age in years
     */
    public Customer(Long id, @Size(min = 3, max = 240) String name, @Min(18) @Max(120) int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
