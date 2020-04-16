package hh.swd20.filmbase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long genreId;
	
	@NotNull
	private String genreName;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Film> films;
	
	//constructors
	public Genre() {
		super();
	}

	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	public Genre(Long genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}
	
	//getters and setters
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	//toString
	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}

}
