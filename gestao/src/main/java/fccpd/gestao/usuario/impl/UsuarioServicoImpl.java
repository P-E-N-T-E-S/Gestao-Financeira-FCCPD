package fccpd.gestao.usuario.impl;

import fccpd.gestao.usuario.Usuario;
import fccpd.gestao.usuario.UsuarioRepositorio;
import fccpd.gestao.usuario.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicoImpl implements UsuarioServico {
    private UsuarioRepositorio repositorio;

    @Autowired
    public UsuarioServicoImpl(UsuarioRepositorio usuarioRepositorio) {
        this.repositorio = usuarioRepositorio;
    }


    @Override
    public void cadastrarUsuario(Usuario usuario) {
        repositorio.cadastrarUsuario(usuario);
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        repositorio.alterarUsuario(usuario);
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        repositorio.excluirUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repositorio.listarUsuarios();
    }

    @Override
    public Usuario buscarUsuarioPorLogin(String login) {
        return repositorio.buscarUsuarioPorLogin(login);
    }
}
