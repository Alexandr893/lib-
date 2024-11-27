package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Client;
import org.example.lib.service.ClientService.IClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return "clients";
    }

    @GetMapping("/new")
    public String showNewClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "new-client";
    }

    @PostMapping
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable("id") Long id, Model model) {
        Client client = clientService.findClientById(id);
        model.addAttribute("client", client);
        return "edit-client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, @ModelAttribute("client") Client client) {
        client.setId(id);
        clientService.saveClient(client);
        return "redirect:/clients";
    }

}
