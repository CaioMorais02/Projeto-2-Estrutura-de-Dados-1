package Pessoa;

public class Pessoa {
    
    private String nome;
    private int idade;
    private int quarto;
    public ContaBancaria conta;

    public Pessoa() {

        this.conta = new ContaBancaria();
    }

    public String getNome() {
        return nome;
    }

    public void setQuarto(int quarto)
    {
        this.quarto = quarto;
    }

    public int getQuarto()
    {
        return this.quarto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public void fazendoDeposito(double aumento){
        this.conta.depositar(aumento);
    }

}