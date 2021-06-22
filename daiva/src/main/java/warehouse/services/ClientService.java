package warehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import warehouse.DTO.ClientDTO;
import warehouse.exceptions.ClientAlreadyExistsException;
import warehouse.exceptions.ClientDoesNotExistsException;
import warehouse.model.Client;
import warehouse.repository.ClientDAO;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Transactional
    public void addClient(ClientDTO clientDTO){
        Client newClient = new Client();
        if (clientDAO.findByName(clientDTO.getName()) != null && clientDAO.findBySurname(clientDTO.getSurname()) != null
                && clientDAO.findByBirthdate(clientDTO.getBirthdate()) != null) {
            throw new ClientAlreadyExistsException("Client already exists");
        }
        newClient.setName(clientDTO.getName());
        newClient.setSurname(clientDTO.getSurname());
        newClient.setBirthdate(clientDTO.getBirthdate());
        newClient.setPhone(clientDTO.getPhone());
        newClient.setType(clientDTO.getType());
    }

    @Transactional
    public Client getClient(long id){
        if (!clientDAO.existsById(id)){
            throw new ClientDoesNotExistsException("Client does not exists!");
        }
        return clientDAO.getById(id);
    }

    @Transactional
    public List<Client> getClients(){
        return clientDAO.findAll();
    }

    @Transactional
    public void deleteClient(long id){
        if (!clientDAO.existsById(id)){
            throw new ClientDoesNotExistsException("Client does not exists!");
        }
       clientDAO.deleteById(id);
    }

}
