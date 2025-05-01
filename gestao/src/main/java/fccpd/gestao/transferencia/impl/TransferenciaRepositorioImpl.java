package fccpd.gestao.transferencia.impl;

import fccpd.gestao.transferencia.Transferencia;
import fccpd.gestao.transferencia.TransferenciaRepositorio;
import fccpd.gestao.transferencia.mapper.TransferenciaMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransferenciaRepositorioImpl implements TransferenciaRepositorio {

    private JdbcTemplate jdbcTemplate;

    public TransferenciaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarTransferencia(Transferencia transferencia) {
        String sql = "INSERT INTO entradas (valor, descricao, data, usuario_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, transferencia.getValor(), transferencia.getDescricao(), transferencia.getData(), transferencia.getUsuario().getId());
    }

    @Override
    public List<Transferencia> buscarTransferenciasporId(int id) {
        String sql = "SELECT * FROM entradas e JOIN usuarios u ON e.id = u.id WHERE u.id = ? ";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), id);
    }

    @Override
    public List<Transferencia> buscarTodasTransferencias() {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id ";
        return jdbcTemplate.query(sql, new TransferenciaMapper());
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorData(LocalDate inicio, LocalDate fim) {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id WHERE e.data between ? and ? ";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), inicio, fim);
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorUsuario(int id) {
        String sql = "SELECT * FROM entradas e join usuarios u ON u.id = e.usuario_id WHERE u.id = ?";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), id);
    }

    @Override
    public void excluirTransferencia(int id) {
        String sql = "DELETE FROM entradas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void alterarTransferencia(Transferencia transferencia, int id) {
        String sql = "UPDATE entradas set valor = ?, descricao = ?WHERE id = ?";
        jdbcTemplate.update(sql, transferencia.getValor(), transferencia.getDescricao(), id);
    }
}
