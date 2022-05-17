package view;

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

public class BuildMenu extends JFrame implements ActionListener{
private Font textFontButao;
private Font jlabelFont;

public BuildMenu() throws InterruptedException{
    super("MOTEL GO");
    JPanel painel = new JPanel();
    JButton b1 = adicionarBotao(painel,"Cadastrar cliente");
    JLabel[] label = dadosClienteJLabel(painel);
    JTextField[] field = dadosClienteTextField(painel);

    add(painel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(700,500);
    setResizable(false);
    setLocation(20,20);
    setVisible(true);
    //esse arrumar bugs é pra colocar as coisas no seu devido lugar
    //porque não criei eles dinamicamente, e nem sei como cria kkkkk
    arrumarBugs(b1, label, field);
}

    public JTextField[] dadosClienteTextField(JPanel painel)
    {
        JTextField[] t = new JTextField[3];
        jlabelFont = new Font("Arial",Font.BOLD,16);
        for(int i=0;i<3;i++)
        {
            t[i] = new JTextField();
            //t.setForeground(Color.blue);
            painel.add(t[i]);
        }
        return t;
    }

    public JLabel[] dadosClienteJLabel(JPanel painel)
    {
        JLabel[] l = new JLabel[3];
        String[] nomes={"Nome do cliente: ","Saldo do cliente: ",
        "Quarto a alugar: "};
        jlabelFont = new Font("Arial",Font.BOLD,16);
        for(int i=0;i<3;i++)
        {
            l[i] = new JLabel(nomes[i]);
            l[i].setFont(jlabelFont);
            l[i].setForeground(Color.blue);
            painel.add(l[i]);
        }
        return l;
    }

    public void arrumarBugs(JButton b,JLabel l[], JTextField f[]) throws InterruptedException
    {
        for(int x=17;x<20;x++){
            b.setBounds(x,200,180,30);
            Thread.sleep(10);
            }
        for(int x = 247; x<250;x++)
        {
            l[0].setBounds(x,100,180,30);
            l[1].setBounds(x,200,180,30);
            l[2].setBounds(x,300,180,30);
            Thread.sleep(3);
        }
        for(int x = 385;x<390;x++)
        {
            f[0].setBounds(x,100,250,30);
            f[1].setBounds(x,200,180,30);
            f[2].setBounds(x,300,30,30);
            Thread.sleep(3);
        }
    }

    private JButton adicionarBotao(JPanel painel, String nome) throws InterruptedException
    {
        JButton button = new JButton(nome);
        Border border = BorderFactory.createLineBorder(Color.black);
        textFontButao  = new Font("Comic Sans MS",Font.BOLD|Font.ITALIC,16);
        //Font.BOLD
        //Font.BOLD|Font.ITALIC
        //Comic Sans MS
        //Arial
        button.setFont(textFontButao);
        button.setBorder(border);
        //button.setBackground(Color.red);
        //Color teste = new Color(220,0,0);
        button.setForeground(Color.blue);
        button.setBounds(20,80,180,30);
        button.setFocusPainted(false);
        button.setActionCommand("cadastrarCliente");
        button.addActionListener(this);
        painel.add(button);
        
        return button;
    }

    /*int extracted(){
        return escolhe.showOpenDialog(null);
    }*/

    /*private ActionListener quarto = new ActionListener(){
        public void actionPerformed(ActionEvent ev){
            System.out.println("Oi linda");
        }
    };*/

    /*private ActionListener cadastrarCliente = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){

        }
    };*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if("cadastrarCliente".equals(e.getActionCommand()))
        {
            System.out.println("Oi linda");
        }
        
    }

    /*private ActionListener clientefila = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){

        }
    };*/
}