package es.beonit.dcastalm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.beonit.dcastalm.dto.PriceDto;
import es.beonit.dcastalm.dto.PriceRequestDto;
import es.beonit.dcastalm.service.IPriceService;

@RestController
@RequestMapping("/beonit/prices")
public class PriceController {

	@Autowired
	private IPriceService priceService;
	
	@GetMapping("/getData")
	public ResponseEntity<?> getPriceByBrandAndProductAndActiveInRequestDate(@RequestBody PriceRequestDto request) {
		PriceDto dto = priceService.findPriceByBrandIdAndProductIdDuringRequestDate(request.getBrandId(), request.getProductId(), request.getRequestDate());
		return new ResponseEntity<PriceDto>(dto, HttpStatus.OK);
	}

}
