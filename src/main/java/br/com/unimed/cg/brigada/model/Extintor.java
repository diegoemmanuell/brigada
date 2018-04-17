package br.com.unimed.cg.brigada.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Extintor {

	private @Getter @Setter String serial;
	private @Getter @Setter Pavimento pavimento;
	private @Getter @Setter String localizacao;
	private @Getter @Setter Date dataCadastro;
	private @Getter @Setter TipoExtintor tipoExtintor;
}
