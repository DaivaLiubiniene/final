package warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.DTO.InventoryDTO;
import warehouse.model.Inventory;
import warehouse.services.InventoryService;

import javax.validation.Valid;

@RestController
@Api(value = "inventory")
@RequestMapping(path = "/api/inventory")
public class InventoryController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(path = "/add")
    @ApiOperation(value = "Add inventory", notes = "Adds new inventory")
    public ResponseEntity<String> addInventory(@Valid @RequestBody InventoryDTO inventoryInfo){

        LOG.info("** InventoryController: adding new inventory **");
       inventoryService.addInventory(inventoryInfo);
        return new ResponseEntity<>("Inventorius pridėtas sėkmingai", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get inventory", notes = "Returns inventory")
    public Inventory getInventory(@PathVariable long id){
        return inventoryService.getInventory(id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deletes inventory", notes = "Deletes inventory")
    public ResponseEntity<String> deleteInventory(@PathVariable long id){
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>("Inventorius ištrintas sėkmingai", HttpStatus.NO_CONTENT);
    }
}
