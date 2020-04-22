package hh.swd20.filmbase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.filmbase.domain.Film;
import hh.swd20.filmbase.domain.FilmRepository;
import hh.swd20.filmbase.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FilmRepositoryTests {
	
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	@Test
	public void findByTitleReturnsFilm() {
		List<Film> films = filmRepository.findByTitle("Avatar");
		
		assertThat(films).hasSize(1);
		assertThat(films.get(0).getDirector()).isEqualTo("James Cameron");
	}
	
	@Test
	public void CreateNewFilm() {
		Film film = new Film("Titanic", "James Cameron", 1997, "Jack and Rose fall in love aboard the ill-fated Titanic", 
				"Leonardo DiCaprio, Kate Winslet", 7.8, genreRepository.findByGenreName("Epic/Historical").get(0));
		filmRepository.save(film);
		assertThat(film.getFilmId()).isNotNull();
	}
	
	@Test
	public void DeleteOneFilm() {
		List<Film> films = filmRepository.findByTitle("Avatar");
		assertThat(films).hasSize(1);
		filmRepository.deleteById(films.get(0).getFilmId());
		
		List<Film> delfilms = filmRepository.findByTitle("Avatar");
		assertThat(delfilms).hasSize(0);
	}

}
