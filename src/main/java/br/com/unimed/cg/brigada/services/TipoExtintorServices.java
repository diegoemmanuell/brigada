package br.com.unimed.cg.brigada.services;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.unimed.cg.brigada.model.Extintor;
import br.com.unimed.cg.brigada.model.TipoExtintor;

public class TipoExtintorServices {
	private Client client;
	ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
	private WebResource webResource;
	private final String apiTipoExtintor = "http://localhost:8080/brigadaservices/rest/tipoExtintor";
	
	public TipoExtintorServices() {
		client = Client.create(clientConfig);
//		client.addFilter(new LoggingFilter(System.out));
		webResource = client.resource(apiTipoExtintor);
	}
	
	public List<TipoExtintor> listaTiposExtintores() {
		return webResource.path("/").get(new GenericType<List<TipoExtintor>>() {});
	}

	
}
