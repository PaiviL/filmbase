package hh.swd20.filmbase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long filmId;
	
	@NotNull
	@Size(min=1, max=100)
	private String title;
	
	@Size(min=2, max=30)
	private String director;
	
	@Min(1800) @Max(2020)
	private int year;
	
	private String description;
	private String leadroles;
	
	@Min(1) @Max(10)
	private double imdb;
	
	//constructors
	public Film() {
		super();
	}

	public Film(String title, String director, int year, String description, String leadroles,
			double imdb) {
		super();
		this.title = title;
		this.director = director;
		this.year = year;
		this.description = description;
		this.leadroles = leadroles;
		this.imdb = imdb;
	}

	public Film(Long filmId, String title, String director, int year, String description, String leadroles,
			double imdb) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.director = director;
		this.year = year;
		this.description = description;
		this.leadroles = leadroles;
		this.imdb = imdb;
	}

	//getters and setters
	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLeadroles() {
		return leadroles;
	}

	public void setLeadroles(String leadroles) {
		this.leadroles = leadroles;
	}

	public double getImdb() {
		return imdb;
	}

	public void setImdb(double imdb) {
		this.imdb = imdb;
	}

	//toString
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", director=" + director + ", year=" + year
				+ ", description=" + description + ", leadroles=" + leadroles + ", imdb=" + imdb + "]";
	}

}
