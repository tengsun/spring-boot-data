package st.demo.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDataController {
	
	// for repository testing

	@Autowired
	PersonRepository personRepo;

	@RequestMapping("/save")
	public Person save(String name, String address, Integer age) {
		Person p = personRepo.save(new Person(null, name, age, address));
		return p;
	}

	@RequestMapping("/q1")
	public List<Person> q1(String address) {
		List<Person> persons = personRepo.findByAddress(address);
		return persons;
	}

	@RequestMapping("/q2")
	public Person q2(String name, String address) {
		Person p = personRepo.findByNameAndAddress(name, address);
		return p;
	}

	@RequestMapping("/q3")
	public Person q3(String name, String address) {
		Person p = personRepo.withNameAndAddressQuery(name, address);
		return p;
	}

	@RequestMapping("/q4")
	public Person q4(String name, String address) {
		Person p = personRepo.withNameAndAddressNamedQuery(name, address);
		return p;
	}

	@RequestMapping("/sort")
	public List<Person> sort(String name, String address, Integer age) {
		List<Person> persons = personRepo.findAll(new Sort(Sort.Direction.ASC, "age"));
		return persons;
	}
	
	// for transaction testing
	
	@Autowired
	PersonService personSvc;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return personSvc.saveWithRollback(person);
	}
	
	@RequestMapping("/norollback")
	public Person noRollback(Person person) {
		return personSvc.saveWithoutRollback(person);
	}
	
	// for cache testing
	
	@RequestMapping("/cache")
	public Person cache(Person person) {
		return personSvc.findOne(person);
	}
	
	@RequestMapping("/put")
	public Person put(Person person) {
		return personSvc.save(person);
	}
	
	@RequestMapping("/evict")
	public String evict(Long id) {
		personSvc.remove(id);
		return "ok";
	}

}
