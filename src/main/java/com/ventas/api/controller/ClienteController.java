package com.ventas.api.controller;

import com.ventas.api.model.Cliente;
import com.ventas.api.service.ClienteService;
import com.ventas.api.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Response entity crea automaticamente todo el cuerpo de la peiticon
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer  id){
        // la funcion retorna un opcional<Cliente> en caso de ser encontrado se retorna ok
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        // new debido a que queremos retornar un cliente y a la vez queremos inidcar que le
        // http status sera 201
        // Response entity necesita dos parametros primero el objeto que necesitamos retornar
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return clienteService.findById(cliente.getIdCliente())
                .map( c -> ResponseEntity.ok(clienteService.update(cliente)))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer id){
        return clienteService.findById(id)
                .map(c -> {
                    clienteService.delete(id);
                    return ResponseEntity.ok(c);
                })
                .orElseGet( ()-> ResponseEntity.notFound().build());
    }

}
