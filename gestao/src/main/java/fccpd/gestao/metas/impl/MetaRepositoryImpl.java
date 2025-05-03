package fccpd.gestao.metas.impl;

import fccpd.gestao.metas.Meta;
import fccpd.gestao.metas.MetaRepository;
import fccpd.gestao.metas.mapper.MetaMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MetaRepositoryImpl implements MetaRepository {

    private final JdbcTemplate jdbcTemplate;

    public MetaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarMeta(Meta meta) {
        String sql = "INSERT INTO meta (titulo, descricao, valor, usuario_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, meta.getTitulo(), meta.getDescricao(), meta.getValor(), meta.getUsuarioId());
    }

    @Override
    public void excluirMeta(int id) {
        String sql = "DELETE FROM meta WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void alterarMeta(Meta meta, int id) {
        String sql = "UPDATE meta set titulo = ?, descricao = ?, valor = ? WHERE id = ?";
        jdbcTemplate.update(sql, meta.getTitulo(), meta.getDescricao(), meta.getValor(), id);
    }

    @Override
    public Meta buscarPorId(int id) {
        String sql = "SELECT * FROM meta WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new MetaMapper(),id);
    }

    @Override
    public List<Meta> buscarPorUsuario(int id) {
        String sql = "SELECT * FROM meta WHERE usuario_id = ?";
        return jdbcTemplate.query(sql, new MetaMapper(), id);
    }
}
