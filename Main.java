package Jogo;



import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo");
        Janela janela = new Janela();
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(janela);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Thread threadJanela = new Thread(janela);
        threadJanela.start();
        janela.repaint();
    }
}