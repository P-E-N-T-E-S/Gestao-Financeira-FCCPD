package fccpd.gestao.entrada.mapper;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EntradaMapper implements RowMapper<Entrada> {
    public Entrada mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer user_id = rs.getInt("usuario_id");
        String username = rs.getString("username");
        String senha = rs.getString("senha");
        Usuario usuario = new Usuario(user_id, username, senha);

        Integer id = rs.getInt("id");
        LocalDate data = rs.getDate("data").toLocalDate();
        String descricao = rs.getString("descricao");
        Double valor = rs.getDouble("valor");

        return new Entrada(id, valor, descricao, data, usuario);
    }
}
