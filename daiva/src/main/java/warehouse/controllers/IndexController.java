package warehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.DTO.ClientDTO;
import warehouse.model.Client;
import warehouse.services.ClientService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    final ClientService clientService;

    public IndexController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<String> index(){

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }



}
