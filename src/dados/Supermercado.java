package dados;

import baseClasses.Contato;
import baseClasses.Endereco;
import baseClasses.Operacoes.Compra;
import baseClasses.Operacoes.Venda;
import baseClasses.Produtos.Produto;
import baseClasses.Pessoas.*;
import baseClasses.Produtos.*;
import baseClasses.IdController;
import java.time.LocalDate;

import java.util.ArrayList;

//Classe que simula um banco de dados >-<
public class Supermercado {

    public static Estoque estoque = new Estoque();
    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    public static ArrayList<Compra> compras = new ArrayList<>();
    public static ArrayList<Venda> vendas = new ArrayList<>();

    public static void supermercadoPreset() { //apenas para testar 
        Produto produto = new Produto("Arroz", "Rei Arthur", 10, 15, 13);
        produtos.add(produto);
        estoque.addProduto(produto);

        produto = new Produto("Feijão", "Carioca", 5, 9, 7);
        produtos.add(produto);
        estoque.addProduto(produto);

        produto = new Produto("Leite", "Itambe", 3, 4, 3.5);
        produtos.add(produto);
        estoque.addProduto(produto);

        produto = new Produto("Oleo", "Liza", 7, 11, 9);
        produtos.add(produto);
        estoque.addProduto(produto);

        funcionarios.add(new Funcionario(new Endereco("MG", "Carmesia", "Centro", "Rua Furbino Jose Soares", 225),
                new Contato("gfhtrhrre@gmail.com", "(31) 954236477"), "Ulisses Andrade Carvalho", "123.423.543-55",
                LocalDate.of(2004, 04, 29), 'M', "Gerente", 40, 5000.0));
        funcionarios.add(new Funcionario(new Endereco("MG", "Carmesia", "Centro", "Rua Furbino Jose Soares", 225),
                new Contato("furbino123@gmail.com", "(31) 944556677"), "Furbino de Lima Carvalho", "432.765.987-12",
                LocalDate.of(1989, 05, 18), 'M', "Gerente-Chefe", 40, 10000.0));

        clientes.add(new Cliente(new Endereco("MG", "Carmesia", "Centro", "Rua Marieta Ferreira Soares", 434),
                new Contato("arthurnunes22@gmail.com", "(31) 98675-6430"), "Arthur Silva Nunes", "123.654.234-99",
                LocalDate.of(2004, 1, 12), 'M', 2000.0));
        clientes.add(new Cliente(new Endereco("MG", "Carmesia", "Centro", "Rua 15 de Novembro", 121),
                new Contato("guilhermegx33@gmail.com", "(31) 95544-9834"), "Guilherme Pereira", "765.534.234-01",
                LocalDate.of(2002, 6, 23), 'M', 1500.0));

        fornecedores.add(new Fornecedor(new Endereco("MG", "Belo Horizonte", "Cidade Industrial", "Rua Madureira Do Carmo", 1967),
                new Contato("estrelachefeSAQ@gmail.com", "(31) 99809-7873"), "Distribuidora Estrela Chefe",
                "Estrela Chefe", "31.654.123/0001-99", "Bebidas"));
    }

    public static IdController where(String tipoClasse, String campo, String valor) {
        if (tipoClasse.equals("produto")) {
            return whereProduto(campo, valor);
        } else if (tipoClasse.equals("cliente")) {
            return whereCliente(campo, valor);
        } else if (tipoClasse.equals("funcionario")) {
            return whereFuncionario(campo, valor);
        } else if (tipoClasse.equals("fornecedor")) {
            return whereFornecedor(campo, valor);
        } else if (tipoClasse.equals("compra")) {
            return whereCompra(campo, valor);
        } else if (tipoClasse.equals("venda")) {
            return whereVenda(campo, valor);
        }
        return null;
        //throw new Exception();
    }

    public static Produto whereProduto(String campo, String valor) {
        if (campo.equals("id")) {
            for (Produto aux : produtos) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("nome")) {
            for (Produto aux : produtos) {
                if (aux.getNome().equals(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("marca")) {
            for (Produto aux : produtos) {
                if (aux.getMarca().equals(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }

    public static Cliente whereCliente(String campo, String valor) {
        if (campo.equals("id")) {
            for (Cliente aux : clientes) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("nome")) {
            for (Cliente aux : clientes) {
                if (aux.getNome().equals(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("cpf")) {
            for (Cliente aux : clientes) {
                if (aux.getCpf().equals(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }

    public static Funcionario whereFuncionario(String campo, String valor) {
        if (campo.equals("id")) {
            for (Funcionario aux : funcionarios) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("nome")) {
            for (Funcionario aux : funcionarios) {
                if (aux.getNome().equals(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("cpf")) {
            for (Funcionario aux : funcionarios) {
                if (aux.getCpf().equals(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }

    public static Fornecedor whereFornecedor(String campo, String valor) {
        if (campo.equals("id")) {
            for (Fornecedor aux : fornecedores) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("razao social")) {
            for (Fornecedor aux : fornecedores) {
                if (aux.getRazaoSocial().equals(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("nome fantasia")) {
            for (Fornecedor aux : fornecedores) {
                if (aux.getNomeFantasia().equals(valor)) {
                    return aux;
                }
            }
            return null;
        } else if (campo.equals("cnpj")) {
            for (Fornecedor aux : fornecedores) {
                if (aux.getCnpj().equals(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }

    public static Compra whereCompra(String campo, String valor) {
        if (campo.equals("id")) {
            for (Compra aux : compras) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }

    public static Venda whereVenda(String campo, String valor) {
        if (campo.equals("id")) {
            for (Venda aux : vendas) {
                if (aux.getId() == Integer.parseInt(valor)) {
                    return aux;
                }
            }
            return null;
        }
        return null;
    }
}
