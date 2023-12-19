package topragservice.store.Sklad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import topragservice.store.Sklad.model.SkladEntity;
import topragservice.store.Sklad.service.SkladService;


import java.util.List;


/**
 * REST-контроллер для обработки запросов, связанных со складами.
 */
@RestController
@RequestMapping("/api/v1")
public class SkladController {

    @Autowired
    private SkladService skladService;


    @GetMapping("/sklad")

    public List<SkladEntity> getAllWarehouse(@RequestHeader("Authorization") String token) {
        // Проверяем наличие токена Bearer и его правильность
        if (token == null || !token.equals("Bearer FP59YD9KEP9CE3")) {
            throw new IllegalArgumentException("Invalid or missing Bearer token.");
        }

        // Здесь вы можете выполнить дополнительные проверки, если это необходимо

        return skladService.getAllSklads();
    }
}

//    @GetMapping("/sklad")
//    @PreAuthorize("isAuthenticated()")
//    public List<SkladEntity> getAllWarehouse() {
//        return skladService.getAllSklads();
//    }

