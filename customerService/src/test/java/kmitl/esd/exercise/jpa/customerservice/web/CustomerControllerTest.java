package kmitl.esd.exercise.jpa.customerservice.web;

import kmitl.esd.exercise.jpa.customerservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
public class CustomerControllerTest {
    @Autowired
    private CustomerController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer(1L, "Tom", 35);
//        Long id = this.restTemplate.postForObject()
    }
}
