package Lista;

public class No {
	private int valor;
	private No proximo;
	
	public No(int novoValor) {
		this.valor = novoValor;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
}
