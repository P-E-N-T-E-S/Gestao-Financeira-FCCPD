package fccpd.gestao.categoria.impl;

import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.categoria.CategoriaRepositorio;
import fccpd.gestao.categoria.CategoriaServico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoraiServicoImpl implements CategoriaServico {

    CategoriaRepositorio categoriaRepositorio;

    public CategoraiServicoImpl(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void cadastrarCategoria(Categoria categoria) {
        categoriaRepositorio.cadastrarCategoria(categoria);
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        return categoriaRepositorio.buscarCategoriaPorId(id);
    }

    @Override
    public List<Categoria> listarTodasCategorias() {
        return categoriaRepositorio.listarTodasCategorias();
    }

    @Override
    public void alterarCategoria(Categoria categoria) {
        categoriaRepositorio.alterarCategoria(categoria);
    }

    @Override
    public void excluirCategoria(Categoria categoria) {
        categoriaRepositorio.excluirCategoria(categoria);
    }
}
