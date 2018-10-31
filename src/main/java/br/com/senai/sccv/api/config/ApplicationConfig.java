package br.com.senai.sccv.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.senai.sccv.api.services.AreaService;
import br.com.senai.sccv.api.services.CidadeService;
import br.com.senai.sccv.api.services.CursoService;

public class ApplicationConfig extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(CidadeService.class);
		recursos.add(AreaService.class);
		recursos.add(CursoService.class);
		return recursos;
	}
	
}
