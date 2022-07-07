package nashtech.ass.phuochg.coffeeshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	@NotEmpty(message = "Email must not be empty")
	@Size(min = 3, max = 64)
	@Email
	private String email;
	@NotEmpty(message = "Role must not be empty")
	private String role;
	@NotEmpty(message = "Address must not be empty")
	private String address;
	@NotEmpty(message = "Name must not be empty")
	private String name;
	@NotEmpty(message = "PhoneNumber must not be empty")
	private String phoneNumber;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}