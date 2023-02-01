package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PessoaJuridica extends Pessoa {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(Endereco endereco, Contato contato, String razaoSocial, String nomeFantasia, String cnpj) {
        super(endereco, contato);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    protected void set(PessoaJuridica pessoaJuridica) {
        super.set(this);
        this.razaoSocial = pessoaJuridica.getRazaoSocial();
        this.nomeFantasia = pessoaJuridica.getNomeFantasia();
        this.cnpj = pessoaJuridica.getCnpj();
    }

    protected void set(Endereco endereco, Contato contato, String razaoSocial, String nomeFantasia, String cnpj) {
        super.set(endereco, contato);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static String validaRazaoSocial(String razaoSocial) throws IOException {
        if (razaoSocial.isEmpty()) {
            throw new IOException("Insira a razão social!");
        }
        return razaoSocial;
    }

    public static String validaNomeFantasia(String nomeFantasia) throws IOException {
        if (nomeFantasia.isEmpty()) {
            throw new IOException("Insira o nome fantasia!");
        }
        return nomeFantasia;
    }

    public static String validaCpf(String cnpj) throws IOException {
        if (cnpj.isEmpty()) {
            throw new IOException("Insira o CNPJ!");
        }

        //\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}
        Pattern pattern = Pattern.compile("[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}");
        Matcher matcher = pattern.matcher(cnpj);
        if (matcher.find()) {
            if (cnpj.charAt(2) != '.') {
                cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2);
            }
            if (cnpj.charAt(6) != '.') {
                cnpj = cnpj.substring(0, 6) + "." + cnpj.substring(6);
            }
            if (cnpj.charAt(10) != '/') {
                cnpj = cnpj.substring(0, 10) + "/" + cnpj.substring(10);
            }
            if (cnpj.charAt(15) != '-') {
                cnpj = cnpj.substring(0, 15) + "-" + cnpj.substring(15);
            }
        } else {
            throw new IOException("CNPJ invalido!");
        }
        return cnpj;
    }
}
