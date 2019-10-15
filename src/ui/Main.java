package ui;
import model.*;

import java.io.IOException;
import java.util.Scanner;
public class Main {

	private Scanner reader;
	private Event event;
	
	public Main() {
		init();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.showMessageExample();

	}

	private void showMessageExample() throws IOException {
		
		System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------IV Copa Panamericana de Voleibol Masculino Sub-21-----------");
        System.out.println("-----------------------------------------------------------------------");
        int a;
        Scanner Menu = new Scanner(System.in);

        do{
            System.out.println("-----------------Introduce una opcion valida---------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1. Buscar a un espectador");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("2. Buscar a un competidor");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("3. Añadir espectadores a partir de un archivo plano");
            System.out.println("-----------------------------------------------------------------");
            
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
            	
            	System.out.println(event.scFinal(idC));
            	break;
           
            case 3:
            	System.out.println("Ingresa la ruta relativa del archivo. (Ej: files/Spectators.csv)");
            	String path = reader.nextLine();
            	
            	event.loadSpectators(path);
            	break;
            }
            
        }while(a != 4);
	}

	private void init() {
		// TODO Auto-generated method stub
		
	}
}
