Create Table products(
    id BIGINT PRIMARY KEY, 
    title VARCHAR(255), 
    description VARCHAR(255), 
    image VARCHAR(255), 
    rating NUMERIC, 
    quantity BIGINT, 
    category_id BIGINT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    deleted_at TIMESTAMP NULL DEFAULT NULL, 
    FOREIGN KEY (category_id) REFERENCES categories(id)
); 