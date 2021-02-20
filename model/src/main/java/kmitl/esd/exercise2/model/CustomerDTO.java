package kmitl.esd.exercise2.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerDTO implements Serializable {
    private Long id; // unique id
    private String name; // name of the customer
    private Long age; //age in years
    private String remark; // free text for customer

    public CustomerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerDTO(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CustomerDTO() {};

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }
}
