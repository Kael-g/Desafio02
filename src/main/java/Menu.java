import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Menu {

    public static void mostraMenu(){
        System.out.println("------------------- MENU PRINCIPAL -------------------");
        System.out.println("1 - Ver registros");
        System.out.println("2 - Fazer novo cadastro");
        System.out.println("0 - Sair");
    }

    public static void visualizar(){
        System.out.println("-------------------- VER REGISTROS -------------------");
        System.out.println("1 - Listar todos os vendedores");
        System.out.println("2 - Listar todos os clientes");
        System.out.println("3 - Listar todas as vendas");
        System.out.println("4 - Histórico de vendas de um vendedor");
        System.out.println("5 - Histórico de compras de um cliente");
        System.out.println("0 - Voltar");
    }

    public static void cadastro(){
        System.out.println("-------------------- NOVO CADASTRO -------------------");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Cadastrar novo vendedor");
        System.out.println("3 - Cadastrar nova venda");
        System.out.println("0 - Voltar");
    }

    public static void pausa(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pressione enter para continuar");
        in.nextLine();
    }

}
