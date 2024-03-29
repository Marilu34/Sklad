package topragservice.store.Sklad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import topragservice.store.Sklad.model.WarehouseCellEntity;

import java.util.List;

/**
 * Репозиторий для сущности "Ячейка склада".
 */

public interface WarehouseCellRepository extends JpaRepository<WarehouseCellEntity, Long> {


    List<WarehouseCellEntity> findAllByWarehouseIdAndBusyIsFalse(Long warehouseId);
}
