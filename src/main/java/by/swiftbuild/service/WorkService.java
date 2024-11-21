package by.swiftbuild.service;

import by.swiftbuild.entity.Work;
import by.swiftbuild.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public void save(Work work) {
        workRepository.save(work);
    }

    public void saveTen() {
        for (int i = 1; i <= 10; i++) {
            Work work = new Work();
            work.setName("Work - " + i);
            work.setDescription("Description - " + i);
            work.setCost(BigDecimal.valueOf(i * 5.0));
            workRepository.save(work);
        }
    }

    public List<Work> findAll () {
        Optional<List<Work>> all = Optional.of(workRepository.findAll());
        return all.get();
    }
}
