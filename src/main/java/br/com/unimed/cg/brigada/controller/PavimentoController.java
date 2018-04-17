package br.com.unimed.cg.brigada.controller;

import java.util.List;

import br.com.unimed.cg.brigada.model.Pavimento;
import br.com.unimed.cg.brigada.services.PavimentoServices;

public class PavimentoController {

	private PavimentoServices pavimentoServices;
	
	public List<Pavimento> listaPavimentos() {
		pavimentoServices  = new PavimentoServices();
		return pavimentoServices.listaPavimentos();
	}

}
