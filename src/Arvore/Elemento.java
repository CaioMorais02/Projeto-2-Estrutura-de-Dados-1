package Arvore;

public class Elemento<TIPO> {
    
    private TIPO num;
    private int valor;
    private Elemento<TIPO> esquerda;
    private Elemento<TIPO> direita;

    public Elemento(TIPO num, int valor) {
        this.num = num;
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public TIPO getNum() {
        return num;
    }

    public void setNum(TIPO num) {
        this.num = num;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Elemento<TIPO> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<TIPO> esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento<TIPO> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<TIPO> direita) {
        this.direita = direita;
    }

}
