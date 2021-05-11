package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="job_position_id")
	private int job_position_id;
	
	@Column(name="job_position_name")
	private String job_position_name;
}
