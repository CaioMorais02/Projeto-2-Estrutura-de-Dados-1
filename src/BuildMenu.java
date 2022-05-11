package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BuildMenu extends JFrame {

    private JFileChooser escolhe = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas arquivos jff", "jff");

public BuildMenu(){
    super("MOTEL GO");

    JButton botao = new JButton("Selecionar o quarto");
    JButton botao1 = new JButton("Cadastro do cliente");
    JButton botao2 = new JButton("Colocar cliente na fila");

    escolhe.setFileFilter(filter);
    this.setLocationRelativeTo(null);
    JPanel painel = new JPanel();

    botao.setBounds(90,20,100,30);
    botao1.setBounds(120,60,100,60);
    botao2.setBounds(150,100,100,90);

    painel.add(botao);
    painel.add(botao1);
    painel.add(botao2);

    botao.addActionListener(quarto);
    botao.addActionListener(cadastrarcliente);
    botao2.addActionListener(clientefila);

    add(painel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    setSize(240,160);
}

    int extracted(){
        return escolhe.showOpenDialog(null);
    }

    private ActionListener quarto = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){

        }
    };

    private ActionListener cadastrarcliente = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){

        }
    };

    private ActionListener clientefila = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){

        }
    };
}