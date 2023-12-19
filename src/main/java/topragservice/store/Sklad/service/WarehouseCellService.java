package topragservice.store.Sklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topragservice.store.Sklad.model.WarehouseCellEntity;
import topragservice.store.Sklad.model.WarehouseCellRequest;
import topragservice.store.Sklad.repository.WarehouseCellRepository;

import java.util.List;


/**
 * Сервис для работы с сущностями "Ячейка склада".
 */
@Service
public class WarehouseCellService {

    @Autowired
    private WarehouseCellRepository warehouseCellRepository;

    public List<WarehouseCellEntity> getWarehouseCells(WarehouseCellRequest request) {
        return warehouseCellRepository.findAllByWarehouseIdAndBusyIsFalse(request.getWarehouseId());
    }
}


