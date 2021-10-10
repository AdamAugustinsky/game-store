insert into cart (id) values (nextval('cart_id_seq'));

insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'super-mario-odyssey.png', 'Super Mario Odyssey', '197.88', 100);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'call-of-duty-infinite-warfare.png', 'Call Of Duty Infinite Warfare', '49.99', 80);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'the-witcher-iii-wild-hunt.png', 'The Witcher III Wild Hunt', '119.50', 250);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'call-of-duty-wwii.png', 'Call Of Duty WWII', '249.99', 205);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'mortal-kombat-xl.png', 'Mortal Kombat XL', '69.99', 150);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'shards-of-darkness.png', 'Shards of Darkness', '71.94', 400);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'terra-media-sombras-de-mordor.png', 'Terra Média: Sombras de Mordor', '79.99', 50);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'fifa-18.png', 'FIFA 18', '195.39', 325);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'horizon-zero-dawn.png', 'Horizon Zero Dawn', '115.80', 290);

insert into cart_product ("panachecart_id", "products_id") values (1, 1);
insert into cart_product ("panachecart_id", "products_id") values (1, 2);
insert into cart_product ("panachecart_id", "products_id") values (1, 3);
insert into cart_product ("panachecart_id", "products_id") values (1, 4);
insert into cart_product ("panachecart_id", "products_id") values (1, 5);
insert into cart_product ("panachecart_id", "products_id") values (1, 6);
insert into cart_product ("panachecart_id", "products_id") values (1, 7);
insert into cart_product ("panachecart_id", "products_id") values (1, 8);
insert into cart_product ("panachecart_id", "products_id") values (1, 9);


insert into cart ("id") values (nextval('cart_id_seq'));

insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'super-mario-odyssey.png', 'Super Mario Odyssey', '197.88', 100);
insert into product ("id", "image", "name", "price", "score") values (nextval('product_id_seq'), 'call-of-duty-infinite-warfare.png', 'Call Of Duty Infinite Warfare', '49.99', 80);

insert into cart_product ("panachecart_id", "products_id") values (2, 10);
insert into cart_product ("panachecart_id", "products_id") values (2, 11);