package br.com.crafters.model;

public class Tabuleiro {

	private int[][] mapa = new int[6][6];

	public void adicionaNavio(TipoDoNavio tipoDoNavio, int linha, char coluna,
			Orientacao orientacao) {
		int tamanho = tipoDoNavio.getTamanhoDoNavio();

		for (int i = 0; i < tamanho; i++) {

		}

		mapa[converteLinha(linha)][converteColuna(coluna)] = 1;
	}

	public boolean temNavioNaPosicao(int linha, char coluna) {
		if (mapa[converteLinha(linha)][converteColuna(coluna)] == 1) {
			return true;
		}

		return false;
	}

	private int converteLinha(int linha) {
		return linha - 1;
	}

	private int converteColuna(char coluna) {
		return ((int) coluna) - 65;
	}
}