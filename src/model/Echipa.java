package model;

import java.util.Set;
import java.util.TreeSet;

import enums.Stadion;

public class Echipa implements Comparable<Echipa> {
	private String nume;
	private Stadion stadion;
	private int anFondare;
	private static Set<Echipa>lista=new TreeSet<>(); 
	
	public void addTeam(Echipa x) {
		lista.add(x);
	}
	public int getNumberOfTeams() {
		return lista.size();
	}
	public Set<Echipa> getTeams() {
		return lista;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getAnFondare() {
		return anFondare;
	}
	public void setAnFondare(int anFondare) {
		this.anFondare = anFondare;
	}
	public Stadion getStadion() {
		return stadion;
	}
	public void setStadion(Stadion stadion) {
		this.stadion = stadion;
	}
	
	@Override
	public int compareTo(Echipa x) {
		if (this.getAnFondare()-x.getAnFondare()==0)
			return this.getNume().compareTo(x.nume);
		return this.getAnFondare()-x.getAnFondare();
	}
}
