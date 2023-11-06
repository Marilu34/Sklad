package topragservice.store.Sklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import topragservice.store.Sklad.model.SkladEntity;
import topragservice.store.Sklad.service.SkladService;

import java.util.List;

//REST-контроллер для обработки запросов, связанных со складами.

@RestController
@RequestMapping("/api/v1")
public class SkladController {

    @Autowired
    private SkladService skladService;

    //- Получает список всех складов.

    @GetMapping("/all-warehouse")
    public List<SkladEntity> getAllWarehouse() {
        return skladService.getAllSklads();
    }
}
