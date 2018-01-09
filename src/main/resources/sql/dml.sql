-- product
insert into product (name, price, is_deleted) 
values 
('pentol',20000,'N'),
('korek',10000,'N'),
('gerobak',1500000,'N'),
('hape',700000,'N');

-- order
insert into product_order (customer_name, invoice_no, create_order)
values
('Jo',100001,'2018-01-07'),
('Zuko',100002,'2018-01-01'),
('Aang',100003,'2018-12-25');

-- order
insert into product_order (customer_name, invoice_no, create_order)
values
('Jo',100001,'2018-01-07'),
('Zuko',100002,'2018-01-01'),
('Aang',100003,'2018-12-25');

