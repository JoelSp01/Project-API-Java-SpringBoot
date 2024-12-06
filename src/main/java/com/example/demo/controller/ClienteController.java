package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> testGetAllItems() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    public List<Cliente> testGetItemId(@PathVariable Long id) {
        return clienteRepository.findAllById(List.of(id)    );
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)  // Código de estado 201 para recurso creado
    public void createCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);  // Guardar el cliente en la base de datos
    }

    // Endpoint para actualizar un cliente
    @PutMapping("/clientes/{id}")
    public Cliente testPutItem(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Verifica si el cliente existe
        if (clienteRepository.existsById(id)) {
            // Actualiza el cliente
            cliente.setId(id);  // Asegúrate de que el ID no se cambie
            return clienteRepository.save(cliente);  // Guarda el cliente actualizado
        } else {
            return null;  // O retorna un error si el cliente no existe
        }
    }

    // Endpoint para eliminar un cliente
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> testDeleteItem(@PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id); // Elimina el cliente por id
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Código 204 (Sin contenido)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Código 404 (No encontrado)
        }
    }


}
