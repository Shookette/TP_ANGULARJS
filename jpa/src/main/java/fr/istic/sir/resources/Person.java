package fr.istic.sir.resources;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
@Entity
public class Person {

	private int id;
	
	private String lastName;
	
	private String firstName;
	
	private String sex;
	
	private String email;
	
	private Date birthday;
	
	private String facebook;
	
	private List<Home> homes = new ArrayList<Home>();
	
	private List<Person> friends = new ArrayList<Person>();

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(){}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	@JsonManagedReference("person-home")
	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	
	public void addHome(Home home) {
		this.homes.add(home);
	}
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="Friends")
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
}
