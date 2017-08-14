package project.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class User {

	@Id
	@Column(name = "ID")
	private int id;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Role getRole() {
		return this.role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
