package br.com.crafters.functional;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.crafters.controller.JogoController;
import br.com.crafters.model.Jogador;

public class JogoControllerTest {

	private Jogador jogador1;
	private Jogador jogador2;

	@Before
	public void setUp() {
		jogador1 = new Jogador();
		jogador1.setId(1);
		jogador1.setNome("j1");
		JogoController.jogadores.put(jogador1.getId(), jogador1);

		jogador2 = new Jogador();
		jogador2.setId(2);
		jogador2.setNome("j2");
		JogoController.jogadores.put(jogador2.getId(), jogador2);
	}

	@Test
	public void realizaAtaque() {
		MockResult result = new MockResult();
		JogoController controller = new JogoController(result);

		controller.setAtacante(jogador1);
		controller.setAtacado(jogador2);

		Assert.assertEquals(controller.getAtacante().getId(), 1);
		Assert.assertEquals(controller.getAtacado().getId(), 2);

		controller.atacar("Mensagem de ataque ao Jogador 1");

		Assert.assertEquals(controller.getAtacante().getId(), 2);
		Assert.assertEquals(controller.getAtacado().getId(), 1);
		// Assert.assertEquals(controller.getAtaque(),
		// "Mensagem de ataque ao Jogador 1");
	}
}
