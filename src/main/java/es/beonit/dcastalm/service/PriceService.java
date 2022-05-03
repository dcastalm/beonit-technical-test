package es.beonit.dcastalm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.beonit.dcastalm.dao.IPriceDao;
import es.beonit.dcastalm.dto.PriceDto;
import es.beonit.dcastalm.entity.Price;
import es.beonit.dcastalm.mapper.PriceMapper;

@Service
public class PriceService implements IPriceService {

	@Autowired
	private IPriceDao priceDao;

	@Override
	@Transactional(readOnly=true)
	public PriceDto findPriceByBrandIdAndProductIdDuringRequestDate(Long brandId, Long productId, Date requestDate) {
		Price price = priceDao.findByBrandIdAndProductIdAndActiveInRequestDate(brandId, productId, requestDate).get(0);
		return PriceMapper.MAPPER.priceToPriceDto(price);
	}
	
}
