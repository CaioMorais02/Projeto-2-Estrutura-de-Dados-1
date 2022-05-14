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
            System.out.println("Número: " + atual.getNum() + " Preço: " + atual.getValor());
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

    public boolean remover(TIPO num){
        //buscar o elemento na árvore
        Elemento<TIPO> atual = this.raiz;
        Elemento<TIPO> paiAtual = null;

        while(atual != null){

            if (atual.getNum().equals(num)){
                break;                
            }
            
            else if (num.compareTo(atual.getNum()) == -1){ //valor procurado é menor que o atual 
                paiAtual = atual;
                atual = atual.getEsquerda();
            }
            
            else{
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }

        //verifica se existe o elemento
        if (atual != null){
            
            //elemento tem 2 filhos ou elemento tem somente filho à direita
            if (atual.getDireita() != null){
                
                Elemento<TIPO> substituto = atual.getDireita();
                Elemento<TIPO> paiSubstituto = atual;

                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }

                substituto.setEsquerda(atual.getEsquerda());

                if (paiAtual != null){

                    if (atual.getNum().compareTo(paiAtual.getNum()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }
                    
                    else{
                        paiAtual.setDireita(substituto);
                    }

                }
                
                else{ //se não tem paiAtual, então é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setEsquerda(null);
                    this.raiz.setDireita(paiSubstituto);
                    this.raiz.setEsquerda(atual.getEsquerda());
                }
                
                //removeu o elemento da árvore
                if (substituto.getNum().compareTo(paiSubstituto.getNum()) == -1){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }
                
                else{
                    paiSubstituto.setDireita(null);
                }
                
            }
            
            else if (atual.getEsquerda() != null){ //tem filho só à esquerda

                Elemento<TIPO> substituto = atual.getEsquerda();
                Elemento<TIPO> paiSubstituto = atual;

                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }

                if (paiAtual != null){

                    if (atual.getNum().compareTo(paiAtual.getNum()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }
                    
                    else{
                        paiAtual.setDireita(substituto);
                    }

                }
                
                else{ //se for a raiz
                    this.raiz = substituto;
                }
                
                //removeu o elemento da árvore
                if (substituto.getNum().compareTo(paiSubstituto.getNum()) == -1){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }
                
                else{
                    paiSubstituto.setDireita(null);
                }

            }
            
            else{ //não tem filho

                if (paiAtual != null){

                    if (atual.getNum().compareTo(paiAtual.getNum()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(null);
                    }
                    
                    else{
                        paiAtual.setDireita(null);
                    }

                }
                
                else{ //é a raiz
                    this.raiz = null;
                }
            }
            
            return true;
        }
        
        else{
            return false;
        }        
    }

}
