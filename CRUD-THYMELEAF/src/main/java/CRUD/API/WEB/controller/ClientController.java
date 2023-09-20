package CRUD.API.WEB.controller;

import CRUD.API.WEB.entities.Client;
import CRUD.API.WEB.service.ClientServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    // Create
  /*  @PostMapping
    public Client createClient(@RequestBody Client client){
        return this.clientServiceImpl.saveClient(client);
    }
    */

    @GetMapping("/new")
    public String createClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client",client);
        return "create_client.html";
    }

    @PostMapping("/all")
    public String createClient(@ModelAttribute("client") Client client){
        clientServiceImpl.saveClient(client);
        return "redirect:/Client/all";
    }

    //Read
  /*  @GetMapping({"/clients","/"})
    public List<Client> getClients(){
        return this.clientServiceImpl.getClients();
    }
*/
    @GetMapping("/all")
    public String getClients(Model model) {
        List<Client> clients = clientServiceImpl.getClients();
        model.addAttribute("clients", clients);
        return "clients.html";
    }
   /* @GetMapping("/{id}")
    public Client getClientbyid(@PathVariable("id") Long id){
        return this.clientServiceImpl.getClientbyid(id);
    }
*/

    //Update , modify
    /*@PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        return clientServiceImpl.updateClient(id,updatedClient);
    }
*/
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("client", clientServiceImpl.getClientbyid(id));
        return "edit_client.html";
    }

    @PostMapping("/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client, Model model ){
        Client updatedClient = clientServiceImpl.getClientbyid(id);
        updatedClient.setId(id);
        updatedClient.setFirstname(client.getFirstname());
        updatedClient.setSurname(client.getSurname());
        updatedClient.setTelephone(client.getTelephone());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setDateofbirthday(client.getDateofbirthday());
        clientServiceImpl.updateClient(updatedClient);
     return "redirect:/Client/all";
    }


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
    /*@DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {
        try {
            clientServiceImpl.deleteClient(id);
            return "The client ID " + id + "`s been deleted successfully.";
        } catch (EntityNotFoundException e) {
            return "Error: " + e.getMessage();
        }

    } */
    @GetMapping("/{id}")
    public String deleteClient(@PathVariable Long id){
        clientServiceImpl.deleteClient(id);
        return "redirect:/Client/all";
    }
}
