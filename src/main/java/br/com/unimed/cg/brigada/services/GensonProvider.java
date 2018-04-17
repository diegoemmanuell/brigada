package br.com.unimed.cg.brigada.services;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

@Provider
public class GensonProvider implements ContextResolver<Genson>{
private Genson genson = new GensonBuilder().setSkipNull(true).useDateAsTimestamp(false).useDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).create();
	
	@Override
	public Genson getContext(Class<?> arg0) {
		return genson;
	}
}
