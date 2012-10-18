package br.com.crafters.functional;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import br.com.crafters.controller.JogoController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.crafters.model.Jogador;

public class RealizarJogadaTest {

	@Before
	public void setUp() throws Exception {
		Jogador j1 = new Jogador();
		j1.setId(1);
		j1.setNome("j1");
		JogoController.jogadores.put(j1.getId(), j1);
		
		Jogador j2 = new Jogador();
		j2.setId(2);
		j2.setNome("j2");
		JogoController.jogadores.put(j2.getId(), j2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ataqueJogador1Test()
	{
		Integer idJogador = new Integer( 1 );
		Jogador j1 = JogoController.jogadores.get( idJogador );
		Integer idAdv = new Integer( 2 );
		String msg = "atacar";
		j1.atacar(idAdv, msg);
		Jogador j2 = JogoController.jogadores.get( idAdv );
		Assert.assertEquals( msg, j2.getMsg() );
	}

	@Test
	public void ataqueJogador2Test()
	{
		Integer idJogador = new Integer( 2 );
		Jogador j2 = JogoController.jogadores.get( idJogador );
		Integer idAdv = new Integer( 1 );
		String msg = "ataqueJogador2";
		j2.atacar(idAdv, msg);
		Jogador j1 = JogoController.jogadores.get( idAdv );
		Assert.assertEquals( msg, j1.getMsg() );
	}
}