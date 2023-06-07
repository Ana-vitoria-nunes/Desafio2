package desafio;

import java.time.LocalDate;
import java.util.*;

public class Registros {
    private List<Vendas> vendas;
    private List<Produto>produtos;
    private Map<Integer, Vendedor> vendedores;
    private Map<Integer, Cliente> clientes;


    Scanner scanner = new Scanner(System.in);
    public Registros() {
        vendas = new ArrayList<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        produtos=new ArrayList<>();
    }
    public void cadastrarVendedor(){

        try {
            System.out.println("Qual seu nome: ");
            scanner.nextLine();
            String nomeV = scanner.nextLine();
            if (!nomeV.matches("[a-zA-Z]+")) {
                throw new InputMismatchException("Valor informado não é uma string!");
            }

            System.out.println("Qual seu email: ");
            String emailV = scanner.nextLine();
            if (!emailV.contains("@")) {
               throw new InputMismatchException("O email precisa conter o @");
            }
            boolean encontrado = false;
            for (Vendedor produto : vendedores.values()) {
                if (!produto.getEmail().equals(emailV)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println(" e-mail já cadastrados para outro vendedor!");
            }
            System.out.println("Qual seu cpf : ");
            String cpfV = scanner.nextLine();
            int numero = Integer.parseInt(cpfV);
           // Vendedor vendedor = new Vendedor(emailV, nomeV,numero);
             if (vendedores.containsKey(numero)) {
                System.out.println("CPF já cadastrados para outro vendedor!");
            } else {
                vendedores.put(numero, new Vendedor(emailV, nomeV,numero));
                System.out.println("Vendedor cadastrado com sucesso!");
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException n) {
            System.out.println("Entrada inválida. Digite um número inteiro válido.");
        }
        }

    public void cadastrarCliente() {
        try {

            System.out.println("Qual seu nome: ");
            String nomeC = scanner.nextLine();
            if (!nomeC.matches("[a-zA-Z]+")) {
                throw new InputMismatchException("Valor informado não é uma string!");
            }
            System.out.println("Qual seu email: ");
            String emailC = scanner.nextLine();
            if (!emailC.contains("@")) {
                throw new InputMismatchException("O email precisa conter o @");
            }

            if (clientes.containsValue(emailC)) {
                System.out.println(" e-mail já cadastrados para outro vendedor!");
            }


            System.out.println("Qual seu cpf: ");
            String  cpfC = scanner.nextLine();
            int numero = Integer.parseInt(cpfC);

            if (vendedores.containsKey(numero)) {
                System.out.println("CPF já cadastrados para outro vendedor!");
            } else {
                vendedores.put(numero, new Vendedor(emailC, nomeC,numero));
                System.out.println("Vendedor cadastrado com sucesso!");
            }

//            Cliente cliente = new Cliente(emailC, nomeC, cpfC);
//            boolean encontrado = false;
//            for (Vendedor produto : vendedores.values()) {
//                if (produto.getEmail().equals(emailC)) {
//                    encontrado = true;
//                    break;
//                }
//            }
//            if (encontrado) {
//                System.out.println(" e-mail já cadastrados para outro cliente!");
//            } else if (!emailC.contains("@")) {
//                System.out.println("O email precisa conter o @");

        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException n) {
            System.out.println("Entrada inválida. Digite um número inteiro válido.");
        }
    }
    public void listaPoduto(){
        produtos.add(new Produto(12,"Bolo de chocolate",5.75));
        produtos.add(new Produto(13,"Bolo de Ninho com nutela",8.99));
        produtos.add(new Produto(14,"Bolo de ninho com morango",8+50));
        produtos.add(new Produto(15,"Bolo de cenoura",5.0));

        System.out.println("=====Produtos disponiveis=====");
        for (Produto produto:produtos) {
            System.out.println("Codigo:"+produto.getCodigo()+"\nProduto:"+produto.getNomeProduto()+"\nPreço:"+produto.getPreco());
            System.out.println("------------------------------------------");
        }
    }

    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            System.out.println("Lista de vendas:");
            for (Vendas venda : vendas) {
                int cont=0;
                cont++;
                System.out.println("Venda "+cont);
                System.out.println("Código: " + venda.getCodigo());
                System.out.println("Produto: " + venda.getNomeProduto());
                System.out.println("Preço: " + venda.getPreco());
                System.out.println("Quantidade: " + venda.getQuantidade());
                System.out.println("Valor Total: " + venda.getValorTotal());
                System.out.println("Vendedor: " + venda.getVendedor().getNome());
                System.out.println("Cliente: " + venda.getCliente().getNome());
                System.out.println("Data: "+venda.getData());
                System.out.println("-----------------------");
            }
        }
    }
    public void listarVendedores() {
        vendedores.put(123,new Vendedor("Ana@nunes","Ana",123));
        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789));
        vendedores.put(456,new Vendedor("Luis@carlos","Luis",456));

        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
        } else {
            System.out.println("Lista de vendedores disponiveis:");
            int cont=0;
            for (Vendedor vendedor : vendedores.values()) {
                cont++;
                System.out.println("Vendedor "+cont);
                System.out.println("CPF: "+vendedor.getCpf());
                System.out.println("E-mail: " + vendedor.getEmail());
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("-----------------------");
            }
        }
    }
    public void listarClientes() {
        clientes.put(000,new Cliente("Ricardo@","Ricardo",000));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de clientes:");
            int cont=0;
            for (Cliente cliente : clientes.values()) {
                cont++;
                System.out.println("Cliente "+cont);
                System.out.println("CPF: "+cliente.getCpf());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("-----------------------");
            }
        }
    }
    public void cadastrarProdutos() {
        clientes.put(000,new Cliente("Ricardo@","Ricardo",000));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        try {

            boolean encontrado = true;
            System.out.println("Qual o cpf do vendedor: ");
            int cpfPV = scanner.nextInt();
//            for (Integer cpf: vendedores.keySet()) {
//                if (Objects.equals(cpf,cpfPV)) {
//                    encontrado = false;
//                    break;
//                }
//            }
//            if (encontrado) {
//                System.out.println("Vendedor não cadastrado!");
//            }
            if (!vendedores.containsKey(cpfPV)) {
                System.out.println("Vendedor não cadastrado!");
                return;
            }
            System.out.println("Qual o cpf do cliente: ");
            scanner.nextLine();
            int cpfPC = scanner.nextInt();
//            for (Integer cpf: clientes.keySet()) {
//                if (Objects.equals(cpf,cpfPC)) {
//                    encontrado = false;
//                    break;
//                }
//            }
//            if (encontrado) {
//                System.out.println("Cliente não cadastrado!");
//            }
            if (!clientes.containsKey(cpfPC)) {
                System.out.println("Cliente não cadastrado!");
                return;
            }
            System.out.println("Qual o codigo do produto que deseja: ");
            int codigo = scanner.nextInt();
            Produto produto=new Produto(0,"",0);
            for (int i=0;i<produtos.size();i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    System.out.println("produto selecionado");
                    produto = produtos.get(i);
                }
            }
            if (produto.getNomeProduto().isEmpty()){
                throw new InputMismatchException("Codigo não encontradp");
            }

//            System.out.println("Qual o nome do produto: ");
//            scanner.nextLine();
//            String nomeProduto = scanner.nextLine();
//
//            System.out.println("Qual o preço do produto: ");
//            double preco = scanner.nextDouble();
            System.out.println("Qual a quantidade: ");
            int quantidade = scanner.nextInt();

            LocalDate data = LocalDate.now();

            Vendedor vendedor = vendedores.get(cpfPV);
            Cliente cliente = clientes.get(cpfPC);
            vendas.add(new Vendas(vendedor, cliente, codigo, produto.getNomeProduto(),produto.getPreco(), quantidade, data));
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }

    }
   public void pesquisarComprasPorCliente() {
        System.out.println("Qual seu cpf de  cliente: ");
        scanner.nextLine();
        int cpfCliente = scanner.nextInt();
        if (clientes.containsKey(cpfCliente)) {
            System.out.println("Compras do cliente com cpf " + cpfCliente + ":");
            for (Vendas venda : vendas) {
                if (clientes.containsKey(cpfCliente)) {
                    System.out.println("Código: " + venda.getCodigo());
                    System.out.println("Produto: " + venda.getNomeProduto());
                    System.out.println("Preço: " + venda.getPreco());
                    System.out.println("Quantidade: " + venda.getQuantidade());
                    System.out.println("Valor Total: " + venda.getValorTotal());
                    System.out.println("-----------------------");
                }
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
    public void pesquisarVendasPorVendedor() {
        System.out.print("Qual seu e-mail de  vendedor: ");
        scanner.nextLine();
        int emailVendedor = scanner.nextInt();
        if (vendedores.containsValue(emailVendedor)) {
            System.out.println("Vendas do vendedor com e-mail " + emailVendedor + ":");
            for (Vendas venda : vendas) {
                if (vendedores.containsValue(emailVendedor)) {
                    System.out.println("Código: " + venda.getCodigo());
                    System.out.println("Produto: " + venda.getNomeProduto());
                    System.out.println("Preço: " + venda.getPreco());
                    System.out.println("Quantidade: " + venda.getQuantidade());
                    System.out.println("Valor Total: " + venda.getValorTotal());
                    System.out.println("-----------------------");
                }
            }
        } else {
            System.out.println("Vendedor não encontrado!");
        }
    }

}