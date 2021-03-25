package kmitl.esd.exercise.jpa.customerservice.service;

import kmitl.esd.exercise.jpa.customerservice.model.Quotation;
import kmitl.esd.exercise.jpa.customerservice.repo.QuotationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationService {

    Logger logger = LogManager.getLogger(QuotationService.class);

    @Autowired
    QuotationRepository quotationRepository;

//    @Autowired
//    CustomerService customerService

    public List<Quotation> getAllQuotations() {
        List<Quotation> quotations = new ArrayList<>();
        quotationRepository.findAll().forEach(quote -> quotations.add(quote));

        return quotations;
    }

    public Quotation getQuotationById(Long id) {
        return quotationRepository.findQuotationById(id);
    }

    public void saveOrUpdate(Quotation quotation) {
        quotationRepository.save(quotation);
    }

    public void delete(Long id) {
        quotationRepository.deleteById(id);
    }
}
