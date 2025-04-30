package fccpd.gestao.entrada;

import fccpd.gestao.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface EntradaServico {
    void cadastrarEntrada(Entrada entrada);
    List<Entrada> buscarEntradasporId(int id);
    List<Entrada> buscarEntradaPorUsuario(int id);
    List<Entrada> buscarTodasEntradas();
    List<Entrada> buscarEntradaPorData(LocalDate inicio, LocalDate fim);
    void excluirEntrada(Entrada entrada);
}
