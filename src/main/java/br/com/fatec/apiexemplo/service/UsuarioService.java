package br.com.fatec.apiexemplo.service;

import br.com.fatec.apiexemplo.model.Usuario;
import br.com.fatec.apiexemplo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() {

        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {

        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
    public void deletar(Integer id) {

        usuarioRepository.deleteById(id);
    }
    public Usuario atualizar(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioAtualizado = usuarioRepository.findById(id);
        if (usuarioAtualizado.isPresent()) {
            return usuarioRepository.save(usuarioAtualizado.get());
        }
        return null;
    }
}


