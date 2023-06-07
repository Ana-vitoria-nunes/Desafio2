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
        vendedores.put(123,new Vendedor("Ana@nunes","Ana",123));
        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789));
        vendedores.put(456,new Vendedor("Luis@carlos","Luis",456));

        try {
            System.out.println("Qual seu nome: ");
            String nomeV = scanner.nextLine();
            System.out.println();
            if (!nomeV.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!");
            }

            System.out.println("Qual seu email: ");
            String emailV = scanner.nextLine();
            System.out.println();
            if (!emailV.contains("@")) {
               throw new IllegalArgumentException("O email precisa conter o @");
            }
            boolean encontrado = false;
            for (Vendedor produto : vendedores.values()) {
                if (produto.getEmail().equals(emailV)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail já cadastrados para outro vendedor!");
            }

            System.out.println("Qual seu cpf : ");
            String cpfV = scanner.nextLine();
            System.out.println();
            int numero = Integer.parseInt(cpfV);
             if (vendedores.containsKey(numero)) {
               throw new IllegalArgumentException("CPF já cadastrados para outro vendedor!");
            } else {
                vendedores.put(numero, new Vendedor(emailV, nomeV,numero));
                System.out.println("Vendedor cadastrado com sucesso!");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro; "+e.getMessage());
        }
    }
    public void cadastrarCliente() {
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        try {
            System.out.println("Qual seu nome: ");
            String nomeC = scanner.nextLine();
            if (!nomeC.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!");
            }
            System.out.println("Qual seu email: ");
            String emailC = scanner.nextLine();
            if (!emailC.contains("@")) {
                throw new IllegalArgumentException("O email precisa conter o @");
            }
            boolean encontrado = false;
            for (Cliente produto : clientes.values()) {
                if (produto.getEmail().equals(emailC)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail já cadastrados para outro cliente!");
            }

            System.out.println("Qual seu cpf: ");
            String  cpfC = scanner.nextLine();
            int numero = Integer.parseInt(cpfC);

            if (clientes.containsKey(numero)) {
                throw new IllegalArgumentException("CPF já cadastrados para outro Cliente!");
            } else {
                clientes.put(numero, new Cliente(emailC, nomeC,numero));
                System.out.println("Cliente cadastrado com sucesso!");
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void listaPoduto(){
        produtos.add(new Produto(12,"Bolo de chocolate",5.75));
        produtos.add(new Produto(13,"Bolo de Ninho com nutela",8.99));
        produtos.add(new Produto(14,"Bolo de ninho com morango",8.50));
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
            System.out.println("=====Lista de vendas=====");
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
            System.out.println("=====Lista de vendedores disponiveis=====:");
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
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("=====Lista de clientes=====");
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
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        try {

            System.out.println("Escolha um dos vendedores acima e digite o cpf dele: ");
            int cpfPV = scanner.nextInt();
            System.out.println();
            if (!vendedores.containsKey(cpfPV)) {
                throw new IllegalArgumentException("Vendedor não cadastrado!");
            }
            System.out.println("Qual seu cpf de cliente: ");
            int cpfPC = scanner.nextInt();
            System.out.println();
            if (!clientes.containsKey(cpfPC)) {
                throw new IllegalArgumentException("Cliente não cadastrado!");
            }
            System.out.println("Qual o codigo do produto que deseja: ");
            int codigo = scanner.nextInt();
            Produto produto=new Produto(0,"",0);
            for (int i=0;i<produtos.size();i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    System.out.println();
                    produto = produtos.get(i);
                }
            }
            if (produto.getNomeProduto().isEmpty()){
                throw new IllegalArgumentException("Codigo não encontrado");
            }
            System.out.println("Quantas unidades deseja desse produto: ");
            int quantidade = scanner.nextInt();
            System.out.println();
            LocalDate data = LocalDate.now();
            Vendedor vendedor = vendedores.get(cpfPV);
            Cliente cliente = clientes.get(cpfPC);
            vendas.add(new Vendas(vendedor, cliente, codigo, produto.getNomeProduto(),produto.getPreco(),quantidade, data));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
   public void pesquisarComprasPorCliente() {
        System.out.println("Qual seu cpf de  cliente: ");
        int cpfCliente = scanner.nextInt();
       System.out.println();
        if (!clientes.containsKey(cpfCliente)) {
            System.out.println("Compras do cliente com cpf " + cpfCliente + ":");
            for (Vendas venda : vendas) {
                if (!clientes.containsKey(cpfCliente)) {
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
        String emailVendedor = scanner.nextLine();
        System.out.println();
        if (!vendedores.containsValue(emailVendedor)) {
            System.out.println("Vendas do vendedor com e-mail " + emailVendedor + ":");
            for (Vendas venda : vendas) {
                if (!vendedores.containsValue(emailVendedor)) {
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