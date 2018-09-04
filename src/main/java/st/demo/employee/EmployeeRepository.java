package st.demo.employee;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;
	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOpsObj;

	public void setName(String name) {
		valOpsStr.set("employee", name);
	}

	public String getName() {
		return valOpsStr.get("employee");
	}

	public void setEmployee(Employee employee) {
		valOpsObj.set(employee.getId(), employee);
	}

	public Employee getEmployee(String id) {
		return (Employee) valOpsObj.get(id);
	}

}
