package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hmrs.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_sekeers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class JobSekeer extends User {

	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "nationality_id", length = 11)
	private String nationalityId;

	@NotNull
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "is_active")
	private boolean isActive = false;

}
