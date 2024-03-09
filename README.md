## API Rest con Java Springboot y JPA

Simple api rest con springboot siguiendo arquitectura DDD.

* Manejo de Mappers con [MapStruct]
* Manejo de excepciones y global handler exceptions
* Inyección de dependencias
* Mapeo básico de entidades con JPA
* Uso de Data Transfer Objects y @Valid annotation

#### Endpoints:

    - [POST] createUser   ---> /api/users/
    - [GET] getUserById   ---> /api/users/{id} 
    - [GET] getAllUsers   ---> /api/users/all
    - [PUT] updateUser    ---> /api/users/{id}

