Create Table products(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255), 
    description VARCHAR(255), 
    image VARCHAR(255), 
    rating number, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    deleted_at TIMESTAMP CURRENT_TIMESTAMP, 
    FOREIGN KEY (category_id) REFERENCES categories(id)
)