package br.com.crafters.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.crafters.model.Ataque;
import br.com.crafters.model.Jogador;
import br.com.crafters.model.Tabuleiro;

@Resource
public class IndexController {

	public static Map<Integer, Jogador> jogadores = new HashMap<Integer, Jogador>();

	private Jogador jogadorDaVez;

	public IndexController(Result result) {

	}

	public void iniciarPartida(Jogador jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}

	public void ataca(Ataque ataque) {
		try {
			executaOAtaque(ataque);
		} catch (Exception e) {
			e.printStackTrace();
		}

		verificaFinalizacaoDaPartida();

		this.jogadorDaVez = ataque.atacado;
	}

	private void executaOAtaque(Ataque ataque) throws Exception {
		verificaSeAtaquePodeSerRealizado(ataque.linha, ataque.coluna);

		executaAtaqueNoOpenente(ataque);
	}

	private void verificaSeAtaquePodeSerRealizado(int linha, char coluna)
			throws Exception {
		List<Integer> linhas = Arrays.asList(1, 2, 3, 4, 5, 6);

		if (!linhas.contains(linha)) {
			throw new Exception("A coordenada Y (linha) não é válida");
		}

		List<Character> colunas = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');

		if (!colunas.contains(coluna)) {
			throw new Exception("A coordenada X (coluna) não é válida");
		}
	}

	private void executaAtaqueNoOpenente(Ataque ataque) {
		Tabuleiro tabuleiro = ataque.atacado.getTabuleiro();

		if (tabuleiro.temNavioNaPosicao(ataque.linha, ataque.coluna)) {
			ataque.sucesso = true;
		} else {
			ataque.sucesso = false;
		}
	}

	private void verificaFinalizacaoDaPartida() {
		// TODO Auto-generated method stub
	}

	@Path("/navy/index.jsp")
	@Post
	public void addShip() {
		System.out.println("addShip");
	}

	@Path("/")
	// @Post
	public void index(String linha, String coluna, List<String> tabuleiro) {
		System.out.println(linha);
		System.out.println(coluna);

		int tamanho = 2;
		String orientacao = "H";

		if ((linha != null) && (coluna != null)) {
			int linhaInicio = Integer.parseInt(linha);
			int colunaInicio = Integer.parseInt(coluna);
			int linhaFim = linhaInicio;
			int colunaFim = colunaInicio;

			List<String> lstTabuleiro = new ArrayList<String>();
			String indiceCheck;
			if (orientacao.equals("H")) {
				linhaFim = linhaFim + tamanho;
				for (int i = linhaInicio; i < linhaFim; i++) {
					indiceCheck = i + "x" + colunaFim;
					System.out.println(indiceCheck);
					lstTabuleiro.add(indiceCheck);
				}
			} else if (orientacao.equals("V")) {
				colunaFim = colunaFim + tamanho;
			}

			tabuleiro = lstTabuleiro;
			System.out.println(tabuleiro);
		}
	}

	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void setJogadorDaVez(Jogador jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}
}