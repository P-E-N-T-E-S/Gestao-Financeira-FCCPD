package fccpd.gestao.entrada.impl;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.entrada.EntradaRepositorio;
import fccpd.gestao.entrada.EntradaServico;
import fccpd.gestao.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaServicoImpl implements EntradaServico {

    public EntradaRepositorio repositorio;

    public EntradaServicoImpl(EntradaRepositorioImpl repositorio) {
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
    public List<Entrada> buscarEntradaPorUsuario(Usuario usuario) {
        return repositorio.buscarEntradaPorUsuario(usuario);
    }

    @Override
    public void excluirEntrada(Entrada entrada) {
        repositorio.excluirEntrada(entrada);
    }
}
