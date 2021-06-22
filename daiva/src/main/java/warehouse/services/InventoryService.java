package warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import warehouse.DTO.InventoryDTO;
import warehouse.exceptions.InventoryDoesNotExistsException;
import warehouse.model.Inventory;
import warehouse.repository.InventoryDAO;


@Service
public class InventoryService {

    @Autowired
    final InventoryDAO inventoryDAO;

    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Transactional
    public void addInventory(InventoryDTO inventoryDTO){
        Inventory newInventory = new Inventory();
        newInventory.setName(inventoryDTO.getName());
        newInventory.setWeight(inventoryDTO.getWeight());
        newInventory.setSector(inventoryDTO.getSector());
        newInventory.setDate(inventoryDTO.getDate());
    }

    @Transactional
    public Inventory getInventory(long id){
        if (!inventoryDAO.existsById(id)){
            throw new InventoryDoesNotExistsException("Inventory does not exists!");
        }
        return inventoryDAO.getById(id);
    }

    @Transactional
    public void deleteInventory(long id){
        if (!inventoryDAO.existsById(id)){
            throw new InventoryDoesNotExistsException("Inventory does not exists!");
        }
        inventoryDAO.deleteById(id);
    }
}
