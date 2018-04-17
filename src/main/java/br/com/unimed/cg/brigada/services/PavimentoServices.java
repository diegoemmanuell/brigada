package br.com.unimed.cg.brigada.services;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.unimed.cg.brigada.model.Pavimento;

public class PavimentoServices {
	private Client client;
	ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
	private WebResource webResource;
	private final String apiPavimentos = "http://localhost:8080/brigadaservices/rest/pavimento";
	
	public PavimentoServices() {
		client = Client.create(clientConfig);
//		client.addFilter(new LoggingFilter(System.out));
		webResource = client.resource(apiPavimentos);
	}
	
	public List<Pavimento> listaPavimentos() {
		return webResource.path("/").get(new GenericType<List<Pavimento>>(){});
	}

	
}
