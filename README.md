#Medical Application

1. Download the code from github https://github.com/AlineSophia/PatientManagement/
2. Open application.properties file and add the or change the database name
3. Insert few queries to add in the doctor details

INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('101', 'Tomas', 'Livi', '9884583738', 'Ortho');
INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('102', 'John', 'Jacob', '9343556738', 'Neuro');
INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('103', 'Ryan', 'Chris', '9884566648', 'General');
INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('104', 'Felix', 'Joseph', '9455677738', 'ENT');
INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('105', 'David', 'Antony', '9834456788', 'Cardio');
INSERT INTO `management`.`doctor` (`id`, `first_name`, `last_name`, `phone_number`, `speciality`) VALUES ('106', 'Nirmala', 'Ravi', '9544354738', 'Gyno');

4. Run the project as a sprinboot application
5. In the browser type "localhost:8080"
6. The application is now up, you can register a new user and access the application
