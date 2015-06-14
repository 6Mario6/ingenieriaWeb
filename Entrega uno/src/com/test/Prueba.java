package com.test;

import com.udea.dao.UsuarioDAO;
import com.udea.dao.imp.UsuarioDAOimp;
import com.udea.dto.Usuario;
import com.udea.exception.MyException;

public class Prueba {

	public static void main(String[] args) throws MyException {
		UsuarioDAO us = new UsuarioDAOimp();

		for (Usuario usuario : us.obtener()) {
			System.out.println("Usuario: [id: " + usuario.getIdUsuario()
					+ ", Nombre : " + usuario.getNombre() + " ]");
		}

	}

}
