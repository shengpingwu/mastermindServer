# mastermindServer
A mastermind Rest API Server


El servidor mastermindServer esta implementado con el framework Spring Boot + JPA + H2. 

El servidor proporciona tres endpoint para comunicarse. Son: 

- http://hostname:port/v1/mastermind, admite petición GET para crear una partida. 
- http://hostname:port/v1/mastermind/{id}, este endpoint proporciona a través de una petición POST con las fichas a verificar del jugador. El formato que admite es un json de la siguiente forma: 
[
    {
        "value": 0
    },
    {
        "value": 3
    },
    {
        "value": 3
    },
    {
        "value": 1
    }
]

  El "0" representa el color Rojo.
  El "1" representa el color Azul.
  El "2" representa el color Verde.
  El "3" representa el color Amarillo.
  
  La respuesta devuelve cero (Negro), uno (Blanco). Informa la terminación de la partida si toda la respuesta son ceros.
  
- http://hostname:port/v1/mastermind/{id}/historic, proporciona a través de una petición GET el historico de la partida. 

El proyecto esta realizado con la herramienta de Spring Tool Suite con Maven para compilar, empaquetar. Genera un jar que si queremos ejecutar solo hay que invocar el siguiente comando: 

    java -jar jarGeneretared.jar
