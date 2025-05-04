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

    private final JdbcTemplate jdbcTemplate;

    public TransferenciaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarTransferencia(Transferencia transferencia) {
        String sql = "INSERT INTO transferencia (valor, descricao, data, usuario_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, transferencia.getValor(), transferencia.getDescricao(), transferencia.getData(), transferencia.getUsuario().getId());
    }

    @Override
    public List<Transferencia> buscarTransferenciasporId(int id) {
        String sql = "SELECT * FROM transferencia t JOIN usuarios u ON t.id = u.id WHERE u.id = ? ";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), id);
    }

    @Override
    public List<Transferencia> buscarTodasTransferencias() {
        String sql = "SELECT * FROM transferencia t join usuarios u ON u.id = t.usuario_id ";
        return jdbcTemplate.query(sql, new TransferenciaMapper());
    }

    @Override
    public List<Transferencia> buscarTransferenciasPorCategoria(int id) {
        String sql = "SELECT * FROM transferencia t join categoria c ON c.id = t.categoria_id WHERE t.categoria_id = ?";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), id);
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorData(LocalDate inicio, LocalDate fim) {
        String sql = "SELECT * FROM transferencia t join usuarios u ON u.id = t.usuario_id WHERE t.data between ? and ? ";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), inicio, fim);
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorUsuario(int id) {
        String sql = "SELECT * FROM transferencia t join usuarios u ON u.id = t.usuario_id WHERE u.id = ?";
        return jdbcTemplate.query(sql, new TransferenciaMapper(), id);
    }

    @Override
    public void excluirTransferencia(int id) {
        String sql = "DELETE FROM transferencia WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void alterarTransferencia(Transferencia transferencia, int id) {
        String sql = "UPDATE transferencia set valor = ?, descricao = ?WHERE id = ?";
        jdbcTemplate.update(sql, transferencia.getValor(), transferencia.getDescricao(), id);
    }
}
