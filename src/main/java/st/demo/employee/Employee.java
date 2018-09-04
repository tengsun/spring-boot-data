package st.demo.employee;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 4632727036266320589L;

	private String id;
	private String name;
	private Integer age;

	public Employee() {
		super();
	}

	public Employee(String id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
