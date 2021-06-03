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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification")
public class Verification extends User {

	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "created_at", nullable = false, columnDefinition = "Date defult CURRENT_DATE")
	private LocalDateTime createdAt;

	@Column(name = "expired", nullable = false)
	private LocalDateTime expiresAt;

	@Column(name = "confirmed_at")
	private LocalDateTime confirmedAt;

}
