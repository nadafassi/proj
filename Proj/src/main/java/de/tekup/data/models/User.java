package de.tekup.data.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@AllArgsConstructor /* constructer avec tous arguments*/
@NoArgsConstructor /*constructer par defaut*/
@Table(name="Users")
@EqualsAndHashCode(exclude = {"msgs"})
@ToString(exclude = {"msgs"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_role", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name may not be blank")
	@Size(max = 50, min = 3)
	@Pattern(regexp = "[a-zA-Z ]+", message = "Nom must contain only characters")
	@Column(name =  "nom", length = 50, nullable = false, unique = true)
	private String nom;
	
	@NotBlank(message = "Prenom may not be blank")
	@Size(max = 50, min = 3)
	@Pattern(regexp = "[a-zA-Z ]+", message = "Prenom must contain only characters")
	@Column(name =  "prenom", length = 50, nullable = false, unique = true)
	private String prenom;
	
	@NotEmpty
	@Email
	private String email;
	
	// password should not be null or empty
	// password should have at least 8 characters
	@NotEmpty
	@Size(min = 4, message = "password should have at least 8 characters")
	private String pwd;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)    
	private Set<Message> msgs;
	
}
