package fccpd.gestao.transferencia.impl;

import fccpd.gestao.transferencia.Transferencia;
import fccpd.gestao.transferencia.TransferenciaRepositorio;
import fccpd.gestao.transferencia.TransferenciaServico;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaServicoImpl implements TransferenciaServico {

    public TransferenciaRepositorio repositorio;

    public TransferenciaServicoImpl(TransferenciaRepositorio transferencia) {
        this.repositorio = transferencia;
    }

    @Override
    public void cadastrarTransferencia(Transferencia transferencia) {
        repositorio.cadastrarTransferencia(transferencia);
    }

    @Override
    public List<Transferencia> buscarTransferenciasporId(int id) {
        return repositorio.buscarTransferenciasporId(id);
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorUsuario(int id) {
        return repositorio.buscarTransferenciaPorUsuario(id);
    }

    @Override
    public List<Transferencia> buscarTodasTransferencias() {
        return repositorio.buscarTodasTransferencias();
    }

    @Override
    public List<Transferencia> buscarTransferenciasPorCategoria(int id) {
        return repositorio.buscarTransferenciasPorCategoria(id);
    }

    @Override
    public List<Transferencia> buscarTransferenciaPorData(LocalDate inicio, LocalDate fim) {
        return repositorio.buscarTransferenciaPorData(inicio, fim);
    }

    @Override
    public void excluirTransferencia(int id) {
        repositorio.excluirTransferencia(id);
    }

    @Override
    public void alterarTransferencia(Transferencia transferencia, int id) {
        repositorio.alterarTransferencia(transferencia, id);
    }
}
