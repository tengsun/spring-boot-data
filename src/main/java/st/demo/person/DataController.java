package st.demo.person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	PersonRepository personRepo;
	
	@RequestMapping("/save")
	public Person save(String name, String address, Integer age) {
		Person p = personRepo.save(new Person(null, name, age, address));
		return p;
	}

}
