package org.example.lib.controller;

import lombok.AllArgsConstructor;
import org.example.lib.dao.entity.Client;
import org.example.lib.dao.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/new")
    public String showNewClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "new-client";
    }

    @PostMapping
    public String saveClient(@ModelAttribute("client") Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable("id") Long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "edit-client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, @ModelAttribute("client") Client client) {
        client.setId(id);
        clientRepository.save(client);
        return "redirect:/clients";
    }

}
