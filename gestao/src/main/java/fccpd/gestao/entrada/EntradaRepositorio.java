package fccpd.gestao.entrada;

import fccpd.gestao.usuario.Usuario;

import java.util.List;

public interface EntradaRepositorio {
    void cadastrarEntrada(Entrada entrada);
    List<Entrada> buscarEntradasporId(int id);
    List<Entrada> buscarEntradaPorUsuario(Usuario usuario);
    void excluirEntrada(Entrada entrada);
}
