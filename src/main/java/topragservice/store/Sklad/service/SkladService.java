package topragservice.store.Sklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topragservice.store.Sklad.model.SkladEntity;
import topragservice.store.Sklad.repository.SkladRepository;

import java.util.List;

/**
 * Сервис для работы с сущностями "Склад".
 */
@Service
public class SkladService {

    @Autowired
    private SkladRepository skladRepository;

    /**
     * Получает все существующие склады.
     *
     * @return Список сущностей складов.
     */

    public List<SkladEntity> getAllSklads() {
        return skladRepository.findAll();
    }
}
