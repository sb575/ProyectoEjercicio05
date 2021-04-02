package ual.hmis.sesion05.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.asignatura.Alumno;

public class Ejercicio6Test {
	
	@ParameterizedTest(name = "{index} => Con la nota ({0}) sale {1}")
	@CsvSource ({"0, Suspenso","-1, Error en la nota", "11, Error en la nota", "4.9, Suspenso",
		"5, Bien", "1, Suspenso", "3.4, Suspenso", "5.5 , Bien", "6.9, Bien", "7, Notable", "8.9, Notable",
		"7.8, Notable", "9, Sobresaliente", "9.9, Sobresaliente", "9.5, Sobresaliente",
		"10, Matrícula"})
	
	void testCalificaciones_parametrized(double nota, String expected) {
		Alumno alumno = new Alumno();
		assertEquals(expected, alumno.calificacion(nota));
	}

}
