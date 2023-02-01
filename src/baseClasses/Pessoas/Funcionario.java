package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import java.io.IOException;
import java.time.LocalDate;

public class Funcionario extends PessoaFisica {

    private String cargo;
    private int cargaHoraria;
    private double salario;
    private static int idAtualFuncionario = 1;

    public Funcionario() {
        super();
    }

    public Funcionario(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo, String cargo, int cargaHoraria, double salario) {
        super(endereco, contato, nome, cpf, dataNascimeto, sexo);
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
    }

    public void set(Funcionario funcionario) {
        super.set(this);
        this.cargo = funcionario.getCargo();
        this.cargaHoraria = funcionario.getCargaHoraria();
        this.salario = funcionario.getSalario();
    }

    public void set(Endereco endereco, Contato contato, String nome, String cpf, LocalDate dataNascimeto, char sexo, String cargo, int cargaHoraria, double salario) {
        super.set(endereco, contato, nome, cpf, dataNascimeto, sexo);
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getSalario() {
        return salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void incrementaIdAtual() {
        idAtual = idAtualFuncionario;
        idAtualFuncionario++;
    }

    public static String validaCargo(String cargo) throws IOException {
        if (cargo.isEmpty()) {
            throw new IOException("Insira o cargo!");
        }
        return cargo;
    }

    public static int validaCargaHoraria(String cargaHoraria) throws IOException {
        if (cargaHoraria.isEmpty()) {
            throw new IOException("Insira a carga horária!");
        }

        int aux;
        try {
            aux = Integer.parseInt(cargaHoraria);
        } catch (NumberFormatException e) {
            throw new IOException("Carga horária invalida!");
        }
        if (aux < 0) {
            throw new IOException("Carga horária invalida!");
        }
        return aux;
    }

    public static double validaSalario(String salario) throws IOException {
        if (salario.isEmpty()) {
            throw new IOException("Insira o salário!");
        }

        double aux;
        try {
            aux = Double.parseDouble(salario);
        } catch (NumberFormatException e) {
            throw new IOException("Salário invalido!");
        }
        if (aux < 0) {
            throw new IOException("Salário invalido!");
        }
        return aux;
    }
}
