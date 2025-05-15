package fccpd.gestao.apresentacao;

import com.mysql.cj.xdevapi.Client;
import fccpd.gestao.categoria.Categoria;
import fccpd.gestao.categoria.CategoriaRepositorio;
import fccpd.gestao.categoria.CategoriaServico;
import fccpd.gestao.metas.Meta;
import fccpd.gestao.metas.MetaService;
import fccpd.gestao.transferencia.Transferencia;
import fccpd.gestao.transferencia.TransferenciaServico;
import fccpd.gestao.usuario.Usuario;
import fccpd.gestao.usuario.UsuarioServico;
import fccpd.gestao.usuario.impl.UsuarioServicoImpl;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
public class ClientLineInterface {

    static UsuarioServico usuario;
    static TransferenciaServico transferencia;
    static MetaService meta;
    static CategoriaServico categoria;

    public ClientLineInterface(UsuarioServico usuario, TransferenciaServico transferencia, MetaService meta, CategoriaServico categoria) {
        ClientLineInterface.usuario = usuario;
        ClientLineInterface.transferencia = transferencia;
        ClientLineInterface.meta = meta;
        ClientLineInterface.categoria = categoria;
    }

    public static void interfaceGeral() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================================");
        System.out.println("|Interface Geral                                        |");
        System.out.println("| 1 - Configurações de Usuario                          |");
        System.out.println("| 2 - Tabela de Transferencias                          |");
        System.out.println("| 3 - Tabela de Metas                                   |");
        System.out.println("| 4 - Tabela de Categorias                              |");
        System.out.println("| 5 - Encerrar Aplicação                                |");
        System.out.println("| Insira uma opção de (1 ~ 5)                           |");
        System.out.println("=========================================================");
        int decisao = sc.nextInt();

        while (decisao > 5 || decisao < 1) {
            System.out.println("Valor invalido, por favor insira novamente");
            decisao = sc.nextInt();
        }

