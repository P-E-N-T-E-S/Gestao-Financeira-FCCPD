package fccpd.gestao.entrada.impl;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.entrada.EntradaRepositorio;
import fccpd.gestao.entrada.EntradaServico;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntradaServicoImpl implements EntradaServico {

    public EntradaRepositorio repositorio;

    public EntradaServicoImpl(EntradaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrarEntrada(Entrada entrada) {
        repositorio.cadastrarEntrada(entrada);
    }

    @Override
    public List<Entrada> buscarEntradasporId(int id) {
        return repositorio.buscarEntradasporId(id);
    }

    @Override
    public List<Entrada> buscarEntradaPorUsuario(int id) {
        return repositorio.buscarEntradaPorUsuario(id);
    }

    @Override
    public List<Entrada> buscarTodasEntradas() {
        return repositorio.buscarTodasEntradas();
    }

    @Override
    public List<Entrada> buscarEntradaPorData(LocalDate inicio, LocalDate fim) {
        return repositorio.buscarEntradaPorData(inicio, fim);
    }

    @Override
    public void excluirEntrada(int id) {
        repositorio.excluirEntrada(id);
    }

    @Override
    public void alterarEntrada(Entrada entrada, int id) {
        repositorio.alterarEntrada(entrada, id);
    }
}
