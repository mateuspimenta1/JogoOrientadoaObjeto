    package Jogo;

    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.event.ComponentAdapter;
    import java.awt.event.ComponentEvent;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import javax.imageio.ImageIO;
    import javax.swing.JPanel;


class Janela extends JPanel implements KeyListener, Runnable {
    private static final int LARGURA_INICIAL_JANELA = 800;
    private static final int ALTURA_INICIAL_JANELA = 600;
    private static final int VELOCIDADE = 5;
    private static final double DESACELERACAO = 0.5;

    private final Player jogador;
    private final Enemy inimigo;
    private final List<Projectile> projeteis;
    private RotationMagic rotationMagic;
    private boolean rotationMagicAtivo = false;
    private BoomerangMagic boomerangMagic;
    private boolean boomerangMagicAtivo = false;

    private BufferedImage backgroundImage;

    private boolean esquerdaPressionada;
    private boolean direitaPressionada;
    private boolean cimaPressionada;
    private boolean baixoPressionada;
    
    
    
        public Janela() {
            jogador = new Player(0, 0, 25, 25, Color.BLUE, VELOCIDADE, true, 100, "Jogador");
            inimigo = new Enemy(0, 0, 25, 25, Color.RED, VELOCIDADE, true, 100, "Inimigo");
            projeteis = new ArrayList<>();
            rotationMagic = new RotationMagic(Color.RED, 10, 10, jogador);
            boomerangMagic = new BoomerangMagic(Color.RED, 10, 10, jogador);

            try {
                backgroundImage = ImageIO.read(new File("C:\\Users\\Koyott\\Documents\\NetBeansProjects\\Tentativa4\\src\\Jogo\\Map001.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            setPreferredSize(new Dimension(LARGURA_INICIAL_JANELA, ALTURA_INICIAL_JANELA));
            setBackground(Color.WHITE);
            setFocusable(true);
            addKeyListener(this);

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    redimensionarJanela();
                }
            });
        }
        
        
        
        
        
        
        
        

        
        
        
        
        
        
    

        @Override
        public void keyPressed(KeyEvent e) {
            atualizarEstadoMovimento(e, true);

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                List<Projectile> proj = Projectile.criarProjeteis(jogador);
                projeteis.addAll(proj);
            }

