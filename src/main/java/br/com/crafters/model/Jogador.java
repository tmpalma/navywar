package br.com.crafters.model;

import br.com.crafters.controller.IndexController;

public class Jogador {
	private int id;
	private String nome;
	private String msg;

	public void atacar(Integer idAdversario, String msg) {
		Jogador adversario = IndexController.jogadores.get(idAdversario);
		adversario.setMsg(msg);
		IndexController.jogadores.put(idAdversario, adversario);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
