package view;

import Arvore.*;
import Pessoa.Pessoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.*;

public class BuildMenu extends JFrame implements ActionListener {
    private Font textFontButao;
    private Font jlabelFont;
    private int action;
    private Pessoa[] p = new Pessoa[100];
    private int QuantidaPessoa = 0;
    private JLabel[] label;
    private JLabel[] quartos;
    private JLabel[] precos;
    private String vet[];
    private JButton b1;
    private JButton b2;
    private JTextField[] field;
    private Arvore<Integer> tree = new Arvore<Integer>();

    public BuildMenu() throws InterruptedException {
        super("MOTEL GO");
        JPanel painel = new JPanel();
        b1 = adicionarBotao(painel, "Cadastrar Cliente");
        b2 = adicionarBotao(painel, "Desocupar Quarto");
        label = dadosClienteJLabel(painel);
        field = dadosClienteTextField(painel);
        vet = preencherVetorQuarto();
        quartos = fazerQuartos(painel,vet);
        vet = preencherVetorPrecos();
        precos = fazerPrecos(painel, vet);

        add(painel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 520);
        setResizable(false);
        setLocation(20, 20);
        setVisible(true);
        // esse arrumar bugs é pra colocar as coisas no seu devido lugar
        // porque não criei eles dinamicamente, e nem sei como cria kkkkk
        arrumarBugs(b1, b2, label, field,quartos, precos);
        // criação da árvore
        criarArvore();
        // Aqui ficará o do-while que controla as ações, porque não da pra
        // usar thread.sleep quando vc clica no botão, então esse do-while
        // é pra poder usar ele e imprimir uma tela de espera quando ação é feita
        this.action = -1;
        do {
            if (action == 1) {
                cadastrarClienteButton(field, painel);
                action = -1;
            }
            else if (action == 2)
            {
                desocuparButton(field[6],painel);
                action = -1;
            }

            Thread.sleep(3);
        } while (action != 0);
    }

    public JLabel[] fazerPrecos(JPanel p, String v[])
    {
        JLabel[] l = new JLabel[8];

        for (int i = 0; i < 8; i++) {
            l[i] = new JLabel(v[i]);
            l[i].setFont(jlabelFont);
            l[i].setForeground(Color.MAGENTA);
            l[i].setBounds(0, 0, 60, 30);
            p.add(l[i]);
        }
        return l;
    }

    public String [] preencherVetorPrecos()
    {
        String v[] = new String[8];
        //450 330 670 980 540 600 250 780
        v[0] = "-    450";
        v[1] = "-    330";
        v[2] = "-    670";
        v[3] = "-    980";
        v[4] = "-    540";
        v[5] = "-    600";
        v[6] = "-    250";
        v[7] = "-    780";
        return v;
    }

    public JLabel[] fazerQuartos(JPanel p, String v[])
    {
        JLabel[] l = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            l[i] = new JLabel(v[i]);
            l[i].setFont(jlabelFont);
            l[i].setForeground(Color.green);
            l[i].setBounds(0, 0, 60, 30);
            p.add(l[i]);
        }
        l[8].setForeground(Color.blue);
        //10 8 5 9 7 18 13 20
        //450 330 670 980 540 600 250 780

