package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private int employee_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="job_position_id")
	private int job_position_id;
	
	@Column(name="verify_id")
	private int verify_id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="website_name")
	private String website_name;
	
	@Column(name="tax_number")
	private String tax_number;
	
	@Column(name="phone_number")
	private String phone_number;
}
