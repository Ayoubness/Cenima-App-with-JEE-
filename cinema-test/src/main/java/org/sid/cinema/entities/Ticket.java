package org.sid.cinema.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket {
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nomClient;
private double prix;
@Column(unique=false,nullable=true)
private Integer codePayement;
private boolean reserve ;
@ManyToOne
private Place place;
@ManyToOne
@JsonProperty(access=Access.WRITE_ONLY)
private Projection projection;

public String getNomClient() {
	return nomClient;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getCodePayement() {
	return codePayement;
}
public void setCodePayement(Integer codePayement) {
	this.codePayement = codePayement;
}
public Place getPlace() {
	return place;
}
public void setPlace(Place place) {
	this.place = place;
}
public Projection getProjection() {
	return projection;
}
public void setProjection(Projection projection) {
	this.projection = projection;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public boolean isReserve() {
	return reserve;
}
public void setReserve(boolean reserve) {
	this.reserve = reserve;
}

}