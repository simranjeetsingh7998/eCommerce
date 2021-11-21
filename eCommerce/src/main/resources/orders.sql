use ecommerce;

CREATE TABLE customer(
	id int NOT NULL AUTO_INCREMENT,
	first_name varchar(255) DEFAULT NULL,
	last_name varchar(255) DEFAULT NULL,
	email varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1;

CREATE TABLE address(
	id int NOT NULL AUTO_INCREMENT,
    city varchar(255) DEFAULT NULL,
	country varchar(255) DEFAULT NULL,
	state varchar(255) DEFAULT NULL,
	street varchar(255) DEFAULT NULL,
	zip_code varchar(255) DEFAULT NULL,
	PRIMARY KEY (id)
) AUTO_INCREMENT=1;

CREATE TABLE orders(
	id int NOT NULL AUTO_INCREMENT,
    order_tracking_number varchar(255) DEFAULT NULL,
	total_price decimal(19,2) DEFAULT NULL,
	total_quantity int DEFAULT NULL,
	billing_address_id int DEFAULT NULL,
	customer_id int DEFAULT NULL,
	shipping_address_id int DEFAULT NULL,
	status varchar(128) DEFAULT NULL,
	date_created datetime(6) DEFAULT NULL,
	last_updated datetime(6) DEFAULT NULL,
	PRIMARY KEY (id),
    UNIQUE KEY UK_billing_address_id (billing_address_id),
	UNIQUE KEY UK_shipping_address_id (shipping_address_id),
	CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
	CONSTRAINT FK_billing_address_id FOREIGN KEY (billing_address_id) REFERENCES address (id),
	CONSTRAINT FK_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES address (id)
) AUTO_INCREMENT=1;

CREATE TABLE order_item(
	id int NOT NULL AUTO_INCREMENT,
	image_url varchar(255) DEFAULT NULL,
	quantity int DEFAULT NULL,
	unit_price decimal(19,2) DEFAULT NULL,
	order_id int DEFAULT NULL,
	product_id int DEFAULT NULL,
	PRIMARY KEY (id),
    CONSTRAINT FK_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
	CONSTRAINT FK_product_id FOREIGN KEY (product_id) REFERENCES product (id)
)  AUTO_INCREMENT = 1;
