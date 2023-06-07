package desafio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Registros registros=new Registros();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 9) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar vendedor");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Cadastrar venda");
            System.out.println("4. Listar vendas");
            System.out.println("5. Listar vendedores");
            System.out.println("6. Listar clientes");
            System.out.println("7. Pesquisar compras por cliente");
            System.out.println("8. Pesquisar vendas por vendedor");
            System.out.println("7. Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                        registros.cadastrarVendedor();

                    break;
                case 2:
                    registros.cadastrarCliente();
                    break;
                case 3:
                    registros.listaPoduto();
                    registros.listarVendedores();
                    registros.cadastrarProdutos();
                    break;
                case 4:
                    registros.listarVendas();
                    break;
                case 5:
                    registros.listarVendedores();
                    break;
                case 6:
                    registros.listarClientes();
                    break;
                case 7:
                    registros.pesquisarComprasPorCliente();
                    break;
                case 8:
                    registros.pesquisarVendasPorVendedor();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        }
    }
}