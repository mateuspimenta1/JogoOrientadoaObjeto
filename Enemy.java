package Jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class Enemy extends Entidades {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private final Color color;
    private int velocidade;

    public Enemy(int x,
                 int y,
                 int width,
                 int height,
                 Color color,
                 int velocidade,
                 boolean par4,
                 int par5,
                 String jogador) {

        super(width,
              x,
              y,
              0,
              false,
              0,
              "");
        // Chama o construtor da classe pai (Entidades)

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.velocidade = velocidade;
    }

    public void desenhar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    

    public void setPosicaoX(int x) {
        this.x = x;
    }

    public void setPosicaoY(int y) {
        this.y = y;
    }

    public int getPosicaoX() {
        return x;
    }

    public int getPosicaoY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}
