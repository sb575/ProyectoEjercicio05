package ual.hmis.asignatura;

import java.util.ArrayList;
import java.util.*;

public class Alumno {

	private String nombre;
	private ArrayList<Actividad> actividadesAsignadas;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Actividad> getActividadesAsignadas() {
		return actividadesAsignadas;
	}

	public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
		this.actividadesAsignadas = actividadesAsignadas;
	}

	public double calcularNotaActividad(String nombreActividad) {
		double puntacionTotal = 0;
		int numEjercicios = 0;
		for(Actividad actividad : this.getActividadesAsignadas()) {
			if(nombreActividad.equals(actividad.getNombre())) {
				for(Ejercicio ejercicio : actividad.getEjercicios()) {
					puntacionTotal += ejercicio.getPuntuacion();
					numEjercicios++;
				}
				actividad.setPuntuacionTotal(puntacionTotal/numEjercicios);
				break;
			}
		}
		
		return puntacionTotal;
	}
	
	public String calificacion(double nota) {
		String cadena = "";
		
		if(nota < 0 || nota > 10) cadena = "Error en la nota";
		
		if(nota >= 0 && nota <= 4.9) cadena = "Suspenso";
		else if((nota >= 5 ) && (nota <= 6.9)) 	cadena = "Bien";
		else if((nota >= 7 ) && (nota <= 8.9)) cadena = "Notable";
		else if((nota >= 9 ) && (nota <= 9.9)) cadena = "Sobresaliente";
		else if(nota == 10) cadena = "Matrícula";
			
		
		return cadena;
	}
	
	
	public String cursoSegunEdad(int anyoNacimiento) {
		String curso = "";
		switch (anyoNacimiento){
			case 2017:
				curso = "1º Educación Infantil";
				break;
			case 2016:
				curso = "2º Educación Infantil";
				break;
			case 2015:
				curso = "3º Educación Infantil";
				break;
			case 2014:
				curso = "1º Educación Primaria";
				break;
			case 2013:
				curso = "2º Educación Primaria";
				break;
			case 2012:
				curso = "3º Educación Primaria";
				break;
			case 2011:
				curso = "4º Educación Primaria";
				break;
			case 2010:
				curso = "5º Educación Primaria";
				break;
			case 2009:
				curso = "6º Educación Primaria";
				break;
			case 2008:
				curso = "1º Educación Secundaria";
				break;
			case 2007:
				curso = "2º Educación Secundaria";
				break;
			case 2006:
				curso = "3º Educación Secundaria";
				break;
			case 2005:
				curso = "4º Educación Secundaria";
				break;
			default:
				curso = "No escolar";
				break;
		}
		
		
		return curso;
	}

}
