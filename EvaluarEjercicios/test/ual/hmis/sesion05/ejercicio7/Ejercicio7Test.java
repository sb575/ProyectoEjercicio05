package ual.hmis.sesion05.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.asignatura.Alumno;

public class Ejercicio7Test {
	
	@ParameterizedTest(name = "{index} => El curso para la fecha de nacimiento ({0}) es {1}")
	@CsvSource ({"2017, 1� Educaci�n Infantil", "2016, 2� Educaci�n Infantil", "2015, 3� Educaci�n Infantil",
		"2014, 1� Educaci�n Primaria", "2013, 2� Educaci�n Primaria", "2012, 3� Educaci�n Primaria",
		"2011, 4� Educaci�n Primaria", "2010, 5� Educaci�n Primaria", "2009, 6� Educaci�n Primaria",
		"2008, 1� Educaci�n Secundaria", "2007, 2� Educaci�n Secundaria", "2006, 3� Educaci�n Secundaria",
		"2005, 4� Educaci�n Secundaria", "2018, No escolar"})
	void testAsteriscos_parametrized(int anyoNacimiento, String expected) {
		Alumno alumno = new Alumno();
		assertEquals(expected, alumno.cursoSegunEdad(anyoNacimiento));
	}

}
