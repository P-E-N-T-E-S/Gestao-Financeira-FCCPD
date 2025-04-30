package fccpd.gestao.entrada.impl;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.entrada.EntradaRepositorio;
import fccpd.gestao.usuario.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntradaRepositorioImpl implements EntradaRepositorio {

    private JdbcTemplate jdbcTemplate;

    public EntradaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarEntrada(Entrada entrada) {
        String sql = "INSERT INTO entradas (valor, descricao, data, usuario_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, entrada.getValor(), entrada.getDescricao(), entrada.getData(), entrada.getUsuario().getId());
    }

    @Override
    public List<Entrada> buscarEntradasporId(int id) {
        return List.of();
    }

    @Override
    public List<Entrada> buscarEntradaPorUsuario(Usuario usuario) {
        return List.of();
    }

    @Override
    public void excluirEntrada(Entrada entrada) {

    }
}
