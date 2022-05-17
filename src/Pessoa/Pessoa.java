package Pessoa;

public class Pessoa {
    
    private String nome;
    private int idade;
    private ContaBancaria conta;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
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

    public void criarConta(String agencia, String conta, String nome, int senha, double saldo){
        ContaBancaria c = new ContaBancaria(agencia, conta, nome, senha, saldo);
        setConta(c);
    }

    public void fazendoDeposito(double aumento){
        this.conta.depositar(aumento);
    }

}
