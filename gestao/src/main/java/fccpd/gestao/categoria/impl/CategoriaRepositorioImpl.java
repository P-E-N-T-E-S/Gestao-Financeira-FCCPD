package fccpd.gestao.categoria.impl;

import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.categoria.CategoriaRepositorio;
import fccpd.gestao.categoria.mapper.CategoriaMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaRepositorioImpl implements CategoriaRepositorio {

    private final JdbcTemplate jdbcTemplate;

    public CategoriaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void cadastrarCategoria(@NotNull Categoria categoria) {
        String sql = "INSERT INTO categoria (titulo, descricao) VALUES (?,?)";
        jdbcTemplate.update(sql, categoria.getTitulo(), categoria.getDescricao());
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CategoriaMapper(), id);
    }

    @Override
    public List<Categoria> listarTodasCategorias() {
        String sql = "SELECT * FROM categoria";
        return jdbcTemplate.query(sql, new CategoriaMapper());
    }

    @Override
    public void alterarCategoria(@NotNull Categoria categoria) {
        String sql = "UPDATE categoria SET titulo = ?, descricao = ? WHERE id = ?";
        jdbcTemplate.update(sql, categoria.getTitulo(), categoria.getDescricao(), categoria.getId());
    }

    @Override
    public void excluirCategoria(@NotNull Categoria categoria) {
        String sql = "DELETE FROM meta WHERE id = ?";
        jdbcTemplate.update(sql, categoria.getId());
    }
}
