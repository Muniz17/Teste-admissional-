package teste;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Produto {
    String nome;
    float dose;
    float preco;

    Produto(String nome, float dose, float preco) {
        this.nome = nome;
        this.dose = dose;
        this.preco = preco;
    }
}

class Empresa {
    private List<Produto> produtos;
    private float totalVendas;
    private float comissao;
    private List<ItemCarrinho> carrinho;

    public Empresa() {
        produtos = new ArrayList<>();
        totalVendas = 0;
        comissao = 0.10f; 
        carrinho = new ArrayList<>();
    }

    public void adicionarProduto(String nome, float dose, float preco) {
        Produto produto = new Produto(nome, dose, preco);
        produtos.add(produto);
    }

    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.printf("%d. %s %.2fmg - R$%.2f\n", i + 1, produto.nome, produto.dose, produto.preco);
        }
    }

    public void removerProduto(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.remove(indice);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Índice inválido. O produto não foi removido.");
        }
    }

    public void adicionarAoCarrinho(int indiceProduto, int quantidade) {
        if (indiceProduto >= 0 && indiceProduto < produtos.size()) {
            Produto produto = produtos.get(indiceProduto);
            carrinho.add(new ItemCarrinho(produto, quantidade));
            System.out.println("Produto adicionado ao carrinho.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public float calcularTotalCarrinho() {
        float total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.produto.preco * item.quantidade;
        }
        return total;
    }

    public float calcularComissao() {
        float totalVendasCarrinho = calcularTotalCarrinho();
        comissao = totalVendasCarrinho * comissao; // Calcula a comissão com base no total de vendas.
        return comissao;
    }

    public void realizarVenda() {
        float totalCarrinho = calcularTotalCarrinho();
        float comissao = calcularComissao();
        totalVendas += totalCarrinho; // Adicione o total do carrinho à venda total.
        System.out.printf("Venda realizada! Total da venda: R$%.2f\n", totalCarrinho);
        System.out.printf("Comissão a ser paga: R$%.2f\n", comissao);
        carrinho.clear(); // Limpe o carrinho após a venda.
    }

    public float getTotalVendas() {
        return totalVendas;
    }
}

class ItemCarrinho {
    Produto produto;
    int quantidade;

    ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
}

public class projetotgid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 1;

        Empresa empresa = new Empresa();

        while (num != 0) {
            clearScreen();

            System.out.println("----------- Selecione a opção -------------");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Adicionar ao Carrinho");
            System.out.println("5. Realizar Venda");
            System.out.println("6. Relatórios de Vendas");
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");
            num = scanner.nextInt();

            if (num == 1) {
                scanner.nextLine();
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite a dose (mg): ");
                float dose = scanner.nextFloat();
                System.out.print("Digite o preço: ");
                float preco = scanner.nextFloat();
                empresa.adicionarProduto(nome, dose, preco);
                System.out.println("Produto adicionado com sucesso.");
            } else if (num == 2) {
                clearScreen();
                System.out.println("Lista de Produtos:");
                empresa.listarProdutos();
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            } else if (num == 3) {
                clearScreen();
                System.out.println("Lista de Produtos:");
                empresa.listarProdutos();
                System.out.print("Digite o índice do produto a ser removido: ");
                int indiceRemover = scanner.nextInt();
                empresa.removerProduto(indiceRemover - 1); // Subtrai 1 para corresponder ao índice na lista.
            } else if (num == 4) {
                clearScreen();
                System.out.println("Lista de Produtos:");
                empresa.listarProdutos();
                System.out.print("Digite o índice do produto a ser adicionado ao carrinho: ");
                int indiceProduto = scanner.nextInt();
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                empresa.adicionarAoCarrinho(indiceProduto - 1, quantidade); // Subtrai 1 para corresponder ao índice na lista.
            } else if (num == 5) {
                clearScreen();
                empresa.realizarVenda();
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            } else if (num == 6) {
                clearScreen();
                System.out.println("Total de Vendas: R$" + empresa.getTotalVendas());
                System.out.println("Comissão Total: R$" + empresa.calcularComissao());
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            } else if (num == 0) {
                System.out.println("Saindo do programa.");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[J");
    }
}
