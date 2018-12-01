
package LaneAttack;

import static LaneAttack.TelaPrincipal.loadImage;
import com.towel.swing.img.JImagePanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;


public class TelaPrincipal extends javax.swing.JFrame {
    
    protected AtorJogador atorJogador = AtorJogador.getInstance(this);
    protected boolean emRede = false;
    
    
    private JMenuItem novaPartida, conectar, desconectar;
    
    private JLabel placarj1;
    private JLabel placarj2;
    
    private JLabel imagemj1, imagemj2;

    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JLabel nomej1, nomej2;
    
    private JImagePanel cenario;
    private JImagePanel personagem1, personagem2, personagem3, personagem4, personagem5, personagem6;
    

    public TelaPrincipal() throws IOException {
        initComponents();
        setPeronagens();
        setVisible(true);
    }
    
    
    private ActionListener btManager = event -> {
        if (event.getSource().equals(novaPartida)) {
            if (!atorJogador.iniciarPartida()) {
                JOptionPane.showMessageDialog(TelaPrincipal.this, "É necessário estar conectado!", "Não conectado", JOptionPane.ERROR_MESSAGE);
            }
            if (atorJogador.aguardandoJogador()) {
                JOptionPane.showMessageDialog(TelaPrincipal.this, "Não existem jogadores suficientes no servidor, tente novamente.", "Aguarde", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (event.getSource().equals(conectar)) {
            if (atorJogador.conectar(solicitarNomeDoJogador())) {

                JOptionPane.showMessageDialog(TelaPrincipal.this, "Conexão realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao conectar!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource().equals(desconectar)) {
            AtorJogador.getInstance(this).desconectar();
        }
    };

    private String solicitarNomeDoJogador() {
        String nome = JOptionPane.showInputDialog(this, "Insira o nome do jogador", "Nome", JOptionPane.QUESTION_MESSAGE);
        if (nome == null || nome.isEmpty() || nome.equals(" ")) {
            solicitarNomeDoJogador();
        }
        System.out.println(nome);
        return nome;
    }
    
    public void setPeronagens() throws IOException {
        personagem1 = new JImagePanel(100, new BufferedImage[] {
                loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"),
                loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente3.png")});
        cenario.add(personagem1);
        
    }

    public static BufferedImage loadImage(String file) throws IOException {
        return ImageIO.read(new File(file));
    }

   
  
    private void initComponents() throws IOException {

        cenario = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/Mapa.png"));
        
        imagemj1 = new javax.swing.JLabel();
        imagemj2 = new javax.swing.JLabel();
        placarj1 = new javax.swing.JLabel();
        placarj2 = new javax.swing.JLabel();
        nomej1 = new javax.swing.JLabel();
        nomej2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        novaPartida = new javax.swing.JMenuItem();
        conectar = new javax.swing.JMenuItem();
        desconectar = new javax.swing.JMenuItem();
        
        personagem1 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        personagem2 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        personagem3 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        personagem4 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        personagem5 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        personagem6 = new JImagePanel(loadImage("/home/darlan/eclipse-workspace/LANE2/Lane-Attack/src/Imagenss/FeiticeiraFrente1.png"));
        
        novaPartida.addActionListener(btManager);
        conectar.addActionListener(btManager);
        desconectar.addActionListener(btManager);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.gray);
        setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));

        cenario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));

        personagem5.setBorder(null);
        

        GroupLayout personagem5Layout = new GroupLayout(personagem5);
        personagem5.setLayout(personagem5Layout);
        personagem5Layout.setHorizontalGroup(
            personagem5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        personagem5Layout.setVerticalGroup(
            personagem5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personagem2.setBorder(null);
        personagem2.setPreferredSize(new java.awt.Dimension(47, 47));

        javax.swing.GroupLayout personagem2Layout = new GroupLayout(personagem2);
        personagem2.setLayout(personagem2Layout);
        personagem2Layout.setHorizontalGroup(
            personagem2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
        personagem2Layout.setVerticalGroup(
            personagem2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        personagem4.setBorder(null);

        javax.swing.GroupLayout personagem4Layout = new GroupLayout(personagem4);
        personagem4.setLayout(personagem4Layout);
        personagem4Layout.setHorizontalGroup(
            personagem4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        personagem4Layout.setVerticalGroup(
            personagem4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        personagem1.setBorder(null);

        javax.swing.GroupLayout personagem1Layout = new GroupLayout(personagem1);
        personagem1.setLayout(personagem1Layout);
        personagem1Layout.setHorizontalGroup(
            personagem1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
        personagem1Layout.setVerticalGroup(
            personagem1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        personagem6.setBorder(null);

        javax.swing.GroupLayout personagem6Layout = new GroupLayout(personagem6);
        personagem6.setLayout(personagem6Layout);
        personagem6Layout.setHorizontalGroup(
            personagem6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
        personagem6Layout.setVerticalGroup(
            personagem6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        personagem3.setBorder(null);

        javax.swing.GroupLayout personagem3Layout = new GroupLayout(personagem3);
        personagem3.setLayout(personagem3Layout);
        personagem3Layout.setHorizontalGroup(
            personagem3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
        personagem3Layout.setVerticalGroup(
            personagem3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cenarioLayout = new GroupLayout(cenario);
        cenario.setLayout(cenarioLayout);
        cenarioLayout.setHorizontalGroup(
            cenarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cenarioLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(cenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personagem4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(personagem1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addGroup(cenarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(personagem5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(personagem2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addGroup(cenarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(personagem6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(personagem3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        cenarioLayout.setVerticalGroup(
            cenarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cenarioLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(cenarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(personagem6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personagem4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personagem5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addGroup(cenarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(personagem2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personagem1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personagem3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );

        imagemj1.setHorizontalAlignment(SwingConstants.CENTER);
        imagemj1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        imagemj2.setHorizontalAlignment(SwingConstants.CENTER);
        imagemj2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        placarj1.setFont(new Font("Ubuntu", 0, 24)); 
        placarj1.setHorizontalAlignment(SwingConstants.CENTER);
        placarj1.setText("0");

        placarj2.setFont(new Font("Ubuntu", 0, 24)); 
        placarj2.setHorizontalAlignment(SwingConstants.CENTER);
        placarj2.setText("0");

        nomej1.setFont(new Font("Ubuntu", 1, 15)); 
        nomej1.setText("nomeJogador");

        nomej2.setFont(new Font("Ubuntu", 1, 15)); 
        nomej2.setText("nomeJogador");

        jMenuBar1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setVerifyInputWhenFocusTarget(false);

        jMenu1.setText("JOGO");

        novaPartida.setText("Iniciar Nova Partida");
        jMenu1.add(novaPartida);

        conectar.setText("Conectar");
        jMenu1.add(conectar);

        desconectar.setText("Desconectar");
        jMenu1.add(desconectar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cenario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(nomej1))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(imagemj1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                        .addComponent(imagemj2, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(placarj1)
                            .addComponent(placarj2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(nomej2)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(nomej1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemj1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placarj1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(nomej2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemj2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placarj2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cenario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    
     public void exibirDialogoVoceVenceu() {
        JOptionPane.showMessageDialog(this, "PARABÊNS !!! Você venceu a partida!");
    }
     
     public void exibirDialogoVoceVenceuRound() {
        JOptionPane.showMessageDialog(this, "Você venceu o round!");
    }
     
     public void exibirDialogoVocePerdeu() {
        JOptionPane.showMessageDialog(this, "INFELIZMENTE você perdeu a partida");
    }
     
     public void exibirDialogoVocePerdeuRound() {
        JOptionPane.showMessageDialog(this, "Você perdeu o round!");
    }
    
   
}
