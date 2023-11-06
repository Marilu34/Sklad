package topragservice.store.Sklad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import topragservice.store.Sklad.model.SkladEntity;

public interface SkladRepository extends JpaRepository<SkladEntity, Integer> {
}