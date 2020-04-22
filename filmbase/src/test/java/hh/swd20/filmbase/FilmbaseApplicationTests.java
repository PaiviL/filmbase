package hh.swd20.filmbase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.filmbase.webcontroller.FilmController;
import hh.swd20.filmbase.webcontroller.GenreController;
import hh.swd20.filmbase.webcontroller.RestController;

// Testing that controllers are created
@RunWith(SpringRunner.class)
@SpringBootTest
class FilmbaseApplicationTests {
	
	@Autowired
	private FilmController filmController;
	@Autowired
	private GenreController genreController;
	@Autowired
	private RestController restController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(filmController).isNotNull();
		assertThat(genreController).isNotNull();
		assertThat(restController).isNotNull();
	}

}
