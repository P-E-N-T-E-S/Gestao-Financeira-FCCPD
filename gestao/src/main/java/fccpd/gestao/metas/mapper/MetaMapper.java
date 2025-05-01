package fccpd.gestao.metas.mapper;

import fccpd.gestao.metas.Meta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaMapper implements RowMapper<Meta> {

    @Override
    public Meta mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Meta(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getDouble("valor"), rs.getInt("usuario_id"));
    }
}
