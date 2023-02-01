package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import java.io.IOException;
import java.time.LocalDate;

public class Cliente extends PessoaFisica {

    private double limiteCredito;
    private static int idAtualCliente = 1;

    public Cliente() {
        super();
    }

    public Cliente(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo, double limiteCredito) {
        super(endereco, contato, nome, cpf, dataNascimeto, sexo);
        this.limiteCredito = limiteCredito;
    }

    public void set(Cliente cliente) {
        super.set(this);
        this.limiteCredito = cliente.getLimiteCredito();
    }

    public void set(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo, double limiteCredito) {
        super.set(endereco, contato, nome, cpf, dataNascimeto, sexo);
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCompra) {
        this.limiteCredito = limiteCompra;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualCliente;
        idAtualCliente++;
    }

    public static double validaLimiteCredito(String limiteCredito) throws IOException {
        double aux;
        if (limiteCredito.isEmpty()) {
            throw new IOException("Insira o limite de crédito!");
        }
        try {
            aux = Double.parseDouble(limiteCredito);
        } catch (NumberFormatException e) {
            throw new IOException("Limite de crédito invalido!");
        }
        if (aux < 0) {
            throw new IOException("Limite de crédito invalido!");
        }
        return aux;
    }
}
