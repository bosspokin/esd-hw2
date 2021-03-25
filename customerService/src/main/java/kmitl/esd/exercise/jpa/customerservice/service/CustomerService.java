package kmitl.esd.exercise.jpa.customerservice.service;

import kmitl.esd.exercise.jpa.customerservice.model.Customer;
import kmitl.esd.exercise.jpa.customerservice.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer service = business logic for customer master data
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository; // Persistence for customer, object injection

    public List<Customer> getAllCustomer() {
        LocalDate now = LocalDate.now();
        List<Customer> customers = new ArrayList<>();

        customerRepository.findAll()
                .forEach(customer -> {
                    updateAge(customer);
                    customers.add(customer);
                });

        return customers;
    }

    public Customer getCustomerById(Long id) { return customerRepository.findById(id).get();}

    public List<Customer> getCustomer(String name) {
        List<Customer> customers = new ArrayList<>();

        customerRepository.findAll()
                .forEach(customer -> {
                    updateAge(customer);
                    customers.add(customer);
                });

        return customers;
    }

    /**
     * save or update (upsert) for customer objects
     * @param customer to be updated or inserted
     */
    public void saveOrUpdate(Customer customer) { customerRepository.save(customer);}

    public void delete(Long id) { customerRepository.deleteById(id);}

    private void updateAge(Customer customer) {
        LocalDate now = LocalDate.now();
        customer.setAge(now.until(customer.getBirthday())
        .getYears());
    }
}
