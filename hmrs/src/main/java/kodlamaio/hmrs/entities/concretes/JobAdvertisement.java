package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobAdvertisements")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "JobPosition" })
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "deadline", columnDefinition = "Date default CURRENT_DATE")
	private LocalDateTime deadline;

	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "min_salary")
	@NotBlank
	@NotNull
	private double minSalary;

	@Column(name = "max_salary")
	@NotBlank
	@javax.validation.constraints.NotNull
	private double maxSalary;

	@Column(name = "total_position")
	private int totalPosition;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

}
