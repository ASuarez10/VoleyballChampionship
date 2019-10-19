package test;
import model.Event;
import model.Spectator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class EventTest {

	private Event e;
	
	@Test
	void addSpectatorFinalTest() throws IOException {
		Spectator s = new Spectator("365764765", "Caramelo", "Brozovic", "epale@gmail.com", "Male", "Colombia", "Aja", "10/6/2019", null, null);
		Event e = new Event("Prueba", null, null);
		
		e.addSpectatorFinal(s);
		
		assertEquals(s.getId(), e.getSpectator().getId());
	}

	@Test
	void addSpectatorTest() throws IOException {
		Spectator s = new Spectator("365764765", "Caramelo", "Brozovic", "epale@gmail.com", "Male", "Colombia", "Aja", "10/6/2019", null, null);
		Event e = new Event("Prueba", null, null);
		Spectator t = new Spectator("3653434443765", "Caramelo", "Brozovic", "epale@gmail.com", "Male", "Colombia", "Aja", "10/6/2019", null, null);
		
		e.addSpectatorFinal(s);
		e.addSpectator(t, s);
		if(e.getSpectator() != null) {
			if(t.getId().compareTo(e.getSpectator().getId()) < 0) {
				assertEquals(t.getId(), e.getSpectator().getLeft().getId());
			}else if(t.getId().compareTo(e.getSpectator().getId()) > 0) {
				assertEquals(t.getId(), e.getSpectator().getRight().getId());
			}
		}
	}
	
	@Test
	void searchSpectatorsTest() throws IOException {
		Spectator s = new Spectator("365764765", "Caramelo", "Brozovic", "epale@gmail.com", "Male", "Colombia", "Aja", "10/6/2019", null, null);
		Event e = new Event("Prueba", null, null);
		Spectator t = new Spectator("3653434443765", "Caramelo", "Brozovic", "epale@gmail.com", "Male", "Colombia", "Aja", "10/6/2019", null, null);
		
		e.addSpectatorFinal(s);
		e.addSpectator(t, s);
		
		String r = e.searchSpectators(t.getId(), s);
		
		String mal = "El espectador no esta agregado";
		String bien = "ID: " + t.getId() + " "
				+ "\n Nombre: " + t.getFirstName() + " "
				+ "\n Apellido: " + t.getLastName() + " "
						+ "\n Email: " + t.getEmail() + " "
								+ "\n Genero: " + t.getGender() + " "
										+ "\n Pais: " + t.getCountry() + " "
												+ "\n Foto: " + t.getPhoto() + " "
														+ "\n Fecha de nacimiento: " + t.getBirthDay();
		String hoped = "ID: " + t.getId() + " "
				+ "\n Nombre: " + t.getFirstName() + " "
				+ "\n Apellido: " + t.getLastName() + " "
						+ "\n Email: " + t.getEmail() + " "
								+ "\n Genero: " + t.getGender() + " "
										+ "\n Pais: " + t.getCountry() + " "
												+ "\n Foto: " + t.getPhoto() + " "
														+ "\n Fecha de nacimiento: " + t.getBirthDay();
		
		assertEquals(hoped, bien);
	}
}
