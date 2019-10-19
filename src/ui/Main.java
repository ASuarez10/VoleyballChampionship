package ui;
import model.*;

import java.io.IOException;
import java.util.Scanner;

import exception.CountryNotFoundException;
import exception.PathNullException;
public class Main {

	private Scanner reader;
	private Event event;
	
	public Main() throws IOException {
		init();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) throws IOException, CountryNotFoundException, PathNullException {
		Main m = new Main();
		m.showMessageExample();

	}

	private void showMessageExample() throws IOException, CountryNotFoundException, PathNullException {
		
		System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------IV Copa Panamericana de Voleibol Masculino Sub-21-----------");
        System.out.println("-----------------------------------------------------------------------");
        int a;
        Scanner Menu = new Scanner(System.in);

        do{
            System.out.println("------------------Introduce una opcion valida----------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1. Buscar a un espectador");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("2. Buscar a un competidor");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("3. Añadir espectadores y competidores a partir de un archivo CSV");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("4. Mostrar los espectadores de un pais");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("5. Mostrar los competidores de un pais");
            System.out.println("-------------------------------------------------------------------");
            
            a = Menu.nextInt();
            
            switch (a){
            
            case 1:  
            	System.out.println("Ingresa el ID del espectador a buscar");
            	String idS = reader.nextLine();
            	
            	System.out.println(event.seFinal(idS));
            	break;
            
            case 2:
            	System.out.println("Ingresa el ID del competidor a buscar");
            	String idC = reader.nextLine();
            	
            	System.out.println(event.searchCompetitors(idC));
            	break;
           
            case 3:
            	System.out.println("Ingresa la ruta relativa del archivo. (Ej: files/WorldCup.csv)");
            	String path = reader.nextLine();
            	
            	event.loadSpectators(path);
            	break;
            	
            case 4:
            	System.out.println("Ingresa el pais de los espectadores");
            	String cp = reader.nextLine();
            	
            	event.showSByCountryFinal(cp);
            	break;
            	
            case 5:
            	System.out.println("Ingresa el pais de los competidores");
            	String country = reader.nextLine();
            	
            	System.out.println(event.showCByCountry(country));
            	break;
            }
            
        }while(a != 6);
	}

	private void init() throws IOException {
		Spectator s = new Spectator("23423475876987", "Suajelo", "Bergaenelano", "asuarez100501@gmail.com", "Machirulo", "Locombia", "Sisas", "10/05/2001", null, null);
		Competitor c = new Competitor("234234758456987", "Suajelo2", "Bergaenelano2", "asuarez100501@gmail.com2", "Machirulo2", "Locombia2", "Sisas2", "10/05/20012", null, null);
		event = new Event("Mundial de Voleybol", s, c);
		
	}
}
