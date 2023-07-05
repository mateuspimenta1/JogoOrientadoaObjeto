package Jogo;

public abstract class Entidades {
    protected int tamanho;
    protected int posicaoInicialX;
    protected int posicaoInicialY;
    protected int velocidade;
    protected int life;
    protected String forma;

    public Entidades(int tamanho,
                     int posicaoInicialX,
                     int posicaoInicialY,
                     int velocidade,
                     boolean colisao,
                     int life,
                     String forma) {

        this.tamanho = tamanho;
        this.posicaoInicialX = posicaoInicialX;
        this.posicaoInicialY = posicaoInicialY;
        this.velocidade = velocidade;
        this.life = life;
        this.forma = forma;
    }

    // Métodos getters e setters para os atributos

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getPosicaoInicialX() {
        return posicaoInicialX;
    }

    public void setPosicaoInicialX(int posicaoInicialX) {
        this.posicaoInicialX = posicaoInicialX;
    }

    public int getPosicaoInicialY() {
        return posicaoInicialY;
    }

    public void setPosicaoInicialY(int posicaoInicialY) {
        this.posicaoInicialY = posicaoInicialY;
    }

    public int getVelocity() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
}
