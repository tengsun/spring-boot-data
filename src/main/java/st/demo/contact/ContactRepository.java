package st.demo.contact;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ContactRepository extends MongoRepository<Contact, String> {

	Contact findByName(String name);
	
	@Query("{'age': ?0}")
	List<Contact> withQueryFindByAge(Integer age);
	
}
