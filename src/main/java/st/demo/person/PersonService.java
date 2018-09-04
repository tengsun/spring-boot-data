package st.demo.person;

public interface PersonService {

	// for transaction testing
	
	public Person saveWithRollback(Person person);
	public Person saveWithoutRollback(Person person);
	
	// for cache testing
	
	public Person save(Person person);
	public void remove(Long id);
	public Person findOne(Person person);
	
}
