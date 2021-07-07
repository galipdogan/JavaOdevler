package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobPosition"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int job_position_id;
	
	@Column(name="job_position_name")
	private String jobPositionName;
	
//	@Column(name= "created_at", columnDefinition = "Date default CURRENT_DATE")
//	private LocalDate createdDate = LocalDate.now();
	
	@Column(name= "is_active")
	private boolean isActive;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "jobPosition")
//    private List<JobAdvertisement> jobAdvertisement;
	
}
