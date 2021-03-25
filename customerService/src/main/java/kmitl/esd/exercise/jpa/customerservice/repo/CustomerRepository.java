package kmitl.esd.exercise.jpa.customerservice.repo;

import kmitl.esd.exercise.jpa.customerservice.model.Customer;
import kmitl.esd.exercise.jpa.customerservice.model.Quotation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Persistence for customers
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    /**
     * Find customers by name and order by name
     * @param name of customers to find
     * @return customers with the name or empty list
     */
    List<Customer> findByNameOrderByName(String name);
}
