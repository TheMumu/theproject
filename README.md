# theproject

1. first clone the project in the directory of your choice : git clone https://github.com/TheMumu/theproject.git

2. Build Frontend : in theproject/theproject-frontend directory run “npm install” then run “grunt”
(If you want to avoid running “grunt” everytime you make a fronted change to see the modification, run “grunt watch”, it will publish your modification immediately when you make a change)

3. Build backend : in the project/theproject-backend directory run “mvn clean package”

4. then start the application by running "mvn spring-boot:run -Dspring.profiles.active=local”

5. In your browser go to http://localhost:8080/

profit
