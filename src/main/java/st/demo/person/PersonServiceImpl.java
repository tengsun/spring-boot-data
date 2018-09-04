package st.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepo;

	@Transactional(rollbackFor={IllegalArgumentException.class})
	public Person saveWithRollback(Person person) {
		Person p = personRepo.save(person);
		if (person.getName().equals("Jack")) {
			throw new IllegalArgumentException("User Jack already exists, data rollback!");
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class})
	public Person saveWithoutRollback(Person person) {
		Person p = personRepo.save(person);
		if (person.getName().equals("Jack")) {
			throw new IllegalArgumentException("User Jack already exists, but data will NOT rollback!");
		}
		return p;
	}

}