            if (e.getKeyCode() == KeyEvent.VK_R && !rotationMagicAtivo) {
                rotationMagicAtivo = true;
                rotationMagic = new RotationMagic(Color.RED, 10, 10, jogador);
                rotationMagic.setAngulo(0); // Reset the angle when the rotation magic is activated
            }
            if (e.getKeyCode() == KeyEvent.VK_E && !boomerangMagicAtivo) {
                boomerangMagicAtivo = true;
                boomerangMagic = new BoomerangMagic(Color.RED, 10, 10, jogador);
                boomerangMagic.setAngulo(0); // Reset the angle when the rotation magic is activated

               
            }

        }




        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            atualizarEstadoMovimento(e, false);


        }


        private void atualizarEstadoMovimento(KeyEvent e, boolean pressionada) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT) {
                esquerdaPressionada = pressionada;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                direitaPressionada = pressionada;
            }
            if (keyCode == KeyEvent.VK_UP) {
                cimaPressionada = pressionada;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                baixoPressionada = pressionada;
            }
        }

        private void moverJogador() {
            int deltaX = 0;
            int deltaY = 0;

            if (esquerdaPressionada) {
                deltaX -= VELOCIDADE;
            }
            if (direitaPressionada) {
                deltaX += VELOCIDADE;
            }
            if (cimaPressionada) {
                deltaY -= VELOCIDADE;
            }
            if (baixoPressionada) {
                deltaY += VELOCIDADE;
            }

            int novaPosicaoX = jogador.getPosicaoX() + deltaX;
            int novaPosicaoY = jogador.getPosicaoY() + deltaY;

            int larguraJanela = getWidth();
            int alturaJanela = getHeight();

            // Verifica se a nova posição está dentro dos limites da janela
            if (novaPosicaoX >= 0 && novaPosicaoX <= larguraJanela - jogador.getWidth()) {
                jogador.setPosicaoX(novaPosicaoX);
            }
            if (novaPosicaoY >= 0 && novaPosicaoY <= alturaJanela - jogador.getHeight()) {
                jogador.setPosicaoY(novaPosicaoY);
            }
        }





        private void moverInimigo() {
            int jogadorX = jogador.getPosicaoX();
            int jogadorY = jogador.getPosicaoY();
            int inimigoX = inimigo.getPosicaoX();
            int inimigoY = inimigo.getPosicaoY();

            // Calcula a distância entre o jogador e o inimigo
            int distanciaX = jogadorX - inimigoX;
            int distanciaY = jogadorY - inimigoY;

            // Normaliza a distância para obter a direção do movimento
            double distanciaTotal = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
            double direcaoX = distanciaX / distanciaTotal;
            double direcaoY = distanciaY / distanciaTotal;

            // Move o inimigo em direção ao jogador com base na direção normalizada
            int novaPosicaoX = inimigoX + (int) (VELOCIDADE * direcaoX);
            int novaPosicaoY = inimigoY + (int) (VELOCIDADE * direcaoY);

            int larguraJanela = getWidth();
            int alturaJanela = getHeight();

            // Verifica se a nova posição está dentro dos limites da janela
            if (novaPosicaoX >= 0 && novaPosicaoX <= larguraJanela - inimigo.getWidth()) {
                inimigo.setPosicaoX(novaPosicaoX);
            } else {
                // Redefine a posição do inimigo para evitar que saia da janela
                if (novaPosicaoX < 0) {
                    inimigo.setPosicaoX(0);
                } else {
                    inimigo.setPosicaoX(larguraJanela - inimigo.getWidth());
                }
            }

            if (novaPosicaoY >= 0 && novaPosicaoY <= alturaJanela - inimigo.getHeight()) {
                inimigo.setPosicaoY(novaPosicaoY);
            } else {
                // Redefine a posição do inimigo para evitar que saia da janela
                if (novaPosicaoY < 0) {
                    inimigo.setPosicaoY(0);
                } else {
                    inimigo.setPosicaoY(alturaJanela - inimigo.getHeight());
                }
            }
        }

        private boolean verificarColisao() {
            int jogadorX = jogador.getPosicaoX();
            int jogadorY = jogador.getPosicaoY();
            int jogadorLargura = jogador.getWidth();
            int jogadorAltura = jogador.getHeight();

            int inimigoX = inimigo.getPosicaoX();
            int inimigoY = inimigo.getPosicaoY();
            int inimigoLargura = inimigo.getWidth();
            int inimigoAltura = inimigo.getHeight();

            // Verifica se há sobreposição entre os retângulos delimitadores do jogador e do inimigo
            if (jogadorX < inimigoX + inimigoLargura &&
                    jogadorX + jogadorLargura > inimigoX &&
                    jogadorY < inimigoY + inimigoAltura &&
                    jogadorY + jogadorAltura > inimigoY) {
                // Colisão detectada
                int vidaAnterior = jogador.getVida();
                jogador.setVida(jogador.getVida() - 10);
                int novaVida = jogador.getVida();
                System.out.println("Vida anterior: " + vidaAnterior);
                System.out.println("Nova vida: " + novaVida);

                


                // Resto do código...

                return true; // Retorna true indicando colisão
            }

            return false; // Retorna false indicando ausência de colisão
        }








        private void moverRotationMagic() {
            if (rotationMagicAtivo) {
                int jogadorX = jogador.getPosicaoX();
                int jogadorY = jogador.getPosicaoY();
                int jogadorLargura = jogador.getWidth();
                int jogadorAltura = jogador.getHeight();

                int raio = 50; // Raio da circunferência
                int centroX = jogadorX + jogadorLargura / 2; // Coordenada X do centro da circunferência
                int centroY = jogadorY + jogadorAltura / 2; // Coordenada Y do centro da circunferência

                rotationMagic.setPosicaoX(centroX - raio); // Define a posição X da RotationMagic
                rotationMagic.setPosicaoY(centroY - raio); // Define a posição Y da RotationMagic

                rotationMagic.setAngulo(rotationMagic.getAngulo() + 1); // Incrementa o ângulo de rotação

                repaint();
            }
        }

        
        private void moverBoomerang() {
            boomerangMagic.girar();
            boomerangMagic.expandirRetrair();

            repaint();
        }




        private void moverProjeteis() {
            Iterator<Projectile> iterator = projeteis.iterator();
            while (iterator.hasNext()) {
                Projectile proj = iterator.next();
                proj.move();

                if (proj.isForaDosLimitesDaJanela(getWidth(), getHeight())) {
                    iterator.remove(); // Remova o projétil usando o Iterator
                }
            }
           
        }





        private void processarColisao() {
            if (verificarColisao()) {
                int vidaAnterior = jogador.getVida();
                jogador.setVida(jogador.getVida() - 10);
                int novaVida = jogador.getVida();
                System.out.println("Vida anterior: " + vidaAnterior);
                System.out.println("Nova vida: " + novaVida);
            }
        }
        
        
        private BufferedImage carregarImagem(String caminho) {
            try {
                return ImageIO.read(new File(caminho));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.drawImage(backgroundImage, 0, 0, null);
            
            
            rotationMagic.desenhar(g);

            // Desenhar o jogador
            jogador.desenhar(g);

            // Desenhar o inimigo
            inimigo.desenhar(g);

            // Desenhar os projéteis
            for (Projectile proj : projeteis) {
                proj.desenhar(g);
            }

            
                boomerangMagic.desenhar(g);
            
        }

    // ...

        @Override
        public void run() {
            while (true) {
                moverJogador();
                moverInimigo();
                moverProjeteis();
                moverBoomerang();
                processarColisao();
                moverRotationMagic(); // Adicione essa linha
                repaint();

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Atualiza a posição e tamanho dos objetos     com base no tamanho da janela
        private void redimensionarJanela() {
            int larguraJanela = getWidth();
            int alturaJanela = getHeight();

            // Posiciona o jogador na parte esquerda da tela, centralizado verticalmente
            int jogadorX = 0;
            int jogadorY = (alturaJanela - jogador.getHeight()) / 2;
            jogador.setPosicaoX(jogadorX);
            jogador.setPosicaoY(jogadorY);

            // Posiciona o inimigo na parte direita da tela, centralizado verticalmente
            int inimigoX = larguraJanela - inimigo.getWidth();
            int inimigoY = (alturaJanela - inimigo.getHeight()) / 2;
            inimigo.setPosicaoX(inimigoX);
            inimigo.setPosicaoY(inimigoY);
        }
    }
    