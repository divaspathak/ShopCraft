Create Table order_reviews(
    id BIGINT PRIMARY KEY, 
    comments VARCHAR(255), 
    rating INTEGER, 
    order_id BIGINT, 
    product_id BIGINT, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(id), 
    FOREIGN KEY (product_id) REFERENCES products(id)
)