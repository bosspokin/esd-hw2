package kmitl.esd.exercise.jpa.customerservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table // class name is table name
@NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q ORDER BY q.customer.id, q.id")
@NamedQuery(name = "Quotation.findByCustomerId", query = "SELECT q FROM Quotation q WHERE q.customer.id = :customerId ORDER by q.id")
@NoArgsConstructor // create constructor with no args
@Getter
@Setter // Getter and setter for all properties
public class Quotation {
    @Id
    @Column
    private Long id; // id is primary key

    @Column
    @NotNull
    @Size(min = 3, max = 240)
    private String reference; // quote name

    @ManyToOne // a quote has ONE customer ,a customer has MANY quotes
//    @NotNull
    private Customer customer; // a quote has ONE customer, a customer has many quotes

    @NotNull
    @Min(0)
    private float price;

    @Column
    @Past
    private LocalDateTime creationDateTime;

    @Column
    private LocalDateTime saveDateTime;

    @Column
    @Future // constraint for temporal field: valid TS must be in the future
    private LocalDateTime validUntilDateTime;

    @PreUpdate
    @PrePersist
    public void setSaveTimeStamp() {
        this.saveDateTime = LocalDateTime.now();
    }
}
