package org.sid.cinema.entities;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types=org.sid.cinema.entities.Projection.class)
public interface Projectionproj {
	public  Long getId();
	public double getPrix();
	public Date getDateProjection();
	public Salle getSalle();
	public Film getFilm();
	public Seance getSeance();
	public Collection<Ticket> getTickets();
	

}
