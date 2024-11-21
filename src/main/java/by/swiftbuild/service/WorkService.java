package by.swiftbuild.service;

import by.swiftbuild.entity.Work;
import by.swiftbuild.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public void save(Work work) {
        workRepository.save(work);
    }
}
