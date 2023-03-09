package Lista;

public class ListaCircular {
    private No primeiro;
    private No ref; //ultimo No da lista
    private int tamanho;


    public No getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }
    public No getRef() {
        return ref;
    }
    public void setRef(No ref) {
        this.ref = ref;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void InsereOdernado(int novoValor) {
        No novoNo = new No(novoValor);
        if (this.primeiro == null && this.ref == null) { //Adicionar quando a lista está vazia
            this.primeiro = novoNo;
            this.ref = novoNo;
            this.ref.setProximo(novoNo);
            tamanho++;
        } else if (novoNo.getValor() < this.primeiro.getValor()) { //Verifica se o novoNo é menor que o primeiro No
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
            ref.setProximo(primeiro);
            tamanho++;
        } else if (novoNo.getValor() > this.ref.getValor()) { //verifica se o novoNo é maior que o ultimo No da lista
            novoNo.setProximo(primeiro);
            ref.setProximo(novoNo);
            ref = novoNo;
            tamanho++;
        } else if (novoNo.getValor() > primeiro.getValor() && novoNo.getValor() < ref.getValor()) { // aqui adiciona no meio da lista e verifica se o novoNo é igual a um que já está na lista, se for ele remove os dois, se não ele adiciona
            No anterior = null;
            No atual = primeiro;
            while (atual != ref) {
                anterior = atual;
                atual = atual.getProximo();
                if (novoValor == atual.getValor()) {
                    anterior.setProximo(atual.getProximo());
                    tamanho--;
                    break;
                } else if (novoValor > anterior.getValor() && novoValor < atual.getValor()) {
                    novoNo.setProximo(atual);
                    anterior.setProximo(novoNo);
                    tamanho++;
                    break;
                }
            }
        }
    }
    public void imprime(int posicao) {
	        if (posicao < 0 || posicao >= tamanho) {
	            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
	        }
	        No atual = primeiro;
	        for (int i = 0; i < posicao; i++) {
	            atual = atual.getProximo();
	        }
	        System.out.println(atual.getValor());
    } 
    public void remover(int valorProcurado) {
        if (this.listaVazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        if(valorProcurado > this.tamanho){
        	System.out.println("Impossivel remover um valor que não existe");
        }
        No anterior = null;
        No atual = this.primeiro;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getValor() == valorProcurado) {
                if (this.tamanho == 1) { //caso so tenha um elemento na lista
                    this.primeiro = null;
                    this.ref = null;
                    tamanho--;
                    break;
                } else if (atual == primeiro) {
                    this.ref.setProximo(atual.getProximo());
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);
                } else if (atual == ref) {
                    anterior.setProximo(primeiro);
                    this.ref = anterior;
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual.setProximo(null);
                }
                tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }
    public boolean listaVazia() {
    	if(this.tamanho < 0) {
    		return true;
    	}
    	return false;
    }
}
