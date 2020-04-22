package hh.swd20.filmbase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.filmbase.domain.Genre;
import hh.swd20.filmbase.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTests {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Test
	public void findByTitleReturnsGenre() {
		List<Genre> genres = genreRepository.findByGenreName("Action");
		
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getGenreId()).isEqualTo(3);
	}
	
	@Test
	public void CreateNewGenre() {
		Genre genre = new Genre("Comedy");
		genreRepository.save(genre);
		assertThat(genre.getGenreId()).isNotNull();
	}
	
	@Test
	public void DeleteOneGenre() {
		List<Genre> genres = genreRepository.findByGenreName("Action");
		assertThat(genres).hasSize(1);
		genreRepository.deleteById(genres.get(0).getGenreId());
		
		List<Genre> delgenres = genreRepository.findByGenreName("Action");
		assertThat(delgenres).hasSize(0);
	}

}
