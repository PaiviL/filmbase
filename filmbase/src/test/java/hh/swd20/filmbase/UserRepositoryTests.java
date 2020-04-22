package hh.swd20.filmbase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.filmbase.domain.User;
import hh.swd20.filmbase.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUsernameReturnsUser() {
		User user = userRepository.findByUsername("user");
		assertThat(user.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void CreateNewUser() {
		User user = new User("newuser", "$2a$10$cskCQgOdASh7Nj6bT4Kbru6cAGm2dHklOGkBd.hymXu/9vGGkcjVK", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void DeleteOneUser() {
		User user = userRepository.findByUsername("user");
		userRepository.deleteById(user.getId());
		
		User deluser = userRepository.findByUsername("user");
		assertThat(deluser).isNull();
	}

}
