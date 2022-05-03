package es.beonit.dcastalm.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="brands")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1211971762420299260L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brand_id")
	private Long id;
	
	private String name;
}
