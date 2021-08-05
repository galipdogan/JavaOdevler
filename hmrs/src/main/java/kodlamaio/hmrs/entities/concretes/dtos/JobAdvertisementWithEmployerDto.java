package kodlamaio.hmrs.entities.concretes.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerDto {

	private String companyName;
	private String jobPositionName;
	private String cityName;
	private int totalPositions;
	private LocalDateTime createdAt;
	private LocalDateTime deadline;
	private boolean isActive;
	private int jobtitleId;
	private int cityId;
	private int userId;
	private String description;
	
	
}
