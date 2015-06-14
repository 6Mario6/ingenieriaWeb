package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.dao.AdministradorDAO;
import com.udea.dao.imp.AdministradorDAOimp;
import com.udea.dto.Administrador;
import com.udea.dto.Usuario;
import com.udea.exception.MyException;

/**
 * Clase encargada de las pruebas unitarias para la clase ArchivoDaoImp
 * 
 * @author Mario Fernandez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// para decirle que voy a correr la prueba con lo que queda entre parentesis
@Transactional
// es una prueba transactional
// Vago
@ContextConfiguration(locations = { "classpath:/springconfig.xml" })
// Entre comillas debe ser la ruta del archivo de configuración xml
public class AdministradorDAOimpTest {
	@Autowired
	AdministradorDAO administradordao;
	List<Administrador> administradores = null;

	@Test
	public void testObtener() {
		PropertyConfigurator.configure("log4j.properties");
		

		try {
			administradordao = new AdministradorDAOimp();
			administradores = administradordao.obtener();

			for (Administrador ad : administradores) {
				System.out.println("administrador ID:"
						+ ad.getIdAdministrador());

			}
			assertTrue(true);

		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerAdministrador(Integer
	 * idAdministrador)
	 * 
	 */
	@Test
	public void testObtenerAdministrador() {
		Administrador administrador = null;

		try {
			// Prueba para obtener el administrador con idadministrador=1
			administrador = administradordao.obtenerAdministrador(1);
			System.out.println("id administrador:" + administrador.getIdAdministrador());

			assertTrue(true);

		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {
		
		Administrador admin=new Administrador();
		Usuario usuario = new Usuario();
		usuario.setNombre("Anderson");
		usuario.setApellido("Villa");
		usuario.setEmail("and@gmail.com");
		usuario.setGrupoInvestigacion("Web");
		usuario.setIdUsuario(44);
		usuario.setPassword("1234");
		usuario.setTelefono("778955");
		usuario.setUsername("cunt vaporizer");
		admin.setUsuario(usuario);
		try{
			
			administradordao.guardar(admin);			
			System.out.println("Archivo Guardado exitosamente");
							
			assertTrue(true);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
		System.out.println("ok");
	}

	@Test
	public void testActualizar() {
		
		Administrador admin=new Administrador();
		Usuario usuario = new Usuario();
		usuario.setNombre("Luna");
		usuario.setApellido("Villa");
		usuario.setEmail("and@gmail.com");
		usuario.setGrupoInvestigacion("Ingenieria Web");
		usuario.setIdUsuario(44);
		usuario.setPassword("1234");
		usuario.setTelefono("778955");
		usuario.setUsername("cunt vaporizer");
		admin.setUsuario(usuario);
		try{
			
			administradordao.actualizar(admin);			
			System.out.println("Archivo Guardado exitosamente");
							
			assertTrue(true);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
		System.out.println("ok");
	}

	@Test
	public void testEliminar() {
		System.out.println("ok");
	}

}
