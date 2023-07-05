package Jogo;

import java.awt.Color;
import java.awt.Graphics;

abstract class Habilidades {
    int posicaoX;
    int posicaoY;
    int largura;
    int altura;

    Color cor;

    public Habilidades(Color cor, int largura, int altura) {
        this.cor = cor;
        this.largura = largura;
        this.altura = altura;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getWidth() {
        return largura;
    }

    public int getHeight() {
        return altura;
    }

    public abstract void desenhar(Graphics g);

    int getLargura() {
        return largura;
    }

    int getAltura() {
        return altura;
    }
}
