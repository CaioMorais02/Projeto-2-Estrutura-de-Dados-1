package Arvore;

public class Arvore<TIPO extends Comparable> {
    
    private Elemento<TIPO> raiz;

    public Arvore(){
        this.raiz = null;
    }

    public Elemento<TIPO> getRaiz() {
        return raiz;
    }

    public void setRaiz(Elemento<TIPO> raiz) {
        this.raiz = raiz;
    }

    public void adicionar(TIPO num, int valor){
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(num, valor);

        if (raiz == null){ //Insere um valor caso a árvore esteja vazia
            this.raiz = novoElemento;
        }

        else { //Caso não esteja vazia, irá verificar se o nó irá para a esquerda ou direita
            Elemento<TIPO> atual = this.raiz; //Variável para percorrer a árvore

            while(true){

                if (novoElemento.getNum().compareTo(atual.getNum()) == -1){ //Se o valor do novo nó for menor que o atual, irá para a esquerda
                    
                    if (atual.getEsquerda() != null){ //Condição para que a variável atual percorra a árvore mais a esquerda
                        atual = atual.getEsquerda();
                    }

                    else { //Insere um novo valor quando achar um local nulo
                        atual.setEsquerda(novoElemento);
                        break;
                    }

                }

                else { //Se o valor do novo nó for maior ou igual ao atual, irá para a direita

                    if(atual.getDireita() != null){ //Condição para que a variável atual percorra a árvore mais a direita
                        atual = atual.getDireita();
                    }

                    else {
                        atual.setDireita(novoElemento);
                        break;
                    }

                }

            }

        }

    }

    public void emOrdem(Elemento<TIPO> atual){
        if (atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println("Número: " + atual.getNum() + " Preço: " + atual.getValor() + " Ocupado: " + atual.isOcupado());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Elemento<TIPO> atual){
        if (atual != null){
            System.out.println("Número: " + atual.getNum() + " Preço: " + atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Elemento<TIPO> atual){
        if (atual != null){
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println("Número: " + atual.getNum() + " Preço: " + atual.getValor());
        }
    }

    public void ocuparQuarto(TIPO num){
        Elemento<TIPO> atual = this.raiz;

        while (true){
            if (atual.getNum().equals(num)){
                atual.setOcupado(true);
                break;
            }

            else if (num.compareTo(atual.getNum()) == -1){ //valor procurado é menor que o atual
                atual = atual.getEsquerda();
            }

            else {
                atual = atual.getDireita();
            }
        }

    }

}
