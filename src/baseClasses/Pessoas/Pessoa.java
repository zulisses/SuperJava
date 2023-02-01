package baseClasses.Pessoas;

import baseClasses.Endereco;
import baseClasses.Contato;
import baseClasses.IdController;

public abstract class Pessoa extends IdController {

    protected Endereco endereco;
    protected Contato contato;

    public Pessoa() {
        super();
        endereco = new Endereco();
        contato = new Contato();
    }

    public Pessoa(Endereco endereco, Contato contato) {
        this.endereco = endereco;
        this.contato = contato;
    }

    protected void set(Pessoa pessoa) {
        this.endereco = pessoa.getEndereco();
        this.contato = pessoa.getContato();
    }

    protected void set(Endereco endereco, Contato contato) {
        this.endereco = endereco;
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
