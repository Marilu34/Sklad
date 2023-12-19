package topragservice.store.Sklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import topragservice.store.Sklad.model.WarehouseCellEntity;
import topragservice.store.Sklad.model.WarehouseCellRequest;
import topragservice.store.Sklad.service.WarehouseCellService;

import java.util.List;


/**
 * REST-контроллер для обработки запросов, связанных с ячейками склада.
 */
@RestController
@RequestMapping("/api/v1")
public class WarehouseCellController {

    @Autowired
    private WarehouseCellService warehouseCellService;

    @PostMapping("/warehouse-cell")
    public ResponseEntity<List<WarehouseCellEntity>> getWarehouseCells(@RequestHeader("Authorization") String token, @RequestBody WarehouseCellRequest idWarehouse) {
        // Проверяем наличие токена Bearer и его правильность
        if (token == null || !token.equals("Bearer FP59YD9KEP9CE3")) {
            throw new IllegalArgumentException("Invalid or missing Bearer token.");
        }

        // Здесь вы можете выполнить дополнительные проверки, если это необходимо
        List<WarehouseCellEntity> warehouseCells = warehouseCellService.getWarehouseCells(idWarehouse);
        return new ResponseEntity<>(warehouseCells, HttpStatus.OK);
    }
}


