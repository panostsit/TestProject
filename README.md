This is the Test Project for QUALCO!

The project was built with maven.

The backend was developed with Spring Boot in java 8. It consists of 2 modules, Contracts and Dossier. The Contracts module holds the DTOs that are used in the backend.
The Dossier module holds the actual backend logic and it's a pretty basic web service application. Hexagonal architecture was used for the structure of the Dossier module.

Some core dependencies used for the backend are:

* Mapstruct - used for the mapping between the domain and DTO objects
* Lombok - used to avoid boilerplate code (getters/setters/equals/toString/hash/builders)
* MyBatis - used for the connectivity with the database
* MariaDB driver - required for connecting with MariaDB
* Spring boot starters - Used for quickly bootstraping and configuring the project

The frontend was developed with Angular 20. For the styling, the Angular Materials library was used.

There is also a [docker-compose](./docker-compose/docker-compose.yml) file to quickly setup and test the application (it includes a service for the frontend, a service for the backend and a service for the MariaDB);

The basic functionality follows:

    When visiting the frontend address (localhost:4200) there is only a Menu button on the top left corner of the screen. Upon clicking it the use has 3 options to choose from.
    Picking one, will redirect the user to the corresponding page, where a REST call will be made to the backend in order to fetch the necessary data from the given database tables. 
    The 3 options are:
    
    - A table with a list of all the countries from the corresponding table,
    - A table with a list of all the countries along with extra data regarding their gdp and population and the year for hich the gdp per population ration was the maximum,
    - A paginated table with a list of all the regions and other information provided by the corresponding tables

    (Regarding the first option the user also has the option to click on the country name to navigate to a new page where he can see a list with all spoken languges for the country.)

    