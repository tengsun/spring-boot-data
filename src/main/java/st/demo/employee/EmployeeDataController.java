package st.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDataController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@RequestMapping("/saveEmployee")
	public void saveEmployee() {
		String name = "Nancy";
		Employee employee = new Employee("7", name, 35);
		employeeRepo.setName(name);
		employeeRepo.setEmployee(employee);
	}
	
	@RequestMapping("/getName")
	public String getName() {
		return employeeRepo.getName();
	}
	
	@RequestMapping("/getEmployee")
	public Employee getEmployee(String id) {
		return employeeRepo.getEmployee(id);
	}
	
}
