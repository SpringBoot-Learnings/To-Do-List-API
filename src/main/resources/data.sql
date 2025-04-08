DELETE FROM todos;
ALTER TABLE todos AUTO_INCREMENT = 1;
INSERT INTO todos (title, description, completed) VALUES 
('Learn Spring Boot', 'Understand the basics of Spring Boot and REST APIs', true),
('Setup MySQL DB', 'Install and configure MySQL with Spring Boot', false),
('Create To-Do API', 'Build CRUD endpoints for the to-do app', true),
('Test with Postman', 'Send requests and verify results', false),
('Deploy on GitHub', 'Push code to GitHub for portfolio', false);
