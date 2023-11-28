public class ArvoreRubroNegra {
    private No raiz;
    private No nil;

    public ArvoreRubroNegra() {
        nil = new No(0, "preto");
        raiz = nil;
    }

    public void inserir(int chave) {
        No novoNo = new No(chave, "vermelho");
        inserirNo(raiz, novoNo);
        novoNo.cor = "preto";
    }

    private void inserirNo(No raiz, No novoNo) {
        No pai = nil;
        No atual = raiz;

        while (atual != nil) {
            pai = atual;
            if (novoNo.chave < atual.chave) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        novoNo.pai = pai;

        if (pai == nil) {
            this.raiz = novoNo;
        } else if (novoNo.chave < pai.chave) {
            pai.esquerda = novoNo;
        } else {
            pai.direita = novoNo;
        }

        if (pai != nil) {
            correcaoInsercao(novoNo);
        }
    }

    private void correcaoInsercao(No no) {
        while (no.pai.cor.equals("vermelho")) {
            if (no.pai == no.pai.pai.esquerda) {
                No tio = no.pai.pai.direita;
                if (tio.cor.equals("vermelho")) {
                    no.pai.cor = "preto";
                    tio.cor = "preto";
                    no.pai.pai.cor = "vermelho";
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = "preto";
                    no.pai.pai.cor = "vermelho";
                    rotacaoDireita(no.pai.pai);
                }
            } else {
                No tio = no.pai.pai.esquerda;
                if (tio.cor.equals("vermelho")) {
                    no.pai.cor = "preto";
                    tio.cor = "preto";
                    no.pai.pai.cor = "vermelho";
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = "preto";
                    no.pai.pai.cor = "vermelho";
                    rotacaoEsquerda(no.pai.pai);
                }
            }
        }

        this.raiz.cor = "preto";
    }

    private void rotacaoEsquerda(No x) {
        No y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != nil) {
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if (x.pai == nil) {
            this.raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(No y) {
        No x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != nil) {
            x.direita.pai = y;
        }
        x.pai = y.pai;
        if (y.pai == nil) {
            this.raiz = x;
        } else if (y == y.pai.esquerda) {
            y.pai.esquerda = x;
        } else {
            y.pai.direita = x;
        }
        x.direita = y;
        y.pai = x;
    }

    public No busca(int chave) {
        return buscaRecursiva(raiz, chave);
    }

    private No buscaRecursiva(No no, int chave) {
        if (no == nil || chave == no.chave) {
            return no;
        }
        if (chave < no.chave) {
            return buscaRecursiva(no.esquerda, chave);
        }
        return buscaRecursiva(no.direita, chave);
    }
}
