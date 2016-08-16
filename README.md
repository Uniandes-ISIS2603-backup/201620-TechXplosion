-# TechXplosion
 -Líder del grupo - Sergio Andrés Pardo Sánchez	sapardo10	Sección 1	sa.pardo10@uniandes.edu.co
 -
 -Juan Camilo Sánchez Rodríguez	jcsanchez16	Sección 1	jc.sanchez16@uniandes.edu.co
 -
 -Juan Sebastián Numpaque Roa	jsnumpaque10	Sección 1	js.numpaque10@uniandes.edu.co
 -
 -Juan Sebastian Sosa Florez	jssosa10	Sección 1	js.sosa10@uniandes.edu.co
 -
 -Nicolás David Muñoz Cuervo	ndmunoz10	Sección 1	nd.munoz10@uniandes.edu.co
 -
 -Juan Manuel Rodríguez Barragán	juanrodriguez32	Sección 1	jm.rodriguez11@uniandes.edu.co
 -
 
 #Documentacion del API
 
 ##Clase Biblioteca
 Objetos:
  ```javascript
 {
    "name" : 'Carlos Valderrama'       /* Tipo String */
    "cédula" : 542382304,    		   /* Tipo Long */
    "especialidad" : 'Oftalmólogo'     /* Tipo String */
    "consultorio" : 3,  			   /* Tipo Long */
}
 ```

Listas:


 ```javascript
[ 
  	{
   	 "name" : 'Carlos Valderrama'		/* Tipo String */
   	 "cédula" : 542382304,			/* Tipo Long */
   	 "especialidad" : 'Oftalmólogo'		/* Tipo String */
   	 "consultorio" : 3,			/* Tipo Long */
	},
	{
   	 "name" : 'James Rodriguez'       	/* Tipo String */
   	 "cédula" : 548393222,			/* Tipo Long */
  	 "especialidad" : 'Cardiólogo'		/* Tipo String */
  	 "consultorio" : 23,			/* Tipo Long */
	}
]
```

###Servicios REST
La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/doctors|Lista los registros de Médico (READ)|||Colección de registros de Médico 
**GET**|/doctors/*:cedula*|Obtener los atributos de una instancia de Médico (READ)|**@PathParam cédula**: Número de cédula del doctor a consultar||Atributos de la instancia de Médico
**POST**|/doctors|Crear una nueva instancia de la entidad Médico (CREATE)||Atributos de la instancia de Médico a crear|Instancia de Médico creada, incluyendo su cédula
**PUT**|/doctors/*:cedula*|Actualiza una instancia de la entidad Médico (UPDATE)|**@PathParam cédula**: Identificador del registro|Objeto JSON de Médico|Instancia de Médico actualizada
**DELETE**|/doctors/*:cedula*|Borra instancia de Médico en el servidor (DELETE)|**@PathParam cédula**: Identificador del registro||

 ##Clase Blog
 ##Clase MedioPago
 
