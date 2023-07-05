package Jogo;

import java.awt.Color;
import java.awt.Graphics;

public class BoomerangMagic extends Habilidades {
    private final Player jogador;
    private double angulo;
    private int raio;
    private boolean expandindo;

    public BoomerangMagic(Color cor, int largura, int altura, Player jogador) {
        super(cor, largura, altura);
        angulo = 0;
        raio = 300;
        expandindo = true;
        this.jogador = jogador;
    }

    @Override
    public void desenhar(Graphics g) {
        int centroX = jogador.getPosicaoX() + jogador.getWidth() / 2;
        int centroY = jogador.getPosicaoY() + jogador.getHeight() / 2;

        int habilidadeCentroX = centroX - getLargura() / 2;
        int habilidadeCentroY = centroY - getAltura() / 2;

        for (int i = 0; i < 9; i++) {
            double radianos = Math.toRadians(angulo + i * 40);
            int x = (int) (habilidadeCentroX + raio * Math.cos(radianos));
            int y = (int) (habilidadeCentroY + raio * Math.sin(radianos));

            g.setColor(getColor());
            g.fillRect(x, y, getLargura(), getAltura());
        }
    }

    private Color getColor() {
        int red = 155;
        int green = 155;
        int blue = 155;
        return new Color(red, green, blue);
    }
    
    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public void girar() {
        angulo += 2;
    }

    public void expandirRetrair() {
        if (expandindo) {
            raio += 2;
            if (raio >= 300) {
                expandindo = false;
            }
        } else {
            raio -= 0.0000000000001;
            if (raio <= 50) {
                expandindo = true;
            }
        }
    }
}
