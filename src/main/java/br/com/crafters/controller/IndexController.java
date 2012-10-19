package br.com.crafters.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
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
		this.jogadorDaVez = jogadorDaVez;
	}

	public void atacar(Ataque ataque) {
		executaOAtaque(ataque);

		verificaFinalizacaoDaPartida();

		this.jogadorDaVez = ataque.atacado;
	}

	private void executaOAtaque(Ataque ataque) {
		verificaSeAtaquePodeSerRealizado(ataque.linha, ataque.coluna);

		executaAtaqueNoOpenente(ataque);
	}

	private void verificaSeAtaquePodeSerRealizado(int linha, char coluna) {
		// TODO Auto-generated method stub
	}

	private void executaAtaqueNoOpenente(Ataque ataque) {
		
		// Caso o alvo seja acertado
		ataque.sucesso = true;
	}

	private void verificaFinalizacaoDaPartida() {
		// TODO Auto-generated method stub
	}
	
	@Path("/")
//	@Post
	public void index( String linha, String coluna, List<String> tabuleiro ) 
	{
		int tamanho = 2;
		String orientacao = "H";
		
		if ( ( linha != null ) && ( coluna != null ) )
		{
			int linhaInicio = Integer.parseInt( linha );
			int colunaInicio = Integer.parseInt( coluna );
			int linhaFim = linhaInicio;
			int colunaFim = colunaInicio;

			List<String> lstTabuleiro = new ArrayList<String>();
			String indiceCheck;
			if ( orientacao.equals( "H" ) )
			{
				linhaFim = linhaFim + tamanho;
				for ( int i = linhaInicio; i < linhaFim; i++ )
				{
					indiceCheck = i + "x" + colunaFim;
					lstTabuleiro.add( indiceCheck );
				}
			}
			else
				if ( orientacao.equals( "V" ) )
				{
					colunaFim = colunaFim + tamanho;
				}

			tabuleiro = lstTabuleiro;
			System.out.println( tabuleiro );
		}
	}

	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void setJogadorDaVez(Jogador jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}
}