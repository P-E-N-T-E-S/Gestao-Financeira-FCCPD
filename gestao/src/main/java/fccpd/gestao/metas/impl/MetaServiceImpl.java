package fccpd.gestao.metas.impl;

import fccpd.gestao.metas.Meta;
import fccpd.gestao.metas.MetaRepository;
import fccpd.gestao.metas.MetaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaServiceImpl implements MetaService {

    private MetaRepository repository;

    public MetaServiceImpl(MetaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarMeta(Meta meta) {
        repository.cadastrarMeta(meta);
    }

    @Override
    public void excluirMeta(int id) {
        repository.excluirMeta(id);
    }

    @Override
    public void alterarMeta(Meta meta, int id) {
        repository.alterarMeta(meta, id);
    }

    @Override
    public Meta buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Meta> buscarPorUsuario(int id) {
        return repository.buscarPorUsuario(id);
    }
}
