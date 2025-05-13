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
                Integer id = rs.getInt("id");
                LocalDate data = rs.getDate("data").toLocalDate();
                String descricao = rs.getString("descricao");
                Double valor = rs.getDouble("valor");
                boolean recebimento = rs.getBoolean("recebimento");

                // Apenas IDs
                Integer usuarioId = rs.getInt("usuario_id");
                Integer categoriaId = rs.getInt("categoria_id");

                // Você pode setar depois com DAOs ou setters
                Usuario usuario = new Usuario(usuarioId, null, null); // placeholders
                Categoria categoria = new Categoria(categoriaId, null, null); // placeholders

                return new Transferencia(id, valor, descricao, data, usuario, recebimento, categoria);
            }
        }

