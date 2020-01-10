-- Include table data insertion, updation, deletion and select scripts
--------------------------------------------------------------------------
----------- Adding MenuItem to Admin from MenuItem Table------------------
--------------------------------------------------------------------------
INSERT INTO menu_item VALUES
(1, 'Sandwitch', 99.0, 'Yes', '2017-03-15','Main Course','Yes'),

(2, 'Burger', 129.0,'Yes','2017-12-23', 'MainCourse','No'),

(3, 'Pizza', 149.0,'Yes','2018-12-21', 'MainCourse','No'),

(4, 'French Fries', 57.0,'No','2017-07-02', 'Starters','Yes'),

(5, 'Chocolate Browine', 32.0, 'Yes','2017-11-02','Dessert','Yes');

----------------------- show MenuItem detials-----------------------------
select * from menu_item;

-------------- show MenuItem detials before Updating of Id:1--------------
select 
 me_name,
 me_price,
 me_active,
 me_date_of_launch,
 me_category,
 me_free_delivery 
 from menu_item 
 where me_id=1;

--------------------------  Update MenuItems detials of Id:1---------------------
update menu_item set
 me_name='Veg Roll',
 me_price=60.0,
 me_date_of_launch='2018-07-28',
 me_category='Starters'
 where me_id=1;
 
 -------------- show MenuItem detials after updating of Id:1 --------------------
select 
 me_name,
 me_price,
 me_active,
 me_date_of_launch,
 me_category,
 me_free_delivery
 from menu_item 
 where me_id=1;
--------------------------------------------------------------------------


--------------------------------------------------------------------------
-------------------- Showing Customer Detials ----------------------------
--------------------------------------------------------------------------
select
 m.me_name,
 m.me_free_delivery,
 m.me_price,
 m.me_category 
 from menu_item m join cart c 
 on m.me_id=c.ct_pr_id;

--------------------------------------------------------------------------
----------- Showing Customer Total Price  --------------------------------
--------------------------------------------------------------------------
select
 sum(m.me_price) Total
 from menu_item m join cart c 
 on m.me_id=c.ct_pr_id;

---------------------------------------------------------------------------


--------------------------------------------------------------------------
-------------------- Adding Cart Detials in Cart Table--------------------
--------------------------------------------------------------------------
INSERT INTO cart VALUES
(1,1,1),

(2,1,2),

(3,1,3);

(4,1,4);

-------------------------- show cart Detials-------------------------------
select * from cart;

-------------------------- Delete cart Detials-----------------------------
delete from cart 
 where ct_us_id=1 
 and ct_pr_id=2;

-------------------- show cart Detials after deleting----------------------
select * from cart;
---------------------------------------------------------------------------



--------------------------------------------------------------------------
-------------------- Adding User Detials in User Table--------------------
--------------------------------------------------------------------------
INSERT INTO user VALUES
(1,'Jon Snow'),

(2,'Jack Sparrow'),

(3,'John Cena'),

(4,'Jon Snow');

-------------------------- show User detials-------------------------------
select * from user;

----------------- Delete user Detials of Same user name--------------------
delete from user where us_name='Jon Snow' limit 1;

-------------------- show user Detials after deleting----------------------
select * from user;
---------------------------------------------------------------------------