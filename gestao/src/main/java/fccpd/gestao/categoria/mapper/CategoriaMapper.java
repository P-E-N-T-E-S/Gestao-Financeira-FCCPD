package fccpd.gestao.categoria.mapper;

import fccpd.gestao.categoria.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Categoria(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"));
    }
}
