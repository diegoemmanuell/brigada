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

public class ExtintorServices {
	private Client client;
	ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
	private WebResource webResource;
	private final String apiExtintores = "http://localhost:8080/brigadaservices/rest/extintor";
	
	public ExtintorServices() {
		client = Client.create(clientConfig);
//		client.addFilter(new LoggingFilter(System.out));
		webResource = client.resource(apiExtintores);
	}
	
	public List<Extintor> listaExtintores() {
		return webResource.path("/").get(new GenericType<List<Extintor>>(){});
	}

	public String cadastra(Extintor extintor) {
		return webResource.path("/").post(String.class, extintor);
	}

	
}
