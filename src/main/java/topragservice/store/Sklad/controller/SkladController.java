package topragservice.store.Sklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/sklad")
    public ResponseEntity<List<SkladEntity>> getAllWarehouse() {
        List<SkladEntity> skladEntities = skladService.getAllSklads();
        return new ResponseEntity<>(skladEntities, HttpStatus.OK);
    }
}
