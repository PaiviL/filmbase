package hh.swd20.filmbase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
	// rajapinnan parametrisointi: Entity-luokka Film, pääavaimen luokkatietotyyppi Long
	// periytyy CrudRepositorystä, perii sen metodiesittelyt
	List<Film> findByTitle(String title);

}
