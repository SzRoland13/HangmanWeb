-- Drop user first if they exist
DROP USER if exists 'hangmanWeb'@'%' ;

-- Now create user with prop privileges
CREATE USER 'hangmanWeb'@'%' IDENTIFIED BY 'hangman1234asd';

GRANT ALL PRIVILEGES ON * . * TO 'hangmanWeb'@'%';