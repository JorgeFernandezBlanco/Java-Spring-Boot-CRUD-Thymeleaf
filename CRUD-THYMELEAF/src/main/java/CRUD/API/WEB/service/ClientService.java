package CRUD.API.WEB.service;

import CRUD.API.WEB.entities.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getClients();
    Client getClientbyid(Long id);
    Client updateClient(Client updatedClient);
    void deleteClient(Long id);



}
