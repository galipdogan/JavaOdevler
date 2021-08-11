package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cvEducation")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CV cv;
	
	@ManyToOne()
	@JoinColumn(name = "education_id")
	private Education education;
	
	@Column (name="start_date")
	private LocalDate startDate =LocalDate.now();
	
	@Column (name="graduated_date")
	private LocalDate graduatedDate=LocalDate.now();
	
}
