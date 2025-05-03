package fccpd.gestao.metas;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface MetaRepository {
    void cadastrarMeta(Meta meta);
    void excluirMeta(int id);
    void alterarMeta(Meta meta, int id);
    Meta buscarPorId(int id);
    List<Meta> buscarPorUsuario(int id);
}
