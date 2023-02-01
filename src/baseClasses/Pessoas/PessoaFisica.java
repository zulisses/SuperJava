package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PessoaFisica extends Pessoa {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private char sexo;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo) {
        super(endereco, contato);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimeto;
        this.sexo = sexo;
    }

    protected void set(PessoaFisica pessoaFisica) {
        super.set(this);
        this.nome = pessoaFisica.getNome();
        this.cpf = pessoaFisica.getCpf();
        this.dataNascimento = pessoaFisica.getDataNascimeto();
        this.sexo = pessoaFisica.getSexo();
    }

    protected void set(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo) {
        super.set(endereco, contato);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimeto;
        this.sexo = sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setDataNascimeto(LocalDate dataNascimeto) {
        this.dataNascimento = dataNascimeto;
    }

    public LocalDate getDataNascimeto() {
        return dataNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public static String validaNome(String nome) throws IOException {
        if (nome.isEmpty()) {
            throw new IOException("Insira o nome!");
        }
        return nome;
    }

    public static String validaCpf(String cpf) throws IOException {
        if (cpf.isEmpty()) {
            throw new IOException("Insira o CPF!");
        }

        //\d{3}\.\d{3}\.\d{3}\-\d{2}
        Pattern pattern = Pattern.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.find()) {
            if (cpf.charAt(3) != '.') {
                cpf = cpf.substring(0, 3) + "." + cpf.substring(3);
            }
            if (cpf.charAt(7) != '.') {
                cpf = cpf.substring(0, 7) + "." + cpf.substring(7);
            }
            if (cpf.charAt(11) != '-') {
                cpf = cpf.substring(0, 11) + "-" + cpf.substring(11);
            }
        } else {
            throw new IOException("CPF invalido!");
        }
        return cpf;
    }

    public static LocalDate validaDataNascimento(LocalDate dataNascimento) throws IOException {
        if (dataNascimento == null) {
            throw new IOException("Insira a data de nascimento!");
        }
        if (dataNascimento.isAfter(LocalDate.now().minusYears(18))) {
            throw new IOException("Data de nascimento invalida!");
        }
        return dataNascimento;
    }

    public static char validaSexo(String sexo) throws IOException {
        if (sexo.isEmpty()) {
            throw new IOException("Insira o sexo!");
        }
        return sexo.charAt(0);
    }
}
