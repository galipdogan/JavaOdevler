package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification")
public class Verification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verification_id")
	private int verificationId;
	
	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "expired")
	private LocalDateTime expiresAt;

	@Column(name = "confirmed_at")
	private LocalDateTime confirmedAt;
	
//	@ManyToOne()
//	@JoinColumn(name = "user_id")
//	private User user;

}
