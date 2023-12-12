package topragservice.store.Sklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topragservice.store.Sklad.model.WarehouseCellEntity;
import topragservice.store.Sklad.repository.WarehouseCellRepository;

import java.util.List;


/**
 * Сервис для работы с сущностями "Ячейка склада".
 */
@Service
public class WarehouseCellService {

    @Autowired
    private WarehouseCellRepository warehouseCellRepository;

    /**
     * Получает все свободные ячейки для заданного склада.
     *
     * @param warehouseId ID склада
     * @return Список сущностей свободных ячеек склада.
     */

    public List<WarehouseCellEntity> getWarehouseCells(Long warehouseId) {
        return warehouseCellRepository.findAllByWarehouseIdAndBusyIsFalse(warehouseId);
    }
}
