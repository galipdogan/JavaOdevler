package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="verify")
public class Verify {
	
	@Id
	@GeneratedValue
	@Column(name="verify_id")
	private int verify_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="verified")
	private boolean verified;
	
	@Column(name="email_verified")
	private boolean email_verified;
	
	
	@Column(name="verify_date")
	private LocalDate verify_date;
}
