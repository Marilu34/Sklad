package topragservice.store.Sklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topragservice.store.Sklad.model.SkladEntity;
import topragservice.store.Sklad.repository.SkladRepository;

import java.util.List;

@Service
public class SkladService {

    @Autowired
    private SkladRepository skladRepository;

    public List<SkladEntity> getAllSklads() {
        return skladRepository.findAll();
    }
}