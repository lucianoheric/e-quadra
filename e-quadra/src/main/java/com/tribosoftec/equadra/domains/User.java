package com.tribosoftec.equadra.domains;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reg_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@Size(min = 5, max = 150)
	private String name;
	
	@NotNull
	@Size(max = 250)
	private String email;
	
	@NotNull
	@Size(min = 6, max = 50)
	private String passwd;
	
	@NotNull
	private Boolean is_active;
	
	@NotNull
	private OffsetDateTime ts_created; 
	
	private OffsetDateTime ts_removed;
	
	public User() {
		
	}

	public User(Long id, String name, String email, String passwd, Boolean is_active, OffsetDateTime ts_created,
			OffsetDateTime ts_removed) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.is_active = is_active;
		this.ts_created = ts_created;
		this.ts_removed = ts_removed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return email;
	}

	public void setLogin(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public OffsetDateTime getTs_created() {
		return ts_created;
	}

	public void setTs_created(OffsetDateTime ts_created) {
		this.ts_created = ts_created;
	}

	public OffsetDateTime getTs_removed() {
		return ts_removed;
	}

	public void setTs_removed(OffsetDateTime ts_removed) {
		this.ts_removed = ts_removed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
