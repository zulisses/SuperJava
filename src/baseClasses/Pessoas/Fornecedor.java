package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import java.io.IOException;

public class Fornecedor extends PessoaJuridica {

    private String ramoAtividade;
    private static int idAtualFornecedor = 1;

    public Fornecedor() {
        super();
    }

    public Fornecedor(Endereco endereco, Contato contato, String razaoSocial, String nomeFantasia, String cnpj, String ramoAtividade) {
        super(endereco, contato, razaoSocial, nomeFantasia, cnpj);
        this.ramoAtividade = ramoAtividade;
    }

    public void set(Fornecedor fornecedor) {
        super.set(fornecedor);
        this.ramoAtividade = fornecedor.getRamoAtividade();
    }

    public void set(Endereco endereco, Contato contato, String razaoSocial, String nomeFantasia, String cnpj, String ramoAtividade) {
        super.set(endereco, contato, razaoSocial, nomeFantasia, cnpj);
        this.ramoAtividade = ramoAtividade;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualFornecedor;
        idAtualFornecedor++;
    }

    public static String validaRamoAtividade(String ramoAtividade) throws IOException {
        if (ramoAtividade.isEmpty()) {
            throw new IOException("Insira o ramo de atividade!");
        }
        return ramoAtividade;
    }
}
