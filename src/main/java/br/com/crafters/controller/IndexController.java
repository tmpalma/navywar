package br.com.crafters.controller;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.crafters.model.Ataque;
import br.com.crafters.model.Jogador;

@Resource
public class IndexController {

	public static Map<Integer, Jogador> jogadores = new HashMap<Integer, Jogador>();

	private Jogador jogadorDaVez;

	public IndexController(Result result) {

	}

	public void iniciarPartida(Jogador jogadorDaVez) {
		this.setJogadorDaVez(jogadorDaVez);
	}

	public void atacar(Ataque ataque) {
		executaOAtaque(ataque);
		verificaFinalizacaoDaPartida();

		setJogadorDaVez(ataque.atacado);
	}

	private void executaOAtaque(Ataque ataque) {
		// valida se o ataque pode ser realizado L X C
		
		// Checar o tabuleiro do atacado

		// Caso o alvo seja acertado
		ataque.sucesso = true;
	}

	private void verificaFinalizacaoDaPartida() {
		// TODO Auto-generated method stub
	}

	@Path("/")
	public void index() {
	}

	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void setJogadorDaVez(Jogador jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}
}