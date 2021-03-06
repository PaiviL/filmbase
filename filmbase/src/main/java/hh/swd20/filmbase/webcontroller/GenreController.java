package hh.swd20.filmbase.webcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.filmbase.domain.Genre;
import hh.swd20.filmbase.domain.GenreRepository;

@Controller
public class GenreController {
	
	@Autowired
	private GenreRepository genreRepository;
	
	// listing of genres
	@RequestMapping(value = "/genrelist", method = RequestMethod.GET)
	public String getGenres(Model model) {
		List<Genre> genres = (List<Genre>) genreRepository.findAll();
		model.addAttribute("genres", genres);
		return "genrelist";
	}
	
	// creating an empty form for a new genre
	@RequestMapping(value = "/addgenre", method = RequestMethod.GET)
	public String addNewGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	// saving the filled form data
	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String saveGenre(@Valid Genre genre, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {		// checking form data validness
			return "addgenre";
		}
		genreRepository.save(genre);
		return "redirect:/genrelist";
	}
	
	// deleting a genre from the list
	@RequestMapping(value = "/deletegenre/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteGenre(@PathVariable("id") Long genreId) {
		genreRepository.deleteById(genreId);
		return "redirect:../genrelist";
	}

}
