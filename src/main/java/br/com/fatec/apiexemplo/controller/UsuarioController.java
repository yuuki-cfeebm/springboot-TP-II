package br.com.fatec.apiexemplo.controller;

import br.com.fatec.apiexemplo.model.Usuario;
import br.com.fatec.apiexemplo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    // GET - listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }
    // GET - buscar usuário por índice
    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> buscarPorIndice(@PathVariable int indice) {
        Usuario usuario = usuarioService.buscarPorIndice(indice);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }
    // POST - adicionar usuário
    @PostMapping
    public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.adicionar(usuario);

        return ResponseEntity.status(201).body(novoUsuario);
    }
}