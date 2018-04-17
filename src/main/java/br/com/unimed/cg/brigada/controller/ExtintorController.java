package br.com.unimed.cg.brigada.controller;

import java.util.List;

import br.com.unimed.cg.brigada.model.Extintor;
import br.com.unimed.cg.brigada.model.TipoExtintor;
import br.com.unimed.cg.brigada.services.ExtintorServices;
import br.com.unimed.cg.brigada.services.TipoExtintorServices;

public class ExtintorController {

	private ExtintorServices extintorServices;
	
	private TipoExtintorServices tipoExtintorServices;
	
	public List<Extintor> listaExtintores() {
		extintorServices = new ExtintorServices();
		return extintorServices.listaExtintores();
	}

	public List<TipoExtintor> listaTiposExtintores() {
		tipoExtintorServices = new TipoExtintorServices();
		return tipoExtintorServices.listaTiposExtintores();
	}

	public boolean cadastra(Extintor extintor) {
		extintorServices = new ExtintorServices();
		return extintorServices.cadastra(extintor).equals("Extintor " + extintor.getSerial() + " cadastrado com sucesso!");
	}

}
