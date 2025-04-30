package fccpd.gestao;

import fccpd.gestao.entrada.Entrada;
import fccpd.gestao.entrada.EntradaServico;
import fccpd.gestao.usuario.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TesteEntradaRunner implements CommandLineRunner {

    private final EntradaServico entradaServico;

    public TesteEntradaRunner(EntradaServico entradaServico) {
        this.entradaServico = entradaServico;
    }

    @Override
    public void run(String... args) throws Exception {
        Entrada entrada = new Entrada(10, 150, "Testnado", LocalDate.now(), new Usuario(1, "Andre", "123"));

        entradaServico.cadastrarEntrada(entrada);
        System.out.println("Entrada cadastrada com sucesso.");
    }
}
