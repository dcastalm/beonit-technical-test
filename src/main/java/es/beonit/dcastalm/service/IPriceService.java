package es.beonit.dcastalm.service;

import java.util.Date;

import es.beonit.dcastalm.dto.PriceDto;

public interface IPriceService {

	public PriceDto findPriceByBrandIdAndProductIdDuringRequestDate(Long brandId, Long productId, Date requestDate);
}
