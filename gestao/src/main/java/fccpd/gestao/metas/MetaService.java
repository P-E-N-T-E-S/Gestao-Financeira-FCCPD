package fccpd.gestao.metas;

import java.util.List;

public interface MetaService {
    void cadastrarMeta(Meta meta);
    void excluirMeta(int id);
    void alterarMeta(Meta meta, int id);
    Meta buscarPorId(int id);
    List<Meta> buscarPorUsuario(int id);
}
