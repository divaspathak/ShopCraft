Create Table orders(
    id BIGINT PRIMARY KEY, 
    status INTEGER, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    deleted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
); 

Create Table order_products(
    id BIGINT PRIMARY KEY, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    deleted_at TIMESTAMP NULL DEFAULT NULL, 
    order_id BIGINT,
    product_id BIGINT,
    quantity BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders(id), 
    FOREIGN KEY (product_id) REFERENCES products(id)
); 