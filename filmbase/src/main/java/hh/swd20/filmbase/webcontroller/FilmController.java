package hh.swd20.filmbase.webcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.filmbase.domain.Film;
import hh.swd20.filmbase.domain.FilmRepository;
import hh.swd20.filmbase.domain.GenreRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	@RequestMapping("/")
	public String homepage() {
		return "index";
	}
	
	// listing of films
	@RequestMapping(value = "/filmlist", method = RequestMethod.GET)
	public String getFilms(Model model) {
		List<Film> films = (List<Film>) filmRepository.findAll(); // fetching films from database
		model.addAttribute("films", films); 	// model object exposes list of films to template
		return "filmlist";
	}
	
	// creating an empty form for a new film
	@RequestMapping(value = "/addfilm", method = RequestMethod.GET)
	public String addFilm(Model model) {
		model.addAttribute("film", new Film()); // empty film object to template
		model.addAttribute("genres", genreRepository.findAll()); // fetching genres, and exposing to template
		return "addfilm";
	}
	
	// saving the filled form data
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFilm(@Valid Film film, BindingResult bindingResult, Model  model) { 
		if (bindingResult.hasErrors()) {		// checking form data validness
			model.addAttribute("genres", genreRepository.findAll()); // fetching genres, exposing to template
			return "editfilm";
		}
		filmRepository.save(film);				// save film to database
		return "redirect:/filmlist";			// returning to listing of films
	}
	
	// deleting a film entry from the list
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteFilm(@PathVariable("id") Long filmId) {
		filmRepository.deleteById(filmId);		// removing a film from database by id
		return "redirect:../filmlist";			// returning to listing of films
	}
	
	// editing a film entry
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editFilm(@PathVariable("id") Long filmId, Model model) {
		model.addAttribute("film", filmRepository.findById(filmId)); // fetching film by id, and exposing to template
		model.addAttribute("genres", genreRepository.findAll());	 // fetching genres, and exposing to template
		return "editfilm";
	}

}
