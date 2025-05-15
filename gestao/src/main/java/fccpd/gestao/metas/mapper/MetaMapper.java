package fccpd.gestao.metas.mapper;

import fccpd.gestao.metas.Meta;
import fccpd.gestao.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaMapper implements RowMapper<Meta> {

    @Override
    public Meta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario u = new Usuario(rs.getInt("usuario_id"), null, null);
        return new Meta(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getDouble("valor"), u);
    }
}
