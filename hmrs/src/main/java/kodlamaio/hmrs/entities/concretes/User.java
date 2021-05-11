package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

}
