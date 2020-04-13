package hh.swd20.filmbase.webcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.filmbase.domain.Film;
import hh.swd20.filmbase.domain.FilmRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@RequestMapping("/")
	public String homepage() {
		return "index";
	}
	
	// listing of films
	@RequestMapping(value = "/filmlist", method = RequestMethod.GET)
	public String getFilms(Model model) {
		List<Film> films = (List<Film>) filmRepository.findAll(); // fetch films from database
		model.addAttribute("films", films); // model object exposes list of films to template
		return "filmlist";
	}
	
	// creating an empty form for a new film
	@RequestMapping(value = "/addfilm", method = RequestMethod.GET)
	public String addFilm(Model model) {
		model.addAttribute("film", new Film()); // empty film object to template
		return "addfilm";
	}
	
	// saving the filled form data
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFilm(@Valid Film film, BindingResult bindingResult) { //@ModelAttribute Film film
		if (bindingResult.hasErrors()) {		// checking form data validness
			return "addfilm";
		}
		filmRepository.save(film);				// save film to database
		return "redirect:/filmlist";			// returning to listing of films
	}

}
//Controller-luokan metodi + Thymeleaf-template, testaus