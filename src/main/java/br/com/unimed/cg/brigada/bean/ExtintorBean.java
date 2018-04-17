package br.com.unimed.cg.brigada.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unimed.cg.brigada.controller.ExtintorController;
import br.com.unimed.cg.brigada.controller.PavimentoController;
import br.com.unimed.cg.brigada.model.Extintor;
import br.com.unimed.cg.brigada.model.Pavimento;
import br.com.unimed.cg.brigada.model.TipoExtintor;
import br.com.unimed.cg.brigada.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ExtintorBean {
	
	private @Getter @Setter List<Extintor> extintores;
	private @Getter @Setter Extintor extintor;
	private @Getter @Setter List<Pavimento> pavimentos;
	private @Getter @Setter List<TipoExtintor> tiposExtintor;
	private ExtintorController extintorController = new ExtintorController();
	private PavimentoController pavimentoController = new PavimentoController();
	
	@PostConstruct
	public void init() {
		extintor = new Extintor();
		extintores = listarExtintores();
		pavimentos = listarPavimentos();
		tiposExtintor = listarTiposExtintores();
	}
	
	private List<TipoExtintor> listarTiposExtintores() {
		try {
			return extintorController.listaTiposExtintores();
		}catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Ocorreu um erro inesperado ao consultar os tipos de extintores");
		}
		return new ArrayList<TipoExtintor>();
	}

	private List<Pavimento> listarPavimentos() {
		try {
			return pavimentoController.listaPavimentos();
		}catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Ocorreum um erro inesparado ao consultar os pavimentos!");
		}
		return new ArrayList<Pavimento>();
	}

	public List<Extintor> listarExtintores(){
		try {
			return extintorController.listaExtintores();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Extintor>();
	}
	
	
	public void cadastrar() {
		try {
			if(extintorController.cadastra(extintor)) {
				FacesUtil.addInfoMessage("Extintor '" + extintor.getSerial() + "' cadastrado com sucesso!");
			}else {
				FacesUtil.addErrorMessage("Não foi possível cadastrar o extintor '" + extintor.getSerial() + "'!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Ocorreu um erro inesperado ao cadastrar o extintor!");
		}
	}
//	public static void main(String[]args) {
//		ExtintorBean eb = new ExtintorBean();
//		eb.listarExtintores();
//	}
}
