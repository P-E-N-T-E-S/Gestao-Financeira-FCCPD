package fccpd.gestao.entrada;

import java.time.LocalDate;
import java.util.List;

public interface EntradaRepositorio {
    void cadastrarEntrada(Entrada entrada);
    List<Entrada> buscarEntradasporId(int id);
    List<Entrada> buscarEntradaPorUsuario(int id);
    List<Entrada> buscarTodasEntradas();
    List<Entrada> buscarEntradaPorData(LocalDate inicio, LocalDate fim);
    void excluirEntrada(int id);
    void alterarEntrada(Entrada entrada, int id);

}
