package warehouse.exceptions;

import warehouse.model.Inventory;

public class InventoryDoesNotExistsException extends RuntimeException{
    public InventoryDoesNotExistsException(String message){
        super(message);
    }
}
