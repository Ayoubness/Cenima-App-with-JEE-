package org.sid.cinema.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

//creation d'une api rest
@RestController
@CrossOrigin("*")
public class CinemaRestConroller {
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@GetMapping(path="/imageFilm/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable (name="id")Long id) throws Exception{

		Film f=filmRepository.findOne(id);
		String photoName=f.getPhoto();
		File file=new File(System.getProperty("user.home")+"/Cinema/images/"+photoName);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	
	}
	
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketFrom ticketfrom){
		List<Ticket> listTickets=new ArrayList<>();
		ticketfrom.getTickets().forEach(idTicket->{
			System.out.println("num    "+ticketfrom.getCodepayement()+"\n");
			System.out.println("nom "+ticketfrom.toString()+"\n");
			
			Ticket ticket= ticketRepository.findOne( idTicket );
			
			ticket.setNomClient(ticketfrom.getNomClient());
			ticket.setReserve(true);
			ticket.setCodePayement(ticketfrom.getCodepayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		
		return listTickets;
		 
		
	}
	
}
	@Data
	class TicketFrom{
		
	
		public String getNomClient() {
			return nomClient;
		}
		public Integer getCodepayement() {
			
			return codepayement;
		}
	
		public List<Long> getTickets() {
			return tickets;
		}
	
		private String nomClient;
		private Integer codepayement;
		private List<Long> tickets=new ArrayList<>();
		
		
	}
	


