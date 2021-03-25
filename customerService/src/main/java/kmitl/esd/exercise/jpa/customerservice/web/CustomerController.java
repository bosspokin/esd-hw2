package kmitl.esd.exercise.jpa.customerservice.web;

import kmitl.esd.exercise.jpa.customerservice.model.Customer;
import kmitl.esd.exercise.jpa.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API for customers (RestController)
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService; // Business logic

    /**
     * creating a get mapping that retrieves all the customer details from the database
     * @return list of customer objects as JSOM
     */
    @GetMapping("/customer")
    private List<Customer> getAllCustomer() { return customerService.getAllCustomer(); }

    // creating a get mapping that retrieves the detail of a specific customer
    @GetMapping("/customer/{id}")
    private Customer getCustomer(@PathVariable("id") Long id) { return customerService.getCustomerById(id);}

    // creating a delete mapping that deletes a specific customer
    @DeleteMapping("/customer/{id}")
    private void deleteCustomer(@PathVariable("id") Long id) {customerService.delete(id); }

    /**
     * creating post mapping that post the customer detail in the database
     * via the service (business logic) and the repository (persistence)
     * @param customer JSON object
     * @return the id (unique identifier) for the customer
     */
    @PostMapping("/customer")
    private Long saveCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);

        return customer.getId();
    }
}
