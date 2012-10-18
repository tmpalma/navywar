package br.com.crafters.controller;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.crafters.model.Jogador;

@Resource
public class JogoController {

	public static Map<Integer, Jogador> jogadores = new HashMap<Integer, Jogador>();
	
	private Jogador atacante;
	private Jogador atacado;

	public JogoController(Result result) {

	}

	public void atacar(String ataque) {
		executaOAtaque(ataque);
		inverteJogada();
	}

	private void executaOAtaque(String ataque) {
		// TODO Auto-generated method stub
	}

	private void inverteJogada() {
		// TODO Auto-generated method stub
	}

	@Path("/")
	public void index() {
	}

	public void jogar() {

	}

	public Jogador getAtacante() {
		return atacante;
	}

	public void setAtacante(Jogador atacante) {
		this.atacante = atacante;
	}

	public Jogador getAtacado() {
		return atacado;
	}

	public void setAtacado(Jogador atacado) {
		this.atacado = atacado;
	}
}
