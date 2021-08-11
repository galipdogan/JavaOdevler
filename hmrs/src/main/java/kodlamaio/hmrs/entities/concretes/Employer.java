package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import kodlamaio.hmrs.core.entities.User;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="website_name")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name="is_active" ,columnDefinition = "boolean default false")
	private boolean isActive=false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	

}
