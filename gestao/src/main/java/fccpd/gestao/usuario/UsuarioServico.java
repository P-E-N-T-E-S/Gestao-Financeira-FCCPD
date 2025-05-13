package fccpd.gestao.usuario;

import java.util.List;

public interface UsuarioServico {
    void cadastrarUsuario(Usuario usuario);
    void alterarUsuario(Usuario usuario);
    void excluirUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorLogin(String login);
}
