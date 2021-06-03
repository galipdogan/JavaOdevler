package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false) 
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website_name")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_active")
	private boolean isActive=false;

}
