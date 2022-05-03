package es.beonit.dcastalm.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PriceRequestDto {

	private Long brandId;
	private Long productId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss", timezone="CET")
	private Date requestDate;
}
