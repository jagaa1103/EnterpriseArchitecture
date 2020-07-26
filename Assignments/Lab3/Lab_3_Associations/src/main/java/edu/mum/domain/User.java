package edu.mum.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements Serializable  {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id = null;

    @Version
    private int version = 0;

    
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "RATING", nullable = false)
    private Integer ranking = 0;

    @Column(name = "IS_ADMIN", nullable = false)
    private Boolean admin = false;

	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinTable(name = "user_credential",
			joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name = "USER")})
	private UserCredentials userCredentials;

	@OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "user")
    private Set<Address> addresses = new HashSet<Address>();





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}
	public void addAddress(Address address){
		this.addresses.add(address);
		address.addUser(this);
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

}