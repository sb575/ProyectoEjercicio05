package ual.hmis.sesion05.ejercicio5;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runners.Parameterized.Parameters;

import ual.hmis.asignatura.Actividad;
import ual.hmis.asignatura.Alumno;
import ual.hmis.asignatura.Ejercicio;

public class Ejercicio5Test {
	
	ArrayList<Ejercicio> ejercicios;
	static ArrayList<Actividad> actividades;
	double puntuacionTotal;
	
	@ParameterizedTest(name = "{index} => nota de {1} es {2}")
    @MethodSource("actividadProvider")
	void Ejercicio5Test(Alumno a, Actividad actividad, double puntuacionTotal) {
		assertNotNull(actividad);
		assertNotNull(puntuacionTotal);
		
		a.calcularNotaActividad(actividad.getNombre());
		double resultado = actividad.getPuntuacionTotal();
		assertAll(
				()-> assertEquals(puntuacionTotal, resultado)
				
				);
		
	}
	
	
	static Stream<Arguments> actividadProvider(){
		Actividad mates = new Actividad("Matematicas");
		mates.agregarEjercicioCalificado("Ejercicio1", 8);
		mates.agregarEjercicioCalificado("Ejercicio2", 9);
		
		Actividad lengua = new Actividad("Lengua");
		lengua.setNombre(lengua.getNombre() + " castellana");
		lengua.agregarEjercicioCalificado("Ejercicio1", 9);
		lengua.agregarEjercicioCalificado("Ejercicio2", 10);
		
		Actividad Ingles = new Actividad("Ingles");
		Ingles.agregarEjercicioCalificado("Ejercicio1", 6);
		Ingles.agregarEjercicioCalificado("Ejercicio2", 7.5);
		
		//Esta asignatura, no se incluirá en el boletin del alumno (para cubrir el caso de que no está la actividad 
		//entre las actividades asignadas al alumno.
		Actividad Biologia = new Actividad("Biologia");
		Biologia.agregarEjercicioCalificado("Ejercicio1", 10);
		Biologia.agregarEjercicioCalificado("Ejercicio2", 8.5);
		Biologia.agregarEjercicioCalificado("Ejercicio3", 5);

		Biologia.getEjercicios().get(0).setNombre(Biologia.getEjercicios().get(0).getNombre() + "2");
		ArrayList<Ejercicio> ejerciciosBiologia = Biologia.getEjercicios();
		ejerciciosBiologia.remove(2);
		Biologia.setEjercicios(ejerciciosBiologia);
		
		Alumno a = new Alumno();
		a.setNombre(a.getNombre() + "Sokaina");
		ArrayList<Actividad> actividadesIncluidas = new ArrayList<Actividad>();
		actividadesIncluidas.add(mates);
		actividadesIncluidas.add(lengua);
		actividadesIncluidas.add(Ingles);

		a.setActividadesAsignadas(actividadesIncluidas);
		
		ArrayList<Actividad> actividadesNoIncluidas = new ArrayList<Actividad>();

		actividadesNoIncluidas.add(Biologia);
		return Stream.of(
			
			Arguments.of(a,mates, 8.5), Arguments.of(a,lengua, 9.5), Arguments.of(a,Ingles, 6.75),
			Arguments.of(a,Biologia, 0)
				
				
				);
	}

}
