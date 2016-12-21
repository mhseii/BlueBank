package com.bluebank.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.bluebank.domain.model.enums.ContactType;

@Entity
public class Contact implements Serializable {

	private static final long serialVersionUID = -6984256395782880694L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Version
	private Long version;
	@Enumerated(EnumType.STRING)
	private ContactType type;
	private String info;

	public Contact() {
	}
	
	public Contact(ContactType type, String info) {
		super();
		this.type = type;
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public ContactType getType() {
		return type;
	}

	public String getInfo() {
		return info;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (type != other.type)
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
		return "Contact [id=" + id + ", version=" + version + ", type=" + type + ", info=" + info + "]";
	}

}
