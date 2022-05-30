package Arvore;

//Esta classe é apenas para testes da árvore!!!

public class AppArvore {
    public static void main(String[] args) {
        Arvore<Integer> a1 = new Arvore<Integer>();
        

        a1.adicionar(10, 450);
        a1.adicionar(8, 330);
        a1.adicionar(5, 670);
        a1.adicionar(9, 980);
        a1.adicionar(7, 540);
        a1.adicionar(18, 600);
        a1.adicionar(13, 250);
        a1.adicionar(20, 780);

        a1.ocuparQuarto(10,2222,false);
        a1.ocuparQuarto(18,2222,false);
        a1.ocuparQuarto(5,2222,false);
        a1.ocuparQuarto(7,2222,false);
        a1.ocuparQuarto(9,2222,false);

        System.out.println("\nEm ordem:");
        a1.emOrdem(a1.getRaiz());

    }
}
