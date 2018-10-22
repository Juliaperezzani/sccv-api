package br.com.senai.sccv.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.senai.sccv.api.services.CidadeService;

public class ApplicationConfig extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(CidadeService.class);
		return recursos;
	}
	
}
