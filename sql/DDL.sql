CREATE TABLE stores (
    store_id NUMBER
        CONSTRAINT store_id_pk PRIMARY KEY ,
    store_name VARCHAR ( 255 )
        CONSTRAINT store_name_nn NOT NULL ,
    store_addr VARCHAR ( 255 ),
    store_size NUMBER , -- 매장 크기
    store_type NUMBER ( 2 ) -- 매장 타입
);

CREATE TABLE employees (
    emp_id NUMBER
        CONSTRAINT emp_id_pk PRIMARY KEY ,
    emp_name VARCHAR ( 30 )
        CONSTRAINT emp_name_nn NOT NULL ,
    emp_birth CHAR ( 8 ), -- YYYYMMDD, 생년월일
    emp_rank NUMBER ( 2 ) DEFAULT 0 , -- 0 : 일반직원 / 1 : 매니저 / 2 : ??
    emp_nick VARCHAR ( 30 ),
    join_date DATE DEFAULT sysdate ,
    certif_expire_date CHAR ( 8 ), -- YYYYMMDD, 보건증 만료일자
    store_id NUMBER
        CONSTRAINT emp_store_fk REFERENCES stores (store_id)
);

CREATE TABLE members (
    mem_id NUMBER
        CONSTRAINT mem_id_pk PRIMARY KEY ,
    mem_name VARCHAR ( 30 )
        CONSTRAINT mem_name_nn NOT NULL ,
    mem_birth CHAR ( 8 ), -- YYYYMMDD, 생년월일
    mem_email VARCHAR ( 100 ), -- UNIQUE?
    mem_nick VARCHAR ( 30 )
);

CREATE TABLE menus (
    menu_id NUMBER
        CONSTRAINT menu_id_pk PRIMARY KEY ,
    menu_name VARCHAR ( 100 )
        CONSTRAINT menu_name_nn NOT NULL ,
    menu_cost NUMBER ( 8 )
        CONSTRAINT menu_cost_nn NOT NULL ,
    menu_calorie NUMBER ( 4 ),
    menu_category VARCHAR ( 30 ),
    menu_expired_day NUMBER ( 3 ),
    menu_is_valid CHAR ( 1 ) DEFAULT 'Y' , -- 판매가능여부 : N or Y
    menu_raw_cost NUMBER ( 8 ),
    menu_img VARCHAR ( 255 ) -- 메뉴 이미지 경로
);

CREATE TABLE stocks (
    stock_id NUMBER
        CONSTRAINT stock_id_pk PRIMARY KEY ,
    menu_id NUMBER
        CONSTRAINT stock_menu_fk REFERENCES menus(menu_id),
    store_id NUMBER
        CONSTRAINT stock_store_fk REFERENCES stores(store_id),
    amount NUMBER ( 8 )
        CONSTRAINT stock_amount_nn NOT NULL ,
    in_date DATE DEFAULT sysdate ,
    maker VARCHAR ( 100 )
);

CREATE TABLE orders (
    order_id NUMBER
        CONSTRAINT order_id_pk PRIMARY KEY ,
    store_id NUMBER
        CONSTRAINT order_store_fk REFERENCES stores(store_id),
    order_date DATE DEFAULT sysdate
);

CREATE TABLE orders_detail (
    order_id NUMBER
        CONSTRAINT od_order_fk REFERENCES orders(order_id),
    menu_id NUMBER
        CONSTRAINT od_menu_fk REFERENCES menus(menu_id),
        CONSTRAINT od_com_pk PRIMARY KEY (order_id, menu_id),
    menu_count NUMBER ( 4 )
        CONSTRAINT od_count_nn NOT NULL ,
    discounted_cost NUMBER ( 8 )
        CONSTRAINT od_cost_nn NOT NULL
);

CREATE SEQUENCE store_seq START WITH 1 NOCACHE;

CREATE SEQUENCE emp_seq NOCACHE;

CREATE SEQUENCE mem_seq NOCACHE;

CREATE SEQUENCE menu_seq NOCACHE;

CREATE SEQUENCE stock_seq NOCACHE;

CREATE SEQUENCE order_seq NOCACHE;

