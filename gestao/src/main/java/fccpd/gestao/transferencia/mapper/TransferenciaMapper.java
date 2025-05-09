package fccpd.gestao.transferencia.mapper;

import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.transferencia.Transferencia;
import fccpd.gestao.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TransferenciaMapper implements RowMapper<Transferencia> {
    public Transferencia mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer user_id = rs.getInt("usuario_id");
        String username = rs.getString("username");
        String senha = rs.getString("senha");
        Usuario usuario = new Usuario(user_id, username, senha);

        Integer categoria_id = rs.getInt("categoria_id");
        String titulo = rs.getString("titulo");
        String categoria_descricao = rs.getString("descricao");
        Categoria categoria = new Categoria(categoria_id, titulo, categoria_descricao);

        Integer id = rs.getInt("id");
        LocalDate data = rs.getDate("data").toLocalDate();
        String descricao = rs.getString("descricao");
        Double valor = rs.getDouble("valor");
        boolean recebimento = rs.getBoolean("recebimento");

        return new Transferencia(id, valor, descricao, data, usuario, recebimento ,categoria);
    }
}
