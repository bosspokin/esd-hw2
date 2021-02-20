
package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * Web service exercise for customer CRUD operations
 * Produce endpoints as a part of the server API
 * Controller reacts to requests, controls the workflow, and gives response
 * RESTful webservice -> HTTP method calls
 * Data format for data objects is JSON
 *
 * Why the Customer Controller is called a controller
 * Answer 1.0: Because Spring Framework named it liek this :)
 * Answer 2.0: Why not web service reequest handler, REST HTTP responder, or API endpoints implementer ...?
 * Answer 3.0: Web Service API Controller, because it handles (=control) the request ofo client and provides a response
 *             = it is in charge of the API = it controls the API
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final AtomicLong counter = new AtomicLong();
    private final static Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    // ToDo test "database"
    private static List<CustomerDTO> customers = new ArrayList<>(); // ToDo map

    // ToDo test replace with connection to database
    static {
        CustomerDTO customerTom = new CustomerDTO(1L, "Tom", 35L);
        CustomerDTO customerSuzi = new CustomerDTO(2L, "Suzi", 53L);
        customers.add(customerTom);
        customers.add(customerSuzi);
    }

    /**
     * REST web service endpoint Read = find customers
     * GET (HTTP) method for finding all customers
     * Example: localhost:9090/customer/findall
     * @return list of all customers
     */
    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomers() {
        LOGGER.info("Client request for all customers");
        return customers;
    }

    /**
     * Create a customer
     * @param customer as a request body
     * @return the saved version of the customer or null if not successful
     */
    @PostMapping
    // ToDo how we can consume JSON objects as a body??? -> @RequestBody
    public CustomerDTO createCustomer(CustomerDTO customer) {
        customers.add(customer);
        LOGGER.info("Creating a new customer");
        return customer;
    }

    /**
     * update / modify a customer
     * @param customer as a req. body
     * @return the update customer object or null if not successful
     */
    @PutMapping
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        CustomerDTO customerToBeUpdated = customers.stream().filter(c -> c.getId().equals(customer.getId())).
                findFirst().get();

        if (customerToBeUpdated != null) {
            customers.remove(customerToBeUpdated);
        } else {
            return null; // no customer found for the update (We should return something else not null)
        }
        customers.add(customer);

        LOGGER.info("Updating a customer");
        return customer;
    }

    /**
     * Delete a customer
     * @param customerId id of the customer
     * @return true ifdelted, false if not found
     */
    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long customerId) {
        CustomerDTO customerToBeDeleted = customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
        if (customerToBeDeleted != null) {
            customers.remove(customerToBeDeleted);
            LOGGER.info("deleting a customer");
            return true;
        } else {
            LOGGER.info("Deletion is failed");
            return false;
        }
    }
}