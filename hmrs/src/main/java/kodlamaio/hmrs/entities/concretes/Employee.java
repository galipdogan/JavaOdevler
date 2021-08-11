package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import kodlamaio.hmrs.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false) 
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{
	
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="is_active" )
	private boolean isActive;
	
}
