package Jogo;

import java.awt.Color;
import java.awt.Graphics;

class Buff extends Habilidades {
    private int radius;
    private int habilidadeWidth;
    private int habilidadeHeight;
    private Buff habilidades; // Define habilidades field

    public Buff(Color cor, int largura, int altura, int habilidadeWidth, int habilidadeHeight) {
        super(cor, largura, altura);
        this.radius = Math.min(largura, altura) / 4;
        this.habilidadeWidth = habilidadeWidth;
        this.habilidadeHeight = habilidadeHeight;
    }

    @Override
    public void desenhar(Graphics g) {
        int centerX = posicaoX + largura / 2;
        int centerY = posicaoY + altura / 2;

        int circleX = centerX - habilidadeWidth / 2;
        int circleY = centerY - habilidadeHeight / 2;

        g.setColor(Color.GREEN);
        g.fillOval(circleX, circleY, habilidadeWidth, habilidadeHeight);
    }

    public void mover(int deltaX, int deltaY) {
        int velocidadeX = deltaX * getVelocity();
        int velocidadeY = deltaY * getVelocity();
        int x = 0;

        x += velocidadeX;
        int y = 0;
        y += velocidadeY;

        if (habilidades != null) {
            habilidades.setPosicaoX(x);
            habilidades.setPosicaoY(y);
        }
    }

    public void usarHabilidade(Graphics g, int deltaX, int deltaY) {
        if (habilidades == null) {
            habilidades = new Buff(
                Color.GREEN,
                habilidadeWidth,
                habilidadeHeight,
                10,
                10
            );
            habilidades.setPosicaoX(posicaoX);
            habilidades.setPosicaoY(posicaoY);
        }

        // Desenhar o buff e atualizar sua posição
        habilidades.desenhar(g);
        habilidades.mover(deltaX, deltaY);
    }

    private int getVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
