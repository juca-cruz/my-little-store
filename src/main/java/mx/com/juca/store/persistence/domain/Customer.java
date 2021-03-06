package mx.com.juca.store.persistence.domain;

// Generated Feb 9, 2011 9:17:03 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = -1601028700107791766L;
	private int idCustomer;
	private String email;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date creationTs;
	private Date modificationTs;
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);
	private Set<Order> orders = new HashSet<Order>(0);

	public Customer() {
	}

	public Customer(int idCustomer, String email, String password,
			String firstName, String lastName) {
		this.idCustomer = idCustomer;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(int idCustomer, String email, String password,
			String firstName, String middleName, String lastName,
			Date creationTs, Set<CreditCard> creditCards) {
		this.idCustomer = idCustomer;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.creationTs = creationTs;
		this.creditCards = creditCards;
	}

	@Id
	@Column(name = "id_customer", unique = true, nullable = false)
	public int getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Column(name = "email", unique = true, nullable = false, length = 120)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name", length = 50)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", nullable = false, length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_ts", length = 19, updatable=false, insertable=true)
	public Date getCreationTs() {
		return this.creationTs;
	}

	public void setCreationTs(Date creationTs) {
		this.creationTs = creationTs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modification_ts", length = 19, updatable=true, insertable=true, nullable=false)
	public Date getModificationTs() {
		return modificationTs;
	}

	public void setModificationTs(Date modificationTs) {
		this.modificationTs = modificationTs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CreditCard> getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", email=" + email
				+ ", password=" + password + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", creationTs=" + creationTs + ", modificationTs="+modificationTs+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCustomer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (idCustomer != other.idCustomer)
			return false;
		return true;
	}

}
