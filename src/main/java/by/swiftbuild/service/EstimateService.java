package by.swiftbuild.service;

import by.swiftbuild.entity.Estimate;
import by.swiftbuild.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    public void save(Estimate estimate) {
        estimateRepository.save(estimate);
    }
}
