package br.com.senai.sccv.api.services;

import java.sql.SQLException;

import br.com.senai.sccv.api.dao.AreaDao;

public class Teste {

	public static void main(String[] args) {
		
		AreaDao aDao = new AreaDao();
		try {
			aDao.listarAreasPorCidades();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
