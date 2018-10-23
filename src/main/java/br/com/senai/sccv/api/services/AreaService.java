package br.com.senai.sccv.api.services;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.senai.sccv.api.vo.Cidade;

public class AreaService {

	
	@POST
	@Path("/disponiveis")
	public List<Cidade> cidades(){
		
		
	}
}
