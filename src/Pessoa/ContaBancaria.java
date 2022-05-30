package Pessoa;

public class ContaBancaria {
    
    private String agencia;
    private String conta;
    private double saldo;

    public ContaBancaria() {
        
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