        return l;
    }

    public String[] preencherVetorQuarto()
    {
        String v[] = new String[9];
        v[0] = "10";
        v[1] = "8";
        v[2] = "5";
        v[3] = "9";
        v[4] = "7";
        v[5] = "18";
        v[6] = "13";
        v[7] = "20";
        v[8] = "Quartos & Preços:";
        return v;
    }

    public void desocuparButton(JTextField f, JPanel p) throws InterruptedException
    {
        if(verificarNumeroInteiro(f.getText()))
        {
            int flag = tree.ocuparQuarto(Integer.parseInt(f.getText()), 1000,true);
            if(flag == 4)
            {
                mensagem(p, 210, "O quarto foi desocupado!", Color.green);
                pintarQuarto(f,Color.green);
            }
            else if(flag == 5)
            {
                mensagem(p, 210, "O quarto já está desocupado!", Color.red);
            }
            else
            {
                mensagem(p, 210, "Quarto não encontrado!", Color.red);
            }
        }
        else
        {
            mensagem(p, 210, "Preencha o campo abaixo corretamente!", Color.RED);
        }
    }

    public void criarArvore() {
        tree.adicionar(10, 450);
        tree.adicionar(8, 330);
        tree.adicionar(5, 670);
        tree.adicionar(9, 980);
        tree.adicionar(7, 540);
        tree.adicionar(18, 600);
        tree.adicionar(13, 250);
        tree.adicionar(20, 780);
        //10 8 5 9 7 18 13 20
        // 450 330 670 980 540 600 250 780
        /*
         * Arvore<Integer> a1 = new Arvore<Integer>();
         * a1.adicionar(10, 450);
         * a1.ocuparQuarto(9);
         */
    }

    public void cadastrarClienteButton(JTextField[] f, JPanel p) throws InterruptedException {
        String s[] = new String[6];
        for (int i = 0; i < 6; i++) {
            s[i] = new String();
            s[i] = f[i].getText();
        }
        boolean flag = verificarNumeroInteiro(s[1]);
        if (flag)
            flag = verificarNumeroInteiro(s[5]);
        if (flag)
            flag = verificarNumeroRacional(s[4]);
        // esses flag verifica se dentro do textfield são números
        if (flag) {
            flag = verificarStrings(s[0]);
        }
        if (flag) {
            flag = verificarStrings(s[2]);
        }
        if (flag) {
            flag = verificarStrings(s[3]);
        }
        // aqui transmitirá a mensagem de que devemos botar mensagem
        // de erro ou cadastrar a pessoa
        if (flag) {
            getTextFieldToPessoa(f,p);
        } else {
            mensagem(p, 210,"Preencha os campos acima corretamente!",Color.red);
        }
    }

    public void pintarQuarto(JTextField f, Color c)
    {
        for(int i=0;i<8;i++)
        {
            String s = quartos[i].getText();
            if(f.getText().equals(s))
            {
                quartos[i].setForeground(c);
            }
        }
    }

    public void getTextFieldToPessoa(JTextField[] f, JPanel p) throws InterruptedException {

        int quartoAux = Integer.parseInt(f[5].getText());
        double saldoAux = Double.parseDouble(f[4].getText());
        int flag = tree.ocuparQuarto(quartoAux, saldoAux,false);
        if(flag == 1)
        {
            this.p[QuantidaPessoa] = new Pessoa();
            this.p[QuantidaPessoa].setNome(f[0].getText());
            this.p[QuantidaPessoa].setIdade(Integer.parseInt(f[1].getText()));
            this.p[QuantidaPessoa].setQuarto(Integer.parseInt(f[5].getText()));
            this.p[QuantidaPessoa].conta.setAgencia(f[2].getText());
            this.p[QuantidaPessoa].conta.setConta(f[3].getText());
            this.p[QuantidaPessoa].conta.setSaldo(Double.parseDouble(f[4].getText()));
            QuantidaPessoa++;
            mensagem(p, 210,"Quarto ocupado com sucesso!",Color.GREEN);
            pintarQuarto(f[5],Color.RED);
        }
        else if(flag == 2)
        {
            mensagem(p, 210,"Quarto já está ocupado!",Color.red);
        }
        else if (flag == 0)
        {
            mensagem(p, 210,"Quarto "+Integer.parseInt(f[5].getText())+" não encontrado!",Color.red);
        }
        else if (flag == 3)
        {
            mensagem(p, 210,"O valor não é suficiente!",Color.red);
        }

    }

    public void mensagem(JPanel p, int y, String titulo, Color cor) throws InterruptedException {
        JLabel msm = new JLabel(titulo);
        jlabelFont = new Font("Arial", Font.BOLD, 16);
        msm.setFont(jlabelFont);
        msm.setForeground(cor);
        msm.setBounds(2, 2, 280, 30);
        p.add(msm);
        msm.setBounds(250, y, 280, 30);
        Thread.sleep(2000);
        msm.setVisible(false);
        p.remove(msm);
    }

    public boolean verificarStrings(String s) {
        boolean flag = false;
        if (s.length() > 0)
            flag = true;

        return flag;
    }

    public boolean verificarNumeroInteiro(String s) {
        boolean flag = false;
        if (s.length() > 0)
            flag = Character.isDigit(s.charAt(0));
        if (flag) {
            int tam = s.length();
            for (int i = 0; i < tam && flag; i++) {
                flag = Character.isDigit(s.charAt(i));
            }
        }
        return flag;
    }

    public boolean verificarNumeroRacional(String s) {
        boolean flag = false, ponto = true;

        if (s.length() > 0)
            flag = Character.isDigit(s.charAt(0));
        if (flag) {
            int tam = s.length();
            for (int i = 0; i < tam && flag; i++) {
                flag = Character.isDigit(s.charAt(i));
                if (!flag && ponto) {
                    if (s.charAt(i) == '.') {
                        flag = true;
                        ponto = false;
                    }
                }
            }
        }
        return flag;
    }

    public JTextField[] dadosClienteTextField(JPanel painel) {
        JTextField[] t = new JTextField[7];
        for (int i = 0; i < 7; i++) {
            t[i] = new JTextField();
            t[i].setBounds(0, 0, 250, 30);
            // t.setForeground(Color.blue);
            painel.add(t[i]);
        }
        return t;
    }

    public JLabel[] dadosClienteJLabel(JPanel painel) {
        JLabel[] l = new JLabel[7];
        String[] nomes = { "Nome: ", "Idade: ",
                "Agencia: ", "Conta: ", "Saldo: ", "Quarto: " };
        jlabelFont = new Font("Arial", Font.BOLD, 16);
        for (int i = 0; i < 6; i++) {
            l[i] = new JLabel(nomes[i]);
            l[i].setFont(jlabelFont);
            l[i].setForeground(Color.blue);
            l[i].setBounds(0, 0, 180, 30);
            painel.add(l[i]);
        }
        l[6] = new JLabel(nomes[5]);
        l[6].setFont(jlabelFont);
        l[6].setForeground(Color.blue);
        l[6].setBounds(0, 0, 180, 30);
        painel.add(l[6]);
        // altura = 232 / largura = 69
        return l;
    }

    public void arrumarBugs(JButton b1, JButton b2, JLabel l[], JTextField f[], JLabel[] q,JLabel[] p) throws InterruptedException {
        for (int x = 17; x < 20; x++) {
            b1.setBounds(x, 84, 180, 30);
            b2.setBounds(x, 250, 180, 30);
            Thread.sleep(10);
        }
        for (int x = 247; x < 250; x++) {

            for(int i=0,y=2;i<6;i++,y+=33)
            {
                l[i].setBounds(x, y, 180, 30);
            }l[6].setBounds(x, 250, 180, 30);
            for(int i=0,y=2;i<5;i++,y+=33)
            {
                f[i].setBounds(330, y, 250, 30);
            }
            f[5].setBounds(330, 167, 40, 30);
            f[6].setBounds(330, 250, 40, 30);

            q[8].setLocation(20,300);
            for(int i=0,y=320;i<8;i++,y+=20)
            {
                q[i].setLocation(37,y);
                p[i].setLocation(70,y);
            }
            //10 8 5 9 7 18 13 20
        
            Thread.sleep(3);
        }
    }

    private JButton adicionarBotao(JPanel painel, String nome) throws InterruptedException {
        JButton button = new JButton(nome);
        Border border = BorderFactory.createLineBorder(Color.black);
        textFontButao = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16);
        // Font.BOLD
        // Font.BOLD|Font.ITALIC
        // Comic Sans MS
        // Arial
        button.setFont(textFontButao);
        button.setBorder(border);
        // button.setBackground(Color.red);
        // Color teste = new Color(220,0,0);
        button.setForeground(Color.blue);
        button.setBounds(20, 80, 180, 30);
        button.setFocusPainted(false);
        button.setActionCommand(nome);
        button.addActionListener(this);
        painel.add(button);

        return button;
    }

    /*
     * int extracted(){
     * return escolhe.showOpenDialog(null);
     * }
     */

    /*
     * private ActionListener quarto = new ActionListener(){
     * public void actionPerformed(ActionEvent ev){
     * System.out.println("Oi linda");
     * }
     * };
     */

    /*
     * private ActionListener cadastrarCliente = new ActionListener(){
     * 
     * @Override
     * public void actionPerformed(ActionEvent ev){
     * 
     * }
     * };
     */

    @Override
    // estou fazendo dessa forma porque a thread.sleep não pode ficar dentro
    // do botão pra funcionar de forma correta
    public void actionPerformed(ActionEvent e) {
        if ("Cadastrar Cliente".equals(e.getActionCommand()))
            action = 1;
        else if ("Desocupar Quarto".equals(e.getActionCommand()))
            action = 2;

    }

    /*
     * private ActionListener clientefila = new ActionListener(){
     * 
     * @Override
     * public void actionPerformed(ActionEvent ev){
     * 
     * }
     * };
     */
}