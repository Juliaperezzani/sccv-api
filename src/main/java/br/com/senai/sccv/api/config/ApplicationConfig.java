package br.com.senai.sccv.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.senai.sccv.api.services.AreaService;
import br.com.senai.sccv.api.services.CidadeService;
import br.com.senai.sccv.api.services.CurriculoService;
import br.com.senai.sccv.api.services.CursoService;
import br.com.senai.sccv.api.services.SemestreService;

public class ApplicationConfig extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(CurriculoService.class);
		recursos.add(CidadeService.class);
		recursos.add(AreaService.class);
		recursos.add(CursoService.class);
		recursos.add(SemestreService.class);
		return recursos;
	}
	
}
