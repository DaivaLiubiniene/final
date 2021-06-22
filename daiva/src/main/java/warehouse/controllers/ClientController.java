package warehouse.controllers;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import warehouse.DTO.ClientDTO;
import warehouse.model.Client;
import warehouse.services.ClientService;

import javax.validation.Valid;

@RestController
@Api(value = "client")
@RequestMapping(path = "/api/client")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path = "/add")
    @ApiOperation(value = "Add client", notes = "Adds new client")
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientDTO clientInfo){

        LOG.info("** ClientController: adding new client **");
        clientService.addClient(clientInfo);
        return new ResponseEntity<>("Klientas pridėtas sėkmingai", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get client", notes = "Returns client")
    public Client getClient(@PathVariable long id){
        return clientService.getClient(id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deletes client", notes = "Deletes client")
    public ResponseEntity<String> deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Klientas ištrintas sėkmingai", HttpStatus.NO_CONTENT);
    }



}
