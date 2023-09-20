package CRUD.API.WEB.service;


import CRUD.API.WEB.entities.Client;
import CRUD.API.WEB.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Create
    @Override
    public Client saveClient (Client client) {
        return clientRepository.save(client);
    }

    //Read
    @Override
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client getClientbyid(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        if(client!=null){
            return client;
        } else {
            throw new EntityNotFoundException("The client ID " + id + " doesn´t exit.");
        }
    }

    @Override
    public Client updateClient(Client updatedClient) {
        return clientRepository.save(updatedClient);
    }


    //Update , modify
  /*  @Override
    public Client updateClient (Long id, Client updatedClient){
        Client client = clientRepository.findById(id).get();
        if(clientRepository.existsById(id)){
            client.setFirstname(updatedClient.getFirstname());
            client.setSurname(updatedClient.getSurname());
            client.setTelephone(updatedClient.getTelephone());
            client.setEmail(updatedClient.getEmail());
            client.setDateofbirthday(updatedClient.getDateofbirthday());
            clientRepository.save(client);
            return client; } else {
            throw new EntityNotFoundException("The client ID " + id + " doesn´t exit.");

        }

    }
*/

    //Delete
    @Override
    public void deleteClient(Long id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client ID " + id + " doesn´t exit.");
        }

    }

}
