package model;

import exception.CountryNotFoundException;
import exception.PathNullException;

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
	public Event(String name, Spectator spectator, Competitor competitor) throws IOException {
		this.name = name;
		this.spectator= spectator;
		this.competitor = competitor;
		//loadSpectators("files/WorldCup.csv");
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
	
	//addSpectatorFinal
	public void addSpectatorFinal(Spectator p) {
		if(spectator == null){
			spectator = p;
		}else{
			addSpectator(p, spectator);
		}
	}
	//loadSpectators
	public void loadSpectators(String path) throws IOException, PathNullException {
		
		if(path != null) {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			int i = 1;
			int conta = 0;
			while(line != null && (conta++ < 40000)) {
				String[] attributes = line.split(",");
				
				String id = attributes[0];
				String firstName = attributes[1]; 
				String lastName = attributes[2]; 
				String email = attributes[3]; 
				String gender = attributes[4]; 
				String country = attributes[5]; 
				String photo = attributes[6]; 
				String birthDay = attributes[7];
				
				if(i%2 == 0) {
					Spectator p = new Spectator(id, firstName, lastName, email, gender, country, photo, birthDay, null, null);
					addSpectatorFinal(p);
					
				}else {
					Competitor p = new Competitor(id, firstName, lastName, email, gender, country, photo, birthDay, null, null);
					addCompetitor(p);
				}
				
				
				line = br.readLine();
				i++;
			}
			br.close();
		}else {
			try {
				throw new PathNullException("La ruta es vacia");
			}catch(PathNullException p) {
				System.out.println(p.getMessage());
			}	
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
			if(idS.compareTo(root.getId()) < 0) {
				if(root.getLeft() != null) {
					msj = searchSpectators(idS, root.getLeft());
				}
			
			}
			if(idS.compareTo(root.getId()) > 0) {
				if(root.getRight() != null) {
					msj = searchSpectators(idS, root.getRight());
				}
			}
		}
		
		return msj;
	}
	
	//showSByCountry
	public String showSByCountry(String cp, Spectator root) {
		String msj = "";
		
		if(root.getCountry().equals(cp)) {
			msj += root.getId()+"\n |__";
			
			if(root.getLeft() != null && root.getLeft().getCountry().equals(cp)) {
				msj += root.getLeft().getId() + "\n |__";
			}
			if(root.getRight() != null && root.getRight().getCountry().equals(cp)) {
				msj += root.getRight().getId() + "\n |__";
			}
		}
		if(root.getLeft() != null) {
			msj += showSByCountry(cp, root.getLeft());
		}
		if(root.getRight() != null) {
			msj += showSByCountry(cp, root.getRight());
		}
		
		return msj;
	}
	
	//showSByCountryFinal
	public String showSByCountryFinal(String cp) {
		String msj = "";
		
		if(spectator == null) {
			msj = "No existe ese pais";
		}else {
			msj = showSByCountry(cp, spectator);
		}
		
		
		return msj;
	}
	
	//searchCompetitors
	public String searchCompetitors(String idC) {
		long t1 = System.nanoTime();
		String msj = "El competidor no esta agregado";
		
		if(competitor != null) {
			if(idC.compareToIgnoreCase(competitor.getId()) == 0) {
				msj = "ID: " + competitor.getId() + " "
						+ "\n Nombre: " + competitor.getFirstName() + " "
								+ "\n Apellido: " + competitor.getLastName() + " "
										+ "\n Email: " + competitor.getEmail() + " "
												+ "\n Genero: " + competitor.getGender() + " "
														+ "\n Pais: " + competitor.getCountry() + " "
																+ "\n Foto: " + competitor.getPhoto() + " "
																		+ "\n Fecha de nacimiento: " + competitor.getBirthDay();
			}else {
				Competitor temp = competitor;
				boolean esta = false;
				
				while(!esta && temp != null) {
					if(temp.getId().equals(idC)) {
						esta = true;
						msj = "ID: " + competitor.getId() + " "
								+ "\n Nombre: " + competitor.getFirstName() + " "
										+ "\n Apellido: " + competitor.getLastName() + " "
												+ "\n Email: " + competitor.getEmail() + " "
														+ "\n Genero: " + competitor.getGender() + " "
																+ "\n Pais: " + competitor.getCountry() + " "
																		+ "\n Foto: " + competitor.getPhoto() + " "
																				+ "\n Fecha de nacimiento: " + competitor.getBirthDay();
					}else {
						temp = temp.getNext();
					}
				}
				
				if(esta == false) {
					msj = "El competidor no esta agregado";
				}
			}
		}
		long t2 = System.nanoTime();
		long tf = t2 - t1;
		return msj + "\n El tiempo de busqueda fue de: " + tf;
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
		
	//addCompetitor
	public void addCompetitor(Competitor co) {
			
		if(co != null) {
			if(competitor == null) {
				competitor = co;
			}else {
				Competitor temp = competitor.getNext();
				competitor.setNext(co);
				co.setPrevious(competitor);
				co.setNext(temp);
				if(temp != null) {
					temp.setPrevious(co);
				}
			}
		}
	}
	
	//showCByCountry
	public String showCByCountry(String country) throws CountryNotFoundException { 
		String msj = "Los competidores de ese pais son:\n";
		
		Competitor temp = competitor;
		boolean hay = false;
		
		while(temp != null) {
			if(temp.getCountry().compareToIgnoreCase(country) == 0) {
				msj += "->" + temp.getId();
				hay = true;
			}		
			temp = temp.getNext();
		}
		
		try {
			if(hay == false) {
				throw new CountryNotFoundException("No hay competidores de ese pais");
			}
		}catch(CountryNotFoundException c) {
			System.out.println(c.getMessage());
		}
		return msj;
	}
}//final
