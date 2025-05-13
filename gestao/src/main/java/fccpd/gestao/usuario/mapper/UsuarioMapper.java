package fccpd.gestao.usuario.mapper;

import fccpd.gestao.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String senha = rs.getString("senha");
        return new Usuario(id, username, senha);
    }
}
