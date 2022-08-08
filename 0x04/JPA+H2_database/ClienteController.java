package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        cliente.setId(null);
        Cliente clientePersist = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientePersist);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Cliente clienteRetorno = clienteRepository.findById(idClient).orElse(null);
        if(clienteRetorno != null) {
            return ResponseEntity.ok(clienteRetorno);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.findById(idClient).ifPresent(clienteRetorno -> clienteRepository.deleteById(idClient));
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        clienteRepository.findById(id).ifPresent(clienteRetorno -> clienteRepository.save(cliente));
    }
}
