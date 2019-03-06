CREATE TABLE category(

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	img_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
	);
	
INSERT INTO CATEGORY(name,description,img_url,is_active) values ('Rom-Com', 'This is a romantic comedy era', 'category5.png', true);