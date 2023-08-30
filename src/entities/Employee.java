package entities;

public class Employee {

	private String name;
	private String email;
	private Double Salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, Double salary) {
		super();
		this.name = name;
		this.email = email;
		Salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}
	
	
	
	
	
	
}
