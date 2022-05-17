package Pessoa;

public class ContaBancaria {
    
    private String agencia;
    private String conta;
    private String nome;
    private int senha;
    private double saldo;

    public ContaBancaria() {
        
    }

    public ContaBancaria(String agencia, String conta, String nome, int senha, double saldo) {
        this.agencia = agencia;
        this.conta = conta;
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double aumento){
        setSaldo(this.saldo + aumento);
    }

    public void sacar(double decremento){
        setSaldo(this.saldo - decremento);
    }

}
