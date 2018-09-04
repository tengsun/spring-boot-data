package st.demo.person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepo;

	// for transaction testing

	@Transactional(rollbackFor = { IllegalArgumentException.class })
	public Person saveWithRollback(Person person) {
		Person p = personRepo.save(person);
		if (person.getName().equals("Jack")) {
			throw new IllegalArgumentException("User Jack already exists, data rollback!");
		}
		return p;
	}

	@Transactional(noRollbackFor = { IllegalArgumentException.class })
	public Person saveWithoutRollback(Person person) {
		Person p = personRepo.save(person);
		if (person.getName().equals("Jack")) {
			throw new IllegalArgumentException("User Jack already exists, but data will NOT rollback!");
		}
		return p;
	}

	// for cache testing

	@CachePut(value = "persons", key = "#person.id")
	public Person save(Person person) {
		Person p = personRepo.save(person);
		System.out.println("put person in cache with id: " + p.getId());
		return p;
	}

	@CacheEvict(value = "persons")
	public void remove(Long id) {
		personRepo.deleteById(id);
		System.out.println("remove person in cache by id: " + id);
	}

	@Cacheable(value = "persons", key = "#person.id")
	public Person findOne(Person person) {
		Optional<Person> op = personRepo.findById(person.getId());
		Person p = null;
		if (op.isPresent()) {
			p = op.get();
		}
		System.out.println("find and put person in cache with id: " + p.getId());
		return p;
	}

}
