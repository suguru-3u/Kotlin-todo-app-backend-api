CREATE TABLE IF NOT EXISTS todo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category ENUM('NORMAL', 'IMPORTANT', 'EMERGENCY') NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);