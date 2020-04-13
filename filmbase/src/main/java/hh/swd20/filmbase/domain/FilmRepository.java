package hh.swd20.filmbase.domain;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
	// rajapinnan parametrisointi: Entity-luokka Film, pääavaimen luokkatietotyyppi Long
	// periytyy CrudRepositorystä, perii sen metodiesittelyt

}
