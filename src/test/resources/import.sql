/* BRANDS TABLE */
INSERT INTO brands (brand_id, name) VALUES (1, 'ZARA');

/* PRICES TABLE */
INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, 1, PARSEDATETIME('2020-06-14-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (2, 1, PARSEDATETIME('2020-06-14-15.00.00', 'yyyy-MM-dd-hh.mm.ss'), PARSEDATETIME('2020-06-14-18.30.00', 'yyyy-MM-dd-hh.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (3, 1, PARSEDATETIME('2020-06-15-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), PARSEDATETIME('2020-06-15-11.00.00', 'yyyy-MM-dd-hh.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (4, 1, PARSEDATETIME('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 4, 35455, 1, 38.95, 'EUR');