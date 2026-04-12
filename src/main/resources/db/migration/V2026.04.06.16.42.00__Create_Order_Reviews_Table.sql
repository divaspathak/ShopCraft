Create Table reviews(
    id BIGINT PRIMARY KEY, 
    comment VARCHAR(255), 
    rating INTEGER, 
    order_id BIGINT NOT NULL, 
    product_id BIGINT NOT NULL, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id), 
    FOREIGN KEY (product_id) REFERENCES products(id)
)