package fccpd.gestao.categoria;

import java.util.List;

public interface CategoriaRepositorio {
    void cadastrarCategoria(Categoria categoria);
    Categoria buscarCategoriaPorId(int id);
    List<Categoria> listarTodasCategorias();
    void alterarCategoria(Categoria categoria);
    void excluirCategoria(Categoria categoria);
}
