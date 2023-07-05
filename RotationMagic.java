package Jogo;

import java.awt.Color;
import java.awt.Graphics;

class RotationMagic extends Habilidades {
    private double angulo;
    private final Player jogador; // Player object field
    private double velocidade;
    

    public RotationMagic(Color cor, int largura, int altura, Player jogador) {
        super(cor, largura, altura);
        angulo = 0;
        this.jogador = jogador;
        velocidade = 2.5;
    }

    @Override
    public void desenhar(Graphics g) {
        int raio = 35;
        int centroX = jogador.getPosicaoX() + jogador.getWidth() / 2;
        int centroY = jogador.getPosicaoY() + jogador.getHeight() / 2;

        int habilidadeCentroX = centroX - getLargura() / 2;
        int habilidadeCentroY = centroY - getAltura() / 2;

        for (int i = 0; i < 12; i++) {
            double radianos = Math.toRadians(angulo + i * 30);
            int x = (int) (habilidadeCentroX + raio * Math.cos(radianos));
            int y = (int) (habilidadeCentroY + raio * Math.sin(radianos));

            g.setColor(getColor());
            g.fillOval(x, y, getLargura(), getAltura());
        }

        angulo += velocidade; // Atualiza o ângulo de acordo com a velocidade
    }


    private Color getColor() {
        return Color.RED;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

   
}
