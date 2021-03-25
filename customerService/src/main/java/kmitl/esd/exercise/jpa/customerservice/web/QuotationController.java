package kmitl.esd.exercise.jpa.customerservice.web;

import kmitl.esd.exercise.jpa.customerservice.model.Quotation;
import kmitl.esd.exercise.jpa.customerservice.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuotationController {

    @Autowired
    QuotationService quotationService; // Business logic

    /**
     * creating a get mapping that retrieves all the quotation detail from the database.
     * @return
     */
    @GetMapping("/quotation")
    private List<Quotation> getAllQuotation() {
        return quotationService.getAllQuotations();
    }

    // creating a get mapping that retrieves the detail of a specific quotation
    @GetMapping("/quotation/{id}")
    private Quotation getQuotation(@PathVariable("id") Long id) {
        return quotationService.getQuotationById(id);
    }

    // creating a delete mapping that deletes a specific quotation
    @DeleteMapping("/quotation/{id}")
    private void deleteQuotation(@PathVariable("id") Long id) {
        quotationService.delete(id);
    }
}
