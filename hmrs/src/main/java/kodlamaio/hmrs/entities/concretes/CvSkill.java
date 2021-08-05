package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cvSkill")
@AllArgsConstructor
@NoArgsConstructor
public class CvSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cv_id")
	private  CV cv;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	int grade;
}
