Create Table Product(
    id PRIMARY SERIAL KEY, 
    name VARCHAR(255), 
    description VARCHAR(255), 
    image VARCHAR(255), 
    rating number, 
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    deleted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)