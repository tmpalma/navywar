package br.com.crafters.functional;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.crafters.controller.IndexController;
import br.com.crafters.model.Ataque;
import br.com.crafters.model.Jogador;

public class IndexControllerTest {

	private Jogador jogador1;
	private Jogador jogador2;

	@Before
	public void setUp() {
		jogador1 = new Jogador();
		jogador1.setId(1);
		jogador1.setNome("j1");
		IndexController.jogadores.put(jogador1.getId(), jogador1);

		jogador2 = new Jogador();
		jogador2.setId(2);
		jogador2.setNome("j2");
		IndexController.jogadores.put(jogador2.getId(), jogador2);
	}

	@Test
	public void realizaAtaque() {
		MockResult result = new MockResult();
		IndexController controller = new IndexController(result);

		controller.iniciarPartida(jogador1);

		Ataque ataque = new Ataque();
		ataque.atacado = jogador2;
		ataque.linha = 2;
		ataque.coluna = 'C';
		ataque.sucesso = false;

		Assert.assertEquals(controller.getJogadorDaVez().getId(), 1);

		controller.atacar(ataque);
		
		Assert.assertEquals(ataque.sucesso, true);
	}
}
