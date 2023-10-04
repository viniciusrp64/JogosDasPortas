import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JogoDasPortas extends JFrame implements ActionListener {
    private JButton porta1, porta2, porta3;
    private int portaComPremio;
    public JogoDasPortas() {
        // Configuração da janela principal
        setTitle("Jogo das Portas");
        this.setLocationRelativeTo(null); // Centralizar janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        // Cria um painel com layout de grade (uma linha e três colunas)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        // Cria os botões representando as portas
        porta1 = new JButton("Porta 1");
        porta2 = new JButton("Porta 2");
        porta3 = new JButton("Porta 3");
        // Adiciona um ouvinte de ação aos botões
        porta1.addActionListener(this);
        porta2.addActionListener(this);
        porta3.addActionListener(this);
        // Adiciona os botões ao painel
        panel.add(porta1);
        panel.add(porta2);
        panel.add(porta3);
        // Adiciona o painel à janela principal
        add(panel);
        // Escolhe aleatoriamente qual porta contém o prêmio (1, 2 ou 3)
        portaComPremio = (int) (Math.random() * 3) + 1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Captura o botão que foi clicado
        JButton escolhaUsuario = (JButton) e.getSource();
        // Extrai o número da porta a partir do texto do botão
        int portaEscolhida = Integer.parseInt(escolhaUsuario.getText().substring(6));
        // Pede uma confirmação ao usuário
        int confirmacao = JOptionPane.showConfirmDialog(this, "Você escolheu a Porta " + portaEscolhida + ". Tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (portaEscolhida == portaComPremio) {
                // Exibe mensagem de vitória se o usuário escolheu a porta correta
                JOptionPane.showMessageDialog(this, "Parabéns! Você ganhou o prêmio!");
            } else {
                // Exibe mensagem informando que o prêmio estava em outra porta
                JOptionPane.showMessageDialog(this, "Você escolheu a Porta " + portaEscolhida + ". A Porta " + portaComPremio + " tinha o prêmio.");
            }
            System.exit(0); // Encerra o programa
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoDasPortas jogo = new JogoDasPortas();
            jogo.setVisible(true);
        });
    }
}