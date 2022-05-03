package es.beonit.dcastalm.functionaltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.beonit.dcastalm.controller.PriceController;
import es.beonit.dcastalm.dto.PriceRequestDto;
import es.beonit.dcastalm.entity.Brand;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class TechnicalTest {
	
	private Calendar requestDate;
	private Long productId;
	private Brand brand;
	private PriceRequestDto request;
	
	@Autowired
	private PriceController priceController;
	
	@BeforeEach
	public void init() {
		requestDate = new GregorianCalendar();
		productId = 35455L;
		brand = new Brand();
		brand.setId(1L);
		brand.setName("ZARA");
		request = new PriceRequestDto();
		request.setBrandId(brand.getId());
		request.setProductId(productId);
		request.setRequestDate(requestDate.getTime());
	}

	@Test
	public void test1() throws ParseException {
		requestDate.set(2020, 05, 14, 10, 0, 0);
		request.setRequestDate(requestDate.getTime());
		
		String strExpected = "<200 OK OK,PriceDto(brandId=1, startDate=2020-06-14 00:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=1, productId=35455, priority=0, price=35.5, curr=EUR),[]>";
		
		assertEquals(strExpected, priceController.getPriceByBrandAndProductAndActiveInRequestDate(request).toString());
	}
	
	@Test
	public void test2() {
		requestDate.set(2020, 05, 14, 16, 0, 0);
		request.setRequestDate(requestDate.getTime());
		
		String strExpected = "<200 OK OK,PriceDto(brandId=1, startDate=2020-06-14 15:00:00.0, endDate=2020-06-14 18:30:00.0, priceList=2, productId=35455, priority=1, price=25.45, curr=EUR),[]>";
		
		assertEquals(strExpected, priceController.getPriceByBrandAndProductAndActiveInRequestDate(request).toString());
	}
	
	@Test
	public void test3() {
		requestDate.set(2020, 05, 14, 21, 0, 0);
		request.setRequestDate(requestDate.getTime());
		
		String strExpected = "<200 OK OK,PriceDto(brandId=1, startDate=2020-06-14 00:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=1, productId=35455, priority=0, price=35.5, curr=EUR),[]>";
		
		assertEquals(strExpected, priceController.getPriceByBrandAndProductAndActiveInRequestDate(request).toString());
	}
	
	@Test
	public void test4() {
		requestDate.set(2020, 05, 15, 10, 0, 0);
		request.setRequestDate(requestDate.getTime());
		
		String strExpected = "<200 OK OK,PriceDto(brandId=1, startDate=2020-06-15 00:00:00.0, endDate=2020-06-15 11:00:00.0, priceList=3, productId=35455, priority=1, price=30.5, curr=EUR),[]>";
		
		assertEquals(strExpected, priceController.getPriceByBrandAndProductAndActiveInRequestDate(request).toString());
	}
	
	@Test
	public void test5() {
		requestDate.set(2020, 05, 16, 21, 0, 0);
		request.setRequestDate(requestDate.getTime());
		
		String strExpected = "<200 OK OK,PriceDto(brandId=1, startDate=2020-06-15 16:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=4, productId=35455, priority=1, price=38.95, curr=EUR),[]>";
		
		assertEquals(strExpected, priceController.getPriceByBrandAndProductAndActiveInRequestDate(request).toString());
	}
}
