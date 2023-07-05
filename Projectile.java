package Jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Projectile extends Habilidades {
    private final double direcao; // Direção em radianos
    private static final int VELOCIDADE = 10;

    public Projectile(int x, int y, int largura, int altura, Color cor, double direcao, int VELOCIDADE1) {
        super(cor, largura, altura);
        this.posicaoX = x;
        this.posicaoY = y;
        this.direcao = direcao;
    }

    public void move() {
        double velocidade = 15;
        // Atualize as coordenadas X e Y com base na direção
        posicaoX += (int) (Math.cos(direcao) * velocidade);
        posicaoY += (int) (Math.sin(direcao) * velocidade);
    }

    public boolean isForaDosLimitesDaJanela(int larguraJanela, int alturaJanela) {
        return posicaoY + getHeight() < 0 || posicaoY > alturaJanela;
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(posicaoX, posicaoY, getLargura(), getAltura());
    }

    public static List<Projectile> criarProjeteis(Player jogador) {
        List<Projectile> projeteis = new ArrayList<>();

        int playerX = jogador.getPosicaoX() + jogador.getWidth() / 2;
        int playerY = jogador.getPosicaoY() + jogador.getHeight() / 2;
        int raio = 5; // Raio do formato do raio solar
        int projectileWidth = 10;
        int projectileHeight = 10;
        double anguloInicial = Math.toRadians(-90);
        double anguloTotal = Math.toRadians(360);
        double anguloEntreRaios = anguloTotal / 12;

        for (int i = 0; i < 12; i++) {
            double angulo = anguloInicial + anguloEntreRaios * i;
            double direcao = angulo * -1;
            int projectileX = playerX + (int) (raio * Math.cos(angulo));
            int projectileY = playerY - (int) (raio * Math.sin(angulo));

            Projectile proj = new Projectile(projectileX, projectileY, projectileWidth, projectileHeight, Color.GREEN, direcao, VELOCIDADE);
            projeteis.add(proj);
        }

        return projeteis;
    }
}
