import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GerenciaVendas gerenciaVendas = new GerenciaVendas();
        System.out.println("Boas vindas ao Registro de Vendas!");
        String opcao, nome, cpf, email, valor;
        opcao = "";
        Cliente cliente;
        Vendedor vendedor;

        do {
            try{
                Menu.mostraMenu();
                opcao = in.nextLine();
                switch (opcao){
                    case "1":
                        Menu.visualizar();
                        opcao = in.nextLine();
                        switch (opcao){
                            case "1":
                                System.out.println("---------------- VENDEDORES REGISTRADOS ---------------");
                                gerenciaVendas.listarVendedores();
                                Menu.pausa();
                                break;
                            case "2":
                                System.out.println("----------------- CLIENTES REGISTRADOS ----------------");
                                gerenciaVendas.listarClientes();
                                Menu.pausa();
                                break;
                            case "3":
                                System.out.println("------------------ VENDAS REGISTRADAS -----------------");
                                gerenciaVendas.listarVendas();
                                Menu.pausa();
                                break;
                            case "4":
                                System.out.println("---------- HISTÓRICO DE VENDAS DE UM VENDEDOR ---------");
                                System.out.println("Digite o e-mail do vendedor: ");
                                email = in.nextLine();
                                gerenciaVendas.historicoVendedor(email);
                                Menu.pausa();
                                break;
                            case "5":
                                System.out.println("---------- HISTÓRICO DE COMPRAS DE UM CLIENTE ---------");
                                System.out.println("Digite o cpf do cliente: ");
                                cpf = in.nextLine();
                                gerenciaVendas.historicoCliente(cpf);
                                Menu.pausa();
                                break;
                            case "0":
                                opcao = "volta";
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case "2":
                        Menu.cadastro();
                        opcao = in.nextLine();
                        switch (opcao){
                            case "1":
                                System.out.println("Digite o nome do cliente: ");
                                nome = in.nextLine();
                                System.out.println("Digite o CPF do cliente: ");
                                cpf = in.nextLine();
                                System.out.println("Digite o e-mail do cliente: ");
                                email = in.nextLine();
                                gerenciaVendas.cadastrarCliente(nome, cpf, email);
                                System.out.println("Cliente cadastrado com sucesso!");
                                break;
                            case "2":
                                System.out.println("Digite o nome do vendedor: ");
                                nome = in.nextLine();
                                System.out.println("Digite o CPF do vendedor: ");
                                cpf = in.nextLine();
                                System.out.println("Digite o e-mail do vendedor: ");
                                email = in.nextLine();
                                gerenciaVendas.cadastrarVendedor(nome, cpf, email);
                                System.out.println("Vendedor cadastrado com sucesso!");
                                break;
                            case "3":
                                System.out.println("Digite o CPF do vendedor responsável pela venda: ");
                                cpf = in.nextLine();
                                vendedor = gerenciaVendas.encontrarVendedorCpf(cpf);
                                System.out.println("Digite o CPF do cliente: ");
                                cpf = in.nextLine();
                                cliente = gerenciaVendas.encontrarClienteCpf(cpf);
                                System.out.println("Digite o valor da venda: ");
                                valor = in.nextLine();
                                gerenciaVendas.cadastrarVenda(cliente, vendedor, valor, new Date());
                                System.out.println("Venda cadastrada com sucesso!");
                                break;
                            case "0":
                                opcao = "volta";
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case "0":
                        System.out.println("Finalizando...");
                        break;
                    case "volta":
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } while (!opcao.equals("0"));

        System.out.println("Até mais! :D");
    }

}
