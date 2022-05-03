package es.beonit.dcastalm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="prices")
public class Price implements Serializable{

	private static final long serialVersionUID = -9020107926577640306L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="price_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="brand_id", referencedColumnName="brand_id")
	private Brand brand;
	
	@Column(name="start_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyy-HH.mm.ss")
	private Date startDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyy-HH.mm.ss")
	private Date endDate;
	
	@Column(name="price_list")
	private Long priceList;
	
	@Column(name="product_id")
	private Long productId;
	
	private Integer priority;
	
	@Column(scale=2)
	private Double price;
	
	@Column(name="curr")
	private String currency;
}
