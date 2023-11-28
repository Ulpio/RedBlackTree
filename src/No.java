public class No {
    int chave;
    String cor;
    No esquerda, direita, pai;

    public No(int chave, String cor) {
        this.chave = chave;
        this.cor = cor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
