package project.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "roles")
@Table(name = "roles")
public class Role {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
