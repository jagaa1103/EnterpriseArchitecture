package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private int rating = 0;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean admin = false;

    
    @Transient
	List<Comment> comments;
    
    @Transient
    List<Address> addresses;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 2)
    List<Item> boughtItems = new ArrayList<Item>();
    
     
	public List<Address> getAddresses() {
		return addresses;
	}

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

	public int getRanking() { return rating; }

	public void setRanking(int ranking) {
		this.rating = ranking;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(List<Item> items) {
		this.boughtItems = items;
	}


    public void addItem(Item item) {
    	this.boughtItems.add(item);
    	item.setBuyer(this);
    }
    
	public void addAddress(Address address) {
		this.addresses.add(address);
		address.setUser(this);
	}


}