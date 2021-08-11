package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cv")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","languages,skills,educations"})
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "linkedin_adress")
	private String linkedinAdress;

	@Column(name = "github_adress")
	private String githubAdress;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "work")
	private String work;

	@Column(name = "image_url")
	private String imageUrl = "https://res.cloudinary.com/glpdgn/image/upload/v1628163454/wd5hebfqqzwp7ehs4hiy.png";

	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguages;
	
	@OneToMany(mappedBy = "cv")
	private List<CvSkill> cvSkills;
	
	@OneToMany(mappedBy = "cv")
	private List<CvEducation> cvEducations;
	
}
