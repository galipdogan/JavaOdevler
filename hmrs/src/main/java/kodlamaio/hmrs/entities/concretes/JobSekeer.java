package kodlamaio.hmrs.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="job_sekeers")
public class JobSekeer {
	
	@Id
	@GeneratedValue
	@Column(name="job_sekeer_id")
	private int job_sekeer_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="nationality_id")
	private long nationality_id;
	
	@Column(name="date_of_birth")
	private Date date_of_birth;
}
