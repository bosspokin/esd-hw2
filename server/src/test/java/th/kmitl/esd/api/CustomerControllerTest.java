package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        customerController = new CustomerController();
    }

    @Test
    void getAllCustomers() {
        assertNotNull(customerController.getAllCustomers());
    }

    @Test
    void createCustomer() {
        CustomerDTO customerToBeCreated = customerController.createCustomer(new CustomerDTO(1L, "TestName", 23L));
        assertNotNull(customerToBeCreated);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerToBeUpdated = customerController.updateCustomer(new CustomerDTO(1L, "TestName", 23L));
        assertNotNull(customerToBeUpdated);
    }

    @Test
    void deleteCustomer() {
        boolean successful = customerController.deleteCustomer(1L);
        assertTrue(successful);
    }
}