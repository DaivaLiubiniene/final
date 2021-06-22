package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Inventory;

public interface InventoryDAO extends JpaRepository<Inventory, Long> {

}
