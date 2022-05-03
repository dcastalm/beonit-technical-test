package es.beonit.dcastalm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import es.beonit.dcastalm.dto.PriceDto;
import es.beonit.dcastalm.entity.Price;

@Mapper
public interface PriceMapper {

	PriceMapper MAPPER = Mappers.getMapper(PriceMapper.class);
	
	@Mappings({
		@Mapping(target = "brandId", source = "brand.id"),
		@Mapping(target = "curr", source = "currency")
	})
	PriceDto priceToPriceDto(Price price);
}
