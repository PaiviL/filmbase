package hh.swd20.filmbase.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.filmbase.domain.Film;
import hh.swd20.filmbase.domain.FilmRepository;
import hh.swd20.filmbase.domain.Genre;
import hh.swd20.filmbase.domain.GenreRepository;


@Controller
public class RestController {
	
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	// RESTful service to get all films (JSON)
	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public @ResponseBody List<Film> getFilmsRest() {
		return (List<Film>) filmRepository.findAll();
	}
	
	// RESTful service to get film by id (JSON)
	@RequestMapping(value = "/films/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Film> fildFilmRest(@PathVariable("id") Long filmId) {
		return filmRepository.findById(filmId);
	}
	
	// RESTful service to get all genres (JSON)
	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public @ResponseBody List<Genre> getGenresRest() {
		return (List<Genre>) genreRepository.findAll();
	}
	
	// RESTful service to get genre by id (JSON)
	@RequestMapping(value = "/genres/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Genre> fildGenreRest(@PathVariable("id") Long genreId) {
		return genreRepository.findById(genreId);
	}
	
	// RESTful service to save new film 
	@RequestMapping(value = "/films", method = RequestMethod.POST)
    public @ResponseBody Film addFilmRest(@RequestBody Film film) {	
    	filmRepository.save(film);
    	return film;
    }
	
	// Home page of REST services
    @RequestMapping(value = "/resthome", method = RequestMethod.GET)
    public String getRestHome() {	
    	return "resthomepage"; // resthomepage.html
    }

}
