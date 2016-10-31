package javaEE.project;

//Imports
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employeeinventorymanager")

//Named Queries
@NamedQueries ({
@NamedQuery (name=EmployeeInventoryManager.FIND_BY_FIRST_NAME, query = "SELECT a FROM EmployeeInventoryManager a WHERE a.firstName = :firstName"),
@NamedQuery (name=EmployeeInventoryManager.FIND_BY_LAST_NAME, query = "SELECT a FROM EmployeeInventoryManager a WHERE a.lastName = :lastName"),
@NamedQuery (name=EmployeeInventoryManager.FIND_BY_ID, query = "SELECT a FROM EmployeeInventoryManager a WHERE a.employeeInventoryManagerId = :employeeInventoryManagerId"),
@NamedQuery (name=EmployeeInventoryManager.FIND_BY_USER_NAME, query = "SELECT a FROM EmployeeInventoryManager a WHERE a.userName = :userName"),
})

public class EmployeeInventoryManager {
//Query Declarations
public static final String FIND_BY_FIRST_NAME = "EmployeeInventoryManager.findByEmployeeInventoryManager";
public static final String FIND_BY_LAST_NAME = "EmployeeInventoryManager.findByEmployeeInventoryManager";
public static final String FIND_BY_ID = "EmployeeInventoryManager.findByEmployeeInventoryManager";
public static final String FIND_BY_USER_NAME = "EmployeeInventoryManager.findByEmployeeInventoryManager";
//Variable Declarations
@Id
@Column(name = "employeeInventoryManagerId")
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int employeeInventoryManagerId;
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
public EmployeeInventoryManager(String title, String firstName,String lastName, String userName, String password) {
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

public int getemployeeInventoryManagerId() {
return employeeInventoryManagerId;
}
}