public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();
        int[] chaves = {7, 3, 18, 10, 22, 8, 11, 26};
        for (int chave : chaves) {
            arvore.inserir(chave);
        }
        // Buscar um valor
        int valor = 11;
        No resultado = arvore.busca(valor);
        if (resultado != arvore.nil) {
            System.out.println("Valor " + valor + " encontrado na árvore.");
        } else {
            System.out.println("Valor " + valor + " não encontrado na árvore.");
        }
    }
}
