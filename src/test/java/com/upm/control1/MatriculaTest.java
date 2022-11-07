package com.upm.control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class MatriculaTest {
	
	// Objeto que utilizaremos para el testing 
	private Matricula mat;
	
	/*
	 * Caso de prueba del ejercicio 7.
	 */
	@Test
	public void importeVectorNuloTest() {
		
		// Inicializacon del objeto
		mat = new Matricula(null);
		
		// Asercion de que se lanza una Exception
		assertThrows(Exception.class, () -> {
		    	mat.getImporte();
		    },
		    "La llamada a getImporte() debería haber lanzado una Exception"
		);
	}
	
	/*
	 * Caso de prueba del ejercicio 8.
	 */
	@Test
	public void importeCorrectoTest() {
		
		// Creamos mocks para un par de asignaturas
		Asignatura asig_1 = mock(Asignatura.class);
		Asignatura asig_2 = mock(Asignatura.class);
		Asignatura asig_3 = mock(Asignatura.class);
		
		// Establecemos el comportamiento de cada mock
		// para probar la funcionalidad del metodo getImporte()
		when(asig_1.getImporte()).thenReturn((double) 400);
		when(asig_2.getImporte()).thenReturn((double) 500);
		when(asig_3.getImporte()).thenReturn((double) 300);
		
		// Juntamos todas las asignaturas en un vector
		Vector<Asignatura> asigs = new Vector<Asignatura>();
		asigs.addAll(Arrays.asList(asig_1, asig_2, asig_3));
		
		// Inicializacon del objeto Matricula
		mat = new Matricula(asigs);
		
		try {
			assertEquals((double) 1200, mat.getImporte());
		} catch (Exception e) {
			fail("No deberia lanzar Exception");
		}
	}
	
	/*
	 * Caso de prueba del ejercicio 9.
	 */
	@Test
	public void importeIteraAsignaturasTest() {
		
		// Creamos mocks para un par de asignaturas
		Asignatura asig_1 = mock(Asignatura.class);
		Asignatura asig_2 = mock(Asignatura.class);
		Asignatura asig_3 = mock(Asignatura.class);
		
		// Establecemos el comportamiento de cada mock
		// para probar la funcionalidad del metodo getImporte()
		when(asig_1.getImporte()).thenReturn((double) 400);
		when(asig_2.getImporte()).thenReturn((double) 500);
		when(asig_3.getImporte()).thenReturn((double) 300);
		
		// Juntamos todas las asignaturas en un vector
		Vector<Asignatura> asigs = new Vector<Asignatura>();
		asigs.addAll(Arrays.asList(asig_1, asig_2, asig_3));
		
		// Inicializacon del objeto Matricula y ejecucion de su getImporte()
		mat = new Matricula(asigs);
		try {
			mat.getImporte();
		} catch (Exception e) {
			fail("No deberia lanzar Exception");
		}
		
		// Iteramos el vector de asignaturas comprobando que para
		// cada una se ha ejecutado su metodo getImporte()
		Asignatura asig_aux;
		for (int i = 0; i < asigs.size(); i++) {
			asig_aux = asigs.get(i);
			verify(asig_aux, times(1)).getImporte();
		}
	}
}
