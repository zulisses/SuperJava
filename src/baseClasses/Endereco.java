package baseClasses;

import java.io.IOException;

public class Endereco {

    private String uf;
    private String cidade;
    private String rua;
    private String bairro;
    private int numero;

    public Endereco() {
    }

    public Endereco(String uf, String cidade, String bairro, String rua, int numero) {
        this.uf = uf;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public void set(String uf, String cidade, String bairro, String rua, int numero) {
        this.uf = uf;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }

    public static String validaUf(String uf) throws IOException {
        if (uf.isEmpty()) {
            throw new IOException("Insira a UF!");
        }
        return uf;
    }

    public static String validaCidade(String cidade) throws IOException {
        if (cidade.isEmpty()) {
            throw new IOException("Insira a cidade!");
        }
        return cidade;
    }

    public static String validaRua(String rua) throws IOException {
        if (rua.isEmpty()) {
            throw new IOException("Insira a rua!");
        }
        return rua;
    }

    public static String validaBairro(String bairro) throws IOException {
        if (bairro.isEmpty()) {
            throw new IOException("Insira o bairro!");
        }
        return bairro;
    }

    public static int validaNumero(String numero) throws IOException {
        if (numero.isEmpty()) {
            throw new IOException("Insira o número!");
        }

        int aux;
        try {
            aux = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new IOException("Número invalido!");
        }
        if (aux < 0) {
            throw new IOException("Número invalido!");
        }
        return aux;
    }
}
