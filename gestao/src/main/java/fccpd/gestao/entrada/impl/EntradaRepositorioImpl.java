package fccpd.gestao.entrada.impl;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.entrada.EntradaRepositorio;
import fccpd.gestao.entrada.mapper.EntradaMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        String sql = "SELECT * FROM entradas e JOIN usuarios u ON e.id = u.id WHERE u.id = ? ";
        return jdbcTemplate.query(sql, new EntradaMapper(), id);
    }

    @Override
    public List<Entrada> buscarTodasEntradas() {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id ";
        return jdbcTemplate.query(sql, new EntradaMapper());
    }

    @Override
    public List<Entrada> buscarEntradaPorData(LocalDate inicio, LocalDate fim) {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id WHERE e.data between ? and ? ";
        return jdbcTemplate.query(sql, new EntradaMapper(), inicio, fim);
    }

    @Override
    public List<Entrada> buscarEntradaPorUsuario(int id) {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id WHERE u.id = ?";
        return jdbcTemplate.query(sql, new EntradaMapper(), id);
    }

    @Override
    public void excluirEntrada(int id) {
        String sql = "DELETE FROM entradas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void alterarEntrada(Entrada entrada, int id) {
        String sql = "UPDATE entradas set valor = ?, descricao = ? WHERE id = ?";
        jdbcTemplate.update(sql, entrada.getValor(), entrada.getDescricao(), id);
    }
}
