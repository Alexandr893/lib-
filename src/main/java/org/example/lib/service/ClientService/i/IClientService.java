package org.example.lib.service.ClientService.i;

import org.example.lib.dao.entity.Client;

import java.util.List;

public interface  IClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client findClientById(Long id);
}
