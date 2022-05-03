package es.beonit.dcastalm.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class PriceDto {
	
	private Long brandId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss", timezone="CET")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss", timezone="CET")
	private Date endDate;
	private Long priceList;
	private Long productId;
	private Integer priority;
	private Double price;
	private String curr;

}