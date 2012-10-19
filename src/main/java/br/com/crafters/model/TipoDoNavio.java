package br.com.crafters.model;

public enum TipoDoNavio {

	AIRSHIPCARRIER(5), DESTROYER(4), CRUISER(3), SUBMARINE(3), PATROLBOAT(2);

	private int tamanhoDoNavio;

	private TipoDoNavio(int tamanhoDoNavio) {
		this.tamanhoDoNavio = tamanhoDoNavio;
	}

	public int getTamanhoDoNavio() {
		return tamanhoDoNavio;
	}
}
