package st.demo.contact;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactDataController {

	@Autowired
	ContactRepository contactRepo;

	@RequestMapping("/saveContact")
	public Contact save() {
		Contact c = new Contact("Mike", 50);
		Collection<Location> locations = new LinkedHashSet<Location>();
		Location loc1 = new Location("high land", "12094");
		Location loc2 = new Location("west park", "14623");
		Location loc3 = new Location("green field", "35221");
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
		c.setLocations(locations);
		return contactRepo.save(c);
	}

	@RequestMapping("/findByName")
	public Contact findByName(String name) {
		return contactRepo.findByName(name);
	}

	@RequestMapping("/findByAge")
	public List<Contact> findByAge(Integer age) {
		return contactRepo.withQueryFindByAge(age);
	}

}
