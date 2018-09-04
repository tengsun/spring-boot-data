package st.demo.person;

public interface PersonService {

	public Person saveWithRollback(Person person);
	public Person saveWithoutRollback(Person person);
	
}
