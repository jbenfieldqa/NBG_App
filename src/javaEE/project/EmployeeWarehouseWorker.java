package javaEE.project;

//Imports
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employeewarehouseworker")

//Named Queries
@NamedQueries ({
	@NamedQuery (name=EmployeeWarehouseWorker.FIND_BY_FIRST_NAME, query = "SELECT a FROM EmployeeWarehouseWorker a WHERE a.firstName = :firstName"),
	@NamedQuery (name=EmployeeWarehouseWorker.FIND_BY_LAST_NAME, query = "SELECT a FROM EmployeeWarehouseWorker a WHERE a.lastName = :lastName"),
	@NamedQuery (name=EmployeeWarehouseWorker.FIND_BY_ID, query = "SELECT a FROM EmployeeWarehouseWorker a WHERE a.eWWId = :eWWId"),
	@NamedQuery (name=EmployeeWarehouseWorker.FIND_BY_USER_NAME, query = "SELECT a FROM EmployeeWarehouseWorker a WHERE a.userName = :userName"),
})

public class EmployeeWarehouseWorker {
	
	//Query Declarations
	public static final String FIND_BY_FIRST_NAME = "EmployeeWarehouseWorker.findByEmployeeWarehouseWorker";
	public static final String FIND_BY_LAST_NAME = "EmployeeWarehouseWorker.findByEmployeeWarehouseWorker";
	public static final String FIND_BY_ID = "EmployeeWarehouseWorker.findByEmployeeWarehouseWorker";
	public static final String FIND_BY_USER_NAME = "EmployeeWarehouseWorker.findByEmployeeWarehouseWorker";
	
	//Variable Declarations
	@Id
	@Column(name = "eWWId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int eWWId;
	@Column(name = "title", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String title;
	@Column(name = "firstName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String firstName;
	@Column(name = "lastName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String lastName;
	@Column(name = "userName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String userName;
	@Column(name = "password", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String password;
	
	//Constructor
	public EmployeeWarehouseWorker(String title, String firstName,
			String lastName, String userName, String password) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;	
	}
	
	
	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int geteWWId() {
		return eWWId;
	}
	
	
	
	

}
