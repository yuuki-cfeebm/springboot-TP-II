package br.com.fatec.apiexemplousuario.controller;

import br.com.fatec.apiexemplousuario.model.Usuario;
import br.com.fatec.apiexemplousuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    // GET - buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // POST - adicionar usuário
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }
       // DELETE - remover usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (usuarioService.buscarPorId(id).isPresent()) {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
//Atualizar
    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestParam Integer id,@RequestBody Usuario usuario) {
        if(usuarioService.buscarPorId(id).isPresent()) {
            usuarioService.atualizar(id, usuario);
            return ResponseEntity.status(201).body(usuario);
        }
        return ResponseEntity.notFound().build();
    }
    /*
    Alternativo
    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestParam Integer id,@RequestBody Usuario usuario) {
    if(usuarioService.buscarPorId(id).isPresent()) {
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.status(201).body(usuario);
    }
    return ResponseEntity.notFound().build();
}
     */

    /*
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
    // PUT - atualizar usuário
    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizar(
            @PathVariable int indice,
            @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizar(indice, usuario);
        if (usuarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioAtualizado);
    }
    // DELETE - remover usuário
    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        usuarioService.deletar(indice);
        return ResponseEntity.noContent().build();
    }

*/
}
