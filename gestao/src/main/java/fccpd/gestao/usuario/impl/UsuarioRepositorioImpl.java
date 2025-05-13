package fccpd.gestao.usuario.impl;

import fccpd.gestao.usuario.Usuario;
import fccpd.gestao.usuario.UsuarioRepositorio;
import fccpd.gestao.usuario.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (username, senha) VALUES (?, ?)";
        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getSenha());
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET username = ?, senha = ? WHERE id = ?";
        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getSenha(), usuario.getId());

    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        jdbcTemplate.update(sql, usuario.getId());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuario";
        return jdbcTemplate.query(sql, new UsuarioMapper());
    }

    @Override
    public Usuario buscarUsuarioPorLogin(String login) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new UsuarioMapper(), login);
    }

}
