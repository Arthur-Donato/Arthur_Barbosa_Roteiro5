package tad.conjuntoDinamico;

import tad.ElementoNaoEncontradoException;
import tad.listasEncadeadas.ListaEncadeadaImpl;
import tad.listasEncadeadas.ListaVaziaException;

/** Roteiro 05 - TADs
 * @author Arthur Barbosa Donato
 * Caracterização do roteiro: Implementar uma conjunto dinamico utilzando de uma lista encadeada.
 * Objetivo da classe: Fornecer um conjunto dinamico usando lista encadeada.
 * */
public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {
	private ListaEncadeadaImpl<Integer> conjuntoEncadeado = null;

	public MeuConjuntoDinamicoEncadeado(){
		this.conjuntoEncadeado = new ListaEncadeadaImpl<>();
	}
	/** Esse método adiciona o elemento que foi passado como paramtro dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser adicionado no conjunto.
	 * */
	@Override
	public void inserir(Integer item) {
		this.conjuntoEncadeado.insert(item);
		
	}

	/** Esse método remove um elemento do conjunto dinamico, caso esse elemento exista dentro do conjunto.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser removido do conjunto.
	 * @return Integer numeroRemovido - Elemento removido do conjunto dinamico.
	 * */
	@Override
	public Integer remover(Integer item) {
		try{
			return this.conjuntoEncadeado.remove(item).getChave();
		}catch(ListaVaziaException  | ElementoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	/** Esse método verifica o predecessor do elemento que foi passado como parametro.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando o predecessor.
	 * @return Integer sucessor - Elemento predecessor do elemento que foi passado como parametro.
	 * */
	@Override
	public Integer predecessor(Integer item) {
		try{
			return this.conjuntoEncadeado.predecessor(item).getChave();
		}catch(ElementoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	/** Esse método verifica o sucessor do elemento que foi passado como parametro.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando o sucessor.
	 * @return Integer sucessor - Elemento sucessor do elemento que foi passado como parametro.
	 * */
	@Override
	public Integer sucessor(Integer item){
		try{
			return this.conjuntoEncadeado.sucessor(item).getChave();
		} catch(ElementoNaoEncontradoException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	/** Esse método faz a verificação do tamanho atual do conjunto dinamico, ou seja, quantos elementos ele possui diferentes de nulo.
	 * @author Arthur Barbosa Donato
	 * @return int tamanho - Número que representa o tamanho atual do conjunto dinamico.
	 * */
	@Override
	public int tamanho() {
		return this.conjuntoEncadeado.size();
	}

	/** Esse método busca um elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando dentro do conjunto dinamico.
	 * @return Integer numeroProcurado - Número que estava a ser procurado no conjunto.
	 * */
	@Override
	public Integer buscar(Integer item) {
		if(this.conjuntoEncadeado.isEmpty()){
			return null;
		}
		return this.conjuntoEncadeado.search(item).getChave();
	}

	/** Esse método verifica o menor elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @return Integer menorElemento - Menor número dentro do conjunto.
	 * */
	@Override
	public Integer minimum() {
		Integer[] arrayDosElementos = this.conjuntoEncadeado.toArray(Integer.class);

		Integer menorNumero = arrayDosElementos[0];

		for(int i = 0; i < arrayDosElementos.length; i++){
			if(arrayDosElementos[i] <= menorNumero){
				menorNumero = arrayDosElementos[i];
			}
		}

		return menorNumero;
	}

	/** Esse método verifica o maior elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @return Integer maiorElemento - Maior número dentro do conjunto.
	 * */
	@Override
	public Integer maximum() {
		Integer[] arrayDosElementos = this.conjuntoEncadeado.toArray(Integer.class);
		Integer maiorNumero = arrayDosElementos[0];

		for(int i = 0; i < arrayDosElementos.length; i++){
			if(arrayDosElementos[i] >= maiorNumero){
				maiorNumero = arrayDosElementos[i];
			}
		}

		return maiorNumero;
	}

}
