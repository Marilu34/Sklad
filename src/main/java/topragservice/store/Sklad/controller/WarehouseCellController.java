package topragservice.store.Sklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import topragservice.store.Sklad.model.WarehouseCellEntity;
import topragservice.store.Sklad.service.WarehouseCellService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WarehouseCellController {

    @Autowired
    private WarehouseCellService warehouseCellService;

    @PostMapping("/warehouse-cell")
    public List<WarehouseCellEntity> getWarehouseCells(@RequestBody Long idWarehouse) {
        return warehouseCellService.getWarehouseCells(idWarehouse);
    }
}
