CREATE TABLE IF NOT EXISTS menu_item (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    description     TEXT,
    image_url       VARCHAR(255),
    category_id     INT NOT NULL,
    subcategory_id  INT,
    number_of_reviews INT DEFAULT 0,
    average_rating  DECIMAL(2, 1) DEFAULT 0.0,
    created_at      DATE NOT NULL,
    created_by      VARCHAR(20) NOT NULL,
    updated_at      DATE DEFAULT NULL,
    updated_by      VARCHAR(20) DEFAULT NULL
);
