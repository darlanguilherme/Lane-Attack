
package LaneAttack;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    protected AtorJogador atorJogador = AtorJogador.getInstance(this);
    protected boolean emRede = false;
    protected Controle ctrl = Controle.getInstance();
    
    private javax.swing.JLabel cenario;
    private javax.swing.JLabel imagemJ1;
    private javax.swing.JLabel imagemJ2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;

    
    public TelaPrincipal() {
        initComponents();
        
        setVisible(true);
    }
    
    private ActionListener btManager = event -> {
		if (event.getSource().equals(jMenuItem2)) {
			if (!atorJogador.iniciarPartida()){
				JOptionPane.showMessageDialog(TelaPrincipal.this, "É necessário estar conectado!", "Não conectado", JOptionPane.ERROR_MESSAGE);
			}
			if (atorJogador.aguardandoJogador()){
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Não existem jogadores suficientes no servidor, tente novamente.", "Aguarde", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (event.getSource().equals(jMenuItem3)) {
			if (atorJogador.conectar(solicitarNomeDoJogador())) {
				
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Conexão realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao conectar!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} else if (event.getSource().equals(jMenuItem4)) {
			AtorJogador.getInstance(this).desconectar();
		}
	};
    
    private String solicitarNomeDoJogador() {
		String nome = JOptionPane.showInputDialog(this, "Insira o nome do jogador", "Nome", JOptionPane.QUESTION_MESSAGE);
		if (nome == null || nome.isEmpty() || nome.equals(" ")) solicitarNomeDoJogador();
		System.out.println(nome);
		return nome;
	}

    
    
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        imagemJ1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imagemJ2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cenario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(970, 729));
        setMinimumSize(new java.awt.Dimension(970, 729));
        setSize(new java.awt.Dimension(970, 729));

        imagemJ1.setBackground(new java.awt.Color(204, 0, 51));
        imagemJ1.setForeground(new java.awt.Color(204, 0, 51));
        imagemJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenss/FeiticeiraRosto1.png"))); // NOI18N
        imagemJ1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");

        imagemJ2.setBackground(new java.awt.Color(204, 0, 51));
        imagemJ2.setForeground(new java.awt.Color(204, 0, 51));
        imagemJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenss/gokuRosto1.png"))); // NOI18N
        imagemJ2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        cenario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenss/Mapa.png"))); // NOI18N
        cenario.setBorder(new javax.swing.border.MatteBorder(null));

        jMenu1.setText("Jogo");

        jMenuItem2.setText("Iniciar Nova Partida");
        jMenuItem2.setToolTipText("");
        
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Conectar");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Desconectar");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        
        jMenuItem2.addActionListener(btManager);
	jMenuItem3.addActionListener(btManager);
	jMenuItem4.addActionListener(btManager);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cenario, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemJ1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagemJ2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cenario, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagemJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagemJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
                
                
        );
        setBackground(Color.blue);
        setResizable(false);
        pack();
    }


    void informarComposicao(Composicao composicao) {
        ctrl.setComposicao(composicao);
    }

    void informarInicioBatalha() {
        imagemJ1.setVisible(false);
//        ctrl.iniciarCombate();
    }
}
