package fccpd.gestao.transferencia;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepositorio {
    void cadastrarTransferencia(Transferencia transferencia);
    List<Transferencia> buscarTransferenciasporId(int id);
    List<Transferencia> buscarTransferenciaPorUsuario(int id);
    List<Transferencia> buscarTodasTransferencias();
    List<Transferencia> buscarTransferenciaPorData(LocalDate inicio, LocalDate fim);
    void excluirTransferencia(int id);
    void alterarTransferencia(Transferencia transferencia, int id);

}
