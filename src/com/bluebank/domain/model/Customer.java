package com.bluebank.domain.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -3671959505183604634L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long id;
	@Version
	private Long version;
	private String name;
	private String ssn;
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	@OneToOne
	private Address address;
	@OneToOne
	private Contact contact;

	public Customer() {
	}

	public Customer(String name, String ssn, Calendar birthDate, Address address, Contact contact) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.birthDate = birthDate;
		this.address = address;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", version=" + version + ", name=" + name + ", ssn=" + ssn + ", birthDate="
				+ birthDate + ", address=" + address + ", contact=" + contact + "]";
	}

}
