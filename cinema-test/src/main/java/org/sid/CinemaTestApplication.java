package org.sid;

import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Ticket;
import org.sid.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaTestApplication implements CommandLineRunner {
    @Autowired
	private ICinemaInitService  cinemaInitService;
    @Autowired
    private RepositoryRestConfiguration restconfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restconfiguration.exposeIdsFor(Film.class);
		restconfiguration.exposeIdsFor(Salle.class,Ticket.class);
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
		
	}
	

}
