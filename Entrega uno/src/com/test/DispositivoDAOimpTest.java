package com.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.dao.AdministradorDAO;
import com.udea.dao.CategoriaDAO;
import com.udea.dao.DispositivoDAO;
import com.udea.dao.EstadoDAO;
import com.udea.dao.imp.AdministradorDAOimp;
import com.udea.dao.imp.CategoriaDAOimp;
import com.udea.dao.imp.DispositivoDAOimp;
import com.udea.dao.imp.EstadoDAOimp;
import com.udea.dao.imp.UsuarioDAOimp;
import com.udea.dto.Administrador;
import com.udea.dto.Categoria;
import com.udea.dto.Dispositivo;
import com.udea.dto.Usuario;
import com.udea.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
//para decirle que voy a correr la prueba con lo que queda entre parentesis
@Transactional
//es una prueba transactional
//Vago
@ContextConfiguration(locations = { "classpath:/springconfig.xml" })
//Entre comillas debe ser la ruta del archivo de configuración xml
public class DispositivoDAOimpTest {
	
	@Autowired
	DispositivoDAO dispositivodao;
	List<Dispositivo> dispositivos = null;
	

	@Test
	public void testObtener() {
		
	PropertyConfigurator.configure("log4j.properties");
		

		try {
			dispositivodao = new DispositivoDAOimp();
			dispositivos = dispositivodao.obtener();

			for (Dispositivo device : dispositivos) {
				System.out.println("Nombre de Dispositivo: "
						+ device.getNombre());

			}
			assertTrue(true);

		} catch (MyException e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testObtenerDispositivo() {
		
		Dispositivo disp = null;

		try {
			// Prueba para obtener el administrador con idadministrador=1
			disp = dispositivodao.obtenerDispositivo(1);
			System.out.println("id Nombre Dispositivo: " + disp.getNombre());

			assertTrue(true);

		} catch (MyException e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testGuardar() throws MyException {
		CategoriaDAO catdao= new CategoriaDAOimp(); 		
		AdministradorDAO admdao= new AdministradorDAOimp();
		EstadoDAO estadao= new EstadoDAOimp();
		
		Dispositivo  disp=null;
		disp.setAdministrador(admdao.obtenerAdministrador(1));
		disp.setCategoria(catdao.obtenerCategoria(1));
		disp.setEstado(estadao.obtenerEstado(1));
		disp.setIdDispositivo(2);
		disp.setDescripcion("Dispositivo Movil");
		disp.setNombre("Celular BLU");
		
		
		
		try{
			
			dispositivodao.guardar(disp);			
			System.out.println("Usuario Guardado exitosamente");
							
			assertTrue(true);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
		System.out.println("ok");
		
	}

	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
