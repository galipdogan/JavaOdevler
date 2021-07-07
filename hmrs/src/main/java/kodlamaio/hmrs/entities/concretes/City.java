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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false) 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int city_id;

	@Column(name = "city_name")
	private String city_name;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "city")
//	private List<JobAdvertisement> jobAdvertisements;

//	public City(String name, List<JobAdvertisement> jobAdverts) {
//		super();
//		this.city_name = name;
//		this.jobAdvertisement = jobAdverts;
//	}
}
