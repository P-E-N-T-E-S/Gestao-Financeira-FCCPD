package fccpd.gestao;

import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.transferencia.Transferencia;
import fccpd.gestao.transferencia.TransferenciaServico;
import fccpd.gestao.usuario.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TesteEntradaRunner implements CommandLineRunner {

    private final TransferenciaServico transferenciaServico;

    public TesteEntradaRunner(TransferenciaServico transferenciaServico) {
        this.transferenciaServico = transferenciaServico;
    }

    @Override
    public void run(String... args) throws Exception {
        Transferencia transferencia = new Transferencia(15, 150.0, "Testnado", LocalDate.now(), new Usuario(1, "Andre", "123"), true, new Categoria(1, "Automovel", "Compras relacionadas a automoveis"));
        transferenciaServico.cadastrarTransferencia(transferencia);



        List<Transferencia> e = transferenciaServico.buscarTransferenciaPorData(LocalDate.now().minusDays(27), LocalDate.now().minusDays(3));
        transferenciaServico.alterarTransferencia(new Transferencia(2, 120.0, "Adaptação", LocalDate.now(), null, false, null), 2);
        System.out.println(e);
    }
}
