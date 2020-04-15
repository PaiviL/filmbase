package hh.swd20.filmbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.filmbase.domain.Film;
import hh.swd20.filmbase.domain.FilmRepository;
import hh.swd20.filmbase.domain.Genre;
import hh.swd20.filmbase.domain.GenreRepository;

@SpringBootApplication
public class FilmbaseApplication {
	private static final Logger log = LoggerFactory.getLogger(FilmbaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FilmbaseApplication.class, args);
	}
	// testing data to H2-database
	@Bean
	public CommandLineRunner filmDemo(FilmRepository filmRepository, GenreRepository genreRepository) {
		return (args) -> {
			log.info("save genres testdata");
			genreRepository.save(new Genre("Drama"));
			genreRepository.save(new Genre("Epic/Historical"));
			genreRepository.save(new Genre("Action"));
			genreRepository.save(new Genre("Sci-fi"));
			
			log.info("save films testdata");
			filmRepository.save(new Film("The Shawshank Redemption", "Frank Darabont", 1994, 
					"Two imprisoned men bonding over two decades, finding eventual redemption through acts of common decency", 
					"Tim Robbins, Morgan Freeman, Bob Gunton", 9.3, genreRepository.findByGenreName("Drama").get(0)));
			filmRepository.save(new Film("Gone with the Wind", "Victor Fleming", 1939, 
					"The life and romance of strong-willed Scarlett O'Hara during the American Civil War & Reconstruction periods", 
					"Vivien Leigh, Clark Gable, Thomas Mitchell", 8.1, genreRepository.findByGenreName("Drama").get(0)));
			filmRepository.save(new Film("Avatar", "James Cameron", 2009, 
					"On the lush moon of Pandora inhabited by sapient humanoids, an ex-marine on a mission becomes torn between two worlds", 
					"Sam Worthington, Zoe Saldana, Sigourney Weaver", 7.8, genreRepository.findByGenreName("Sci-fi").get(0)));
			
			log.info("fetch all genres");
			for (Genre genre : genreRepository.findAll()) {
				log.info(genre.toString());
			}
			log.info("fetch all films");
			for (Film film : filmRepository.findAll()) {
				log.info(film.toString());
			}
		};
	}
}
