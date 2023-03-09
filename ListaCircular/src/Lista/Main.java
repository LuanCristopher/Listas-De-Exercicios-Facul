package Lista;

public class Main {

	public static void main(String[] args) {
		ListaCircular lista = new ListaCircular();
		System.out.println("1° teste, adicionando valores desordenados:");
		lista.InsereOdernado(3);
		lista.InsereOdernado(4);
		lista.InsereOdernado(1);
		lista.InsereOdernado(2);
		
		System.out.println("foi adicionado os valores desordenados assim: 3;4;1;2 agora vou fazer um for para mostrar a lista:");
		for(int i=0;i<lista.getTamanho();i++) {
			lista.imprime(i);
		}
		System.out.println("Agora eu vou remover todos os itens da lista e vou retornar o tammanho dela em seguida: ");
		System.out.println("Tamanho da lista pré remoção: " +lista.getTamanho());
		
		while (lista.getTamanho() > 0) {
		    lista.remover(lista.getPrimeiro().getValor());
		}
		System.out.println("Tamanho da lista pós remoção: "+lista.getTamanho());
		
		System.out.println("Vou voltar a adicionar itens da lista, será colocado em ordem descente assim: 6;5;4;3;2;1");
		int x = 6;
		for(int i = 0; i < 6; i++) {
			lista.InsereOdernado(x-i);
		}
		
		System.out.println("Vou imprimir novamente a lista: ");
		for(int i=0;i<lista.getTamanho();i++) {
			lista.imprime(i);
		}
		
		System.out.println("Agora vou tentar remover um item que não existe na lista: ");
		lista.remover(10);
		
	}
	

}
