package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Event {

	//Attributes
	private String name;
	
	//Relations
	private Spectator spectator;
	private Competitor competitor;
	
	//Constructor
	public Event(String name, Spectator spectator) {
		this.name = name;
		this.spectator= spectator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Spectator getSpectator() {
		return spectator;
	}

	public void setSpectator(Spectator spectator) {
		this.spectator = spectator;
	}

	public Competitor getCompetitor() {
		return competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}
	
	//addSpectator
	public void addSpectator(Spectator s, Spectator root) {
		
		if(s.getId().compareTo(root.getId()) < 0) {
			if(root.getLeft() == null) {
				root.setLeft(s);
			}else {
				addSpectator(s, root.getLeft());
			}
		}else {
			if(root.getRight() == null) {
				root.setRight(s);
			}else {
				addSpectator(s, root.getRight());
			}
		}
	}
	
	//loadSpectators
	public void loadSpectators(String path) throws IOException {
		
		if(path != null) {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null) {
				String[] attributes = line.split(",");
				
				String id = attributes[0];
				String firstName = attributes[1]; 
				String lastName = attributes[2]; 
				String email = attributes[3]; 
				String gender = attributes[4]; 
				String country = attributes[5]; 
				String photo = attributes[6]; 
				String birthDay = attributes[7];
				
				Spectator p = new Spectator(id, firstName, lastName, email, gender, country, photo, birthDay, null, null);
				if(spectator == null){
					spectator = p;
				}else{
				addSpectator(p, spectator);
				}
				br.readLine();
			}
			br.close();
		}
	}

	//searchSpectators
	public String searchSpectators(String idS, Spectator root) {
		String msj = "El espectador no esta agregado";
		
		if(idS.compareTo(root.getId()) ==  0) {
			msj = "ID: " + root.getId() + " "
					+ "\n Nombre: " + root.getFirstName() + " "
							+ "\n Apellido: " + root.getLastName() + " "
									+ "\n Email: " + root.getEmail() + " "
											+ "\n Genero: " + root.getGender() + " "
													+ "\n Pais: " + root.getCountry() + " "
															+ "\n Foto: " + root.getPhoto() + " "
																	+ "\n Fecha de nacimiento: " + root.getBirthDay();
		}else {
			if(root.getLeft() != null) {
				msj = searchSpectators(idS, root.getLeft());
			}
			if(root.getRight() != null) {
				msj = searchSpectators(idS, root.getRight());
			}
		}
		
		return msj;
	}
	
	//searchCompetitors
	public String searchCompetitors(String idC, Competitor root) {
		String msj = "El competidor no esta agregado";
		
		if(idC.compareTo(root.getId()) ==  0) {
			msj = "ID: " + root.getId() + " "
					+ "\n Nombre: " + root.getFirstName() + " "
							+ "\n Apellido: " + root.getLastName() + " "
									+ "\n Email: " + root.getEmail() + " "
											+ "\n Genero: " + root.getGender() + " "
													+ "\n Pais: " + root.getCountry() + " "
															+ "\n Foto: " + root.getPhoto() + " "
																	+ "\n Fecha de nacimiento: " + root.getBirthDay();
		}else {
			if(root.getNext() != null) {
				msj = searchCompetitors(idC, root.getNext());
			}
		}
		
		return msj;
	}
	
	//seFinal
	public String seFinal(String idS){
		long t1 = System.nanoTime();
		String msj = "El espectador no está registrado";
		
		if(spectator != null) {
			searchSpectators(idS, spectator);
		}
		long t2 = System.nanoTime();
		long tf = t2 - t1;
		return msj + "Tiempo del sistema: " + tf;
	}
	
	//scFinal
		public String scFinal(String idC){
			long t1 = System.nanoTime();
			String msj = "El competidor no está registrado";
			
			if(competitor != null) {
				searchCompetitors(idC, competitor);
			}
			long t2 = System.nanoTime();
			long tf = t2 - t1;
			return msj + "Tiempo del sistema: " + tf;
		}
}//final
