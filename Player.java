package Jogo;

import java.awt.Color;
import java.awt.Graphics;

enum Direcao {
    CIMA, 
    BAIXO, 
    ESQUERDA, 
    DIREITA
}

class Player extends Entidades {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private final Color color;
    private final int velocity;
    private int lifeMax;
    private int lifeAtual;
    private Habilidades habilidades;
    private Direcao direcao;

    public Player(int x,
                  int y,
                  int width,
                  int height,
                  Color color,
                  int velocidade,
                  boolean par4,
                  int par5,
                  String jogador) {

        super(width, x, y, 0, false, 0, "");

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.velocity = velocidade;
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

    public int getVida() {
        return lifeMax;
    }

    public int getNovaVida() {
        return lifeAtual;
    }

    public void setVida(int lifeAtual) {
        lifeMax = lifeAtual;
    }


    
}
    