        switch (decisao) {
            case 1:
                ClientLineInterface.InterfaceUsuario();
                break;
            case 2:
                ClientLineInterface.InterfaceTransferencia();
                break;

            case 3:
                ClientLineInterface.InterfaceMeta();
                break;

            case 4:
                ClientLineInterface.InterfaceCategoria();
                break;
            case 5:
                System.out.print("Encerrando o sistema \n");
                System.exit(1);
                break;
        }
    }

    public static void InterfaceUsuario() {
        Scanner sc = new Scanner(System.in);
        String nome;
        String senha;
        List<Usuario> user_list;

        System.out.println("=========================================================");
        System.out.println("| Interface do  Usuario                                 |");
        System.out.println("| 1 - Adicionar Usuario                                 |");
        System.out.println("| 2 - Editar Usuario                                    |");
        System.out.println("| 3 - Remover Usuario                                   |");
        System.out.println("| 4 - Listar Usuarios                                   |");
        System.out.println("| 5 - Buscar Usuario por Nome                           |");
        System.out.println("| 6 - Retornar ao menu inicial                          |");
        System.out.println("| Insira uma opção de (1 ~ 6)                           |");
        System.out.println("=========================================================");

        int decisao = sc.nextInt();

        while (decisao > 6 || decisao < 1) {
            System.out.println("Valor invalido, por favor insira novamente");
            decisao = sc.nextInt();
        }

        switch (decisao) {
            case 1:
                System.out.println("Insira o nome do usuario");
                nome = sc.next();
                System.out.println("Insira a senha do usuario");
                senha = sc.next();
                usuario.cadastrarUsuario(new Usuario(1, nome, senha));
                break;

            case 2:
                user_list = usuario.listarUsuarios();
                System.out.println(user_list);
                System.out.println("Insira o ID do usuario que deverá ser editado");
                int id = sc.nextInt();
                System.out.println("Insira o novo nome do usuario");
                nome = sc.next();
                System.out.println("Insira a nova senha do usuario");
                senha = sc.next();
                usuario.alterarUsuario(new Usuario(id, nome, senha));
                break;

            case 3:
                user_list = usuario.listarUsuarios();
                System.out.println(user_list);
                System.out.println("Insira o ID do usuario que deverá ser deletado");
                id = sc.nextInt();
                usuario.excluirUsuario(new Usuario(id));
                break;

            case 4:
                user_list = usuario.listarUsuarios();
                System.out.println(user_list);
                break;

            case 5:
                System.out.println("Insira o nome de usuário");
                nome = sc.next();
                usuario.buscarUsuarioPorLogin(nome);
                break;

            case 6:
                System.out.print("Retornar ao Menu \n");
                ClientLineInterface.interfaceGeral();
                break;
        }

        System.out.print("Deseja realizar outra operação? S - Sim ou N - Nao\n");
        String d = sc.next();
        if (d.equalsIgnoreCase("s")) {
            ClientLineInterface.InterfaceUsuario();
        }else{
            System.out.print("Encerrando o sistema \n");
            System.exit(1);
        }
    }

    public static void InterfaceTransferencia(){
        Scanner sc = new Scanner(System.in);
        double valor;
        String descricao;
        LocalDate data;
        int recebimento;
        boolean recebimento_b;
        List<Transferencia> transferenciaList;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("=========================================================");
        System.out.println("| Interface de Transferencias                            |");
        System.out.println("| 1 - Adicionar Transferencia                            |");
        System.out.println("| 2 - Editar Transferencia                               |");
        System.out.println("| 3 - Remover Transferencia                              |");
        System.out.println("| 4 - Listar Transferencias                              |");
        System.out.println("| 5 - Buscar Transferencias por ID                       |");
        System.out.println("| 6 - Buscar Transferencias por Categoria                |");
        System.out.println("| 7 - Buscar Transferencias por Usuario                  |");
        System.out.println("| 8 - Buscar Transferencias por Data                     |");
        System.out.println("| 9 - Retornar ao menu inicial                           |");
        System.out.println("| Insira uma opção de (1 ~ 9)                            |");
        System.out.println("=========================================================");

        int decisao = sc.nextInt();

        while (decisao > 9 || decisao < 1) {
            System.out.println("Valor invalido, por favor insira novamente");
            decisao = sc.nextInt();
        }

        switch (decisao) {
            case 1:
                System.out.println("Insira o valor da transferencia");
                valor = sc.nextDouble();
                System.out.println("Insira a descricao da transferencia");
                descricao = sc.next();
                System.out.println("Insira a data da transferencia no modelo dd/MM/yyyy");
                data = LocalDate.parse(sc.next(), formatter);
                System.out.println("Insira o ID do usuário que realizou a transferencia");
                int id_usuario = sc.nextInt();
                System.out.println("Essa transferencia é um recebimento? 1 - Sim | 2 - Não");
                recebimento = sc.nextInt();
                recebimento_b = recebimento == 1;
                System.out.println("Insira o ID da categoria da transferencia");
                int id_categoria = sc.nextInt();
                Transferencia t = new Transferencia(1, valor, descricao, data, new Usuario(id_usuario), recebimento_b, new Categoria(id_categoria));
                transferencia.cadastrarTransferencia(t);
                break;


            case 2:
                transferenciaList = transferencia.buscarTodasTransferencias();
                System.out.println(transferenciaList);
                System.out.println("Insira o ID da Transferencia que será editada");
                int id_transferencia = sc.nextInt();
                System.out.println("Insira o valor da transferencia");
                valor = sc.nextDouble();
                System.out.println("Insira a descricao da transferencia");
                descricao = sc.next();
                System.out.println("Insira a data da transferencia no modelo dd/MM/yyyy");
                data = LocalDate.parse(sc.next(), formatter);
                System.out.println("Insira o ID do usuário que realizou a transferencia");
                id_usuario = sc.nextInt();
                System.out.println("Essa transferencia é um recebimento? 1 - Sim | 2 - Não");
                recebimento = sc.nextInt();
                recebimento_b = recebimento == 1;
                System.out.println("Insira o ID da categoria da transferencia");
                id_categoria = sc.nextInt();

                transferencia.alterarTransferencia(new Transferencia(id_transferencia, valor, descricao, data, new Usuario(id_usuario), recebimento_b, new Categoria(id_categoria)), id_transferencia);
                break;

            case 3:
                transferenciaList = transferencia.buscarTodasTransferencias();
                System.out.println(transferenciaList);
                System.out.println("Insira o ID da transferencia que deverá ser deletada");
                int id = sc.nextInt();
                transferencia.excluirTransferencia(id);
                break;

            case 4:
                transferenciaList = transferencia.buscarTodasTransferencias();
                System.out.println(transferenciaList);
                break;
            case 5:
                System.out.println("Insira o ID da transferencia que deseja buscar");
                id_categoria = sc.nextInt();
                transferenciaList = transferencia.buscarTransferenciasporId(id_categoria);
                System.out.println(transferenciaList);
                break;
            case 6:
                System.out.println("Insira o ID da categoria que deseja buscar");
                id_categoria = sc.nextInt();
                transferenciaList = transferencia.buscarTransferenciasPorCategoria(id_categoria);
                System.out.println(transferenciaList);
                break;
            case 7:
                System.out.println("Insira o ID da transferencia que deseja buscar");
                id_usuario = sc.nextInt();
                transferenciaList = transferencia.buscarTransferenciasporId(id_usuario);
                System.out.println(transferenciaList);
                break;

            case 8:
                System.out.println("Insira a data inicial do range de transferencias que deseja buscar");
                LocalDate data_inicial = LocalDate.parse(sc.next(), formatter);
                System.out.println("Insira a data final do range de transferencias que deseja buscar");
                LocalDate data_final = LocalDate.parse(sc.next(), formatter);
                transferenciaList = transferencia.buscarTransferenciaPorData(data_inicial, data_final);
                System.out.println(transferenciaList);
                break;

            case 9:
                System.out.print("Retornar ao Menu \n");
                ClientLineInterface.interfaceGeral();
        }

        System.out.print("Deseja realizar outra operação? S - Sim ou N - Nao\n");
        String d = sc.next();
        if (d.equalsIgnoreCase("s")) {
            ClientLineInterface.InterfaceTransferencia();
        }else{
            System.out.print("Encerrando o sistema \n");
            System.exit(1);
        }
    }

    public static void InterfaceMeta(){
        Scanner sc = new Scanner(System.in);
        String titulo;
        String descricao;
        int id_meta;
        int id_usuario;
        List<Meta> meta_list;

        System.out.println("=========================================================");
        System.out.println("| Interface de Metas                                     |");
        System.out.println("| 1 - Adicionar Metas                                    |");
        System.out.println("| 2 - Editar Metas                                       |");
        System.out.println("| 3 - Remover Metas                                      |");
        System.out.println("| 4 - Listar Metas por ID                                |");
        System.out.println("| 5 - Buscar Metas por Usuario                           |");
        System.out.println("| 6 - Retornar ao menu inicial                           |");
        System.out.println("| Insira uma opção de (1 ~ 6)                            |");
        System.out.println("=========================================================");

        int decisao = sc.nextInt();

        while (decisao > 6 || decisao < 1) {
            System.out.println("Valor invalido, por favor insira novamente");
            decisao = sc.nextInt();
        }

        switch (decisao){
            case 1:
                System.out.println("Insira o titulo da meta");
                titulo = sc.next();
                System.out.println("Insira a descricao da meta");
                descricao = sc.next();
                System.out.println("Insira o valor da meta");
                double valor = sc.nextDouble();
                System.out.println("A qual usuário essa meta pertence?");
                id_usuario = sc.nextInt();
                Meta m = new Meta(1, titulo, descricao, valor, new Usuario(id_usuario));
                meta.cadastrarMeta(m);
                System.out.println("Meta cadastrada com sucesso!");
                break;
            case 2:
                System.out.println("Insira o ID da meta que deseja editar");
                id_meta = sc.nextInt();
                System.out.println("Insira o titulo da categoria");
                titulo = sc.next();
                System.out.println("Insira a descricao da categoria");
                descricao = sc.next();
                System.out.println("Insira o novo valor da meta");
                valor = sc.nextDouble();
                m = new Meta(id_meta, titulo, descricao, valor, new Usuario(1));
                break;
            case 3:
                System.out.println("Insira o ID da meta que deseja deletar");
                id_meta = sc.nextInt();
                meta.excluirMeta(id_meta);
                break;
            case 4:
                System.out.println("Insira o ID da meta que deseja buscar");
                id_meta = sc.nextInt();
                m = meta.buscarPorId(id_meta);
                System.out.println(m);
                break;
            case 5:
                System.out.println("Insira o ID do Usuario que deseja buscar as metas");
                id_usuario = sc.nextInt();
                meta_list = meta.buscarPorUsuario(id_usuario);
                System.out.println(meta_list);
                break;
            case 6:
                ClientLineInterface.interfaceGeral();
        }

        System.out.print("Deseja realizar outra operação? S - Sim ou N - Nao\n");
        String d = sc.next();
        if (d.equalsIgnoreCase("s")) {
            ClientLineInterface.InterfaceMeta();
        }else{
            System.out.print("Encerrando o sistema \n");
            System.exit(1);
        }
    }

    public static void InterfaceCategoria(){
        Scanner sc = new Scanner(System.in);
        String titulo;
        String descricao;
        int id_categoria;
        List<Categoria> categoria_list;

        System.out.println("=========================================================");
        System.out.println("| Interface de Categoria                                 |");
        System.out.println("| 1 - Adicionar Categoria                                |");
        System.out.println("| 2 - Editar Categoria                                   |");
        System.out.println("| 3 - Remover Categoria                                  |");
        System.out.println("| 4 - Listar Categorias                                  |");
        System.out.println("| 5 - Buscar Categoria por ID                            |");
        System.out.println("| 6 - Retornar ao menu inicial                           |");
        System.out.println("| Insira uma opção de (1 ~ 6)                            |");
        System.out.println("=========================================================");

        int decisao = sc.nextInt();

        while (decisao > 6 || decisao < 1) {
            System.out.println("Valor invalido, por favor insira novamente");
            decisao = sc.nextInt();
        }

        switch (decisao){
            case 1:
                System.out.println("Insira o titulo da categoria");
                titulo = sc.next();
                System.out.println("Insira a descricao da categoria");
                descricao = sc.next();
                Categoria c = new Categoria(1, titulo, descricao);
                categoria.cadastrarCategoria(c);
                System.out.println("Categoria cadastrada com sucesso!");
                break;
            case 2:
                categoria_list = categoria.listarTodasCategorias();
                System.out.println(categoria_list);
                System.out.println("Insira o ID da categoria que deseja editar");
                id_categoria = sc.nextInt();
                System.out.println("Insira o titulo da categoria");
                titulo = sc.next();
                System.out.println("Insira a descricao da categoria");
                descricao = sc.next();
                c = new Categoria(id_categoria, titulo, descricao);
                categoria.alterarCategoria(c);
                break;
            case 3:
                categoria_list = categoria.listarTodasCategorias();
                System.out.println(categoria_list);
                System.out.println("Insira o ID da categoria que deseja deletar");
                id_categoria = sc.nextInt();
                categoria.excluirCategoria(new Categoria(id_categoria));
                break;
            case 4:
                categoria_list = categoria.listarTodasCategorias();
                System.out.println(categoria_list);
                break;
            case 5:
                System.out.println("Insira o ID da categoria que deseja buscar");
                id_categoria = sc.nextInt();
                c = categoria.buscarCategoriaPorId(id_categoria);
                System.out.println(c);
                break;
            case 6:
                ClientLineInterface.interfaceGeral();
        }

        System.out.print("Deseja realizar outra operação? S - Sim ou N - Nao\n");
        String d = sc.next();
        if (d.equalsIgnoreCase("s")) {
            ClientLineInterface.InterfaceCategoria();
        }else{
            System.out.print("Encerrando o sistema \n");
            System.exit(1);
        }
    }
}
