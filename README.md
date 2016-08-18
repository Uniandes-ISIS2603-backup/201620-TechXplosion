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
    "nombre" : 'Central'       /* Tipo String */
    "id" : 542382304,    		   /* Tipo Long */

}
 ```

Listas:


 ```javascript
[ 
  	{
   	 "nombre" : 'Central'       /* Tipo String */
        "id" : 542382304	    /* Tipo Long */
	},
	{
   	 "nombre" : 'Nacional'       /* Tipo String */
         "id" : 54245,    		   /* Tipo Long */
	}
]
```

###Servicios REST
La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/bibliotecas|Lista las bibliotecas (READ)|||Colección de bibliotecas
**GET**|/bibliotecas/*:id*|Obtener los atributos de una instancia de Biblioteca(READ)|**@PathParam id**: Número de id de la biblioteca a consultar||Atributos de la instancia de Biblioteca
**POST**|/bibliotecas|Crear una nueva instancia de la entidad Biblioteca (CREATE)||Atributos de la instancia de biblioteca a crear|Instancia de Biblioteca creada, incluyendo su id
**PUT**|/bibliotecas/*:id*|Actualiza una instancia de la entidad  biblioteca (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de  biblioteca|Instancia de  biblioteca actualizada
**DELETE**|/bibliotecas/*:id*|Borra instancia de  biblioteca en el servidor (DELETE)|**@PathParam id**: Identificador del registro||

 ##Clase Blog
 Objetos:
  ```javascript
 {
    "nombre" : 'Blog 1'       /* Tipo String */
    "id" : 542382304,    		   /* Tipo Long */
    "descripcion" : 'desc1'       /* Tipo String */

}
 ```

Listas:


 ```javascript
[ 
  	{
   	"nombre" : 'Blog 1'       /* Tipo String */
    "id" : 542382304,    		   /* Tipo Long */
    "descripcion" : 'desc1'       /* Tipo String */
	},
	{
   	 "nombre" : 'Blog 2'       /* Tipo String */
    "id" : 542382303,    		   /* Tipo Long */
    "descripcion" : 'desc2'       /* Tipo String */
	}
]
```
###Servicios REST
La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/blogs|Lista los blogs (READ)|||Colección de blogs
**GET**|/blogs/*:id*|Obtener los atributos de una instancia de Blog(READ)|**@PathParam id**: Número de id del blog a consultar||Atributos de la instancia de Blog
**POST**|/blogs|Crear una nueva instancia de la entidad Blog (CREATE)||Atributos de la instancia de blog a crear|Instancia de Blog creada, incluyendo su id
**PUT**|/blogs/*:id*|Actualiza una instancia de la entidad  blog (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de  blogs|Instancia de  blog actualizada
**DELETE**|/blogs/*:id*|Borra instancia de  blogs en el servidor (DELETE)|**@PathParam id**: Identificador del registro||
 ##Clase MedioPago
  Objetos:
  ```javascript
 {
    "tipo" : 'credito'       /* Tipo String */
    "id" : 542382304,    		   /* Tipo Long */
    "numero" : 300      /* Tipo int */
    "numeroSeguro" : 300      /* Tipo int */

}
 ```

Listas:


 ```javascript
[ 
  	{
   	"tipo" : 'credito'       /* Tipo String */
    "id" : 542382304,    		   /* Tipo Long */
    "numero" : 300      /* Tipo int */
    "numeroSeguro" : 300      /* Tipo int */
	},
	{
   	 "tipo" : 'debito'       /* Tipo String */
    "id" : 542382305,    		   /* Tipo Long */
    "numero" : 301     /* Tipo int */
    "numeroSeguro" : 302      /* Tipo int */
	}
]
```
###Servicios REST
La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/medioPagos|Lista los medios de pago (READ)|||Colección de medios de pago
**GET**|/medioPagos/*:id*|Obtener los atributos de una instancia de medioPago(READ)|**@PathParam id**: Número de id del medioPago a consultar||Atributos de la instancia de Blog
**POST**|/medioPagos|Crear una nueva instancia de la entidad medioPago (CREATE)||Atributos de la instancia de medioPago a crear|Instancia de medioPago creada, incluyendo su id
**PUT**|/medioPagos/*:id*|Actualiza una instancia de la entidad  medioPago (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de  medioPago|Instancia de  medioPago actualizada
**DELETE**|/medioPagos/*:id*|Borra instancia de  medioPago en el servidor (DELETE)|**@PathParam id**: Identificador del registro||
 
## Clase Alquileres 
 ###Servicios REST
La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/alquileres|Lista de alquileres (READ)||Lista de alquileres en formato JSON|Lista de alquileres
**GET**|/alquileres/*:id*|Obtener los atributos de una instancia de alquiler(READ)|**@PathParam id**: Número de id del alquiler a consultar|Objeto JSON de alquiler|Atributos de la instancia de alquiler
**POST**|/alquileres|Crear una nueva instancia de alquiler(CREATE)||Atributos de la instancia de alquiler a crear|Instancia de alquiler creada
**PUT**|/alquileres/*:id*|Actualiza una instancia de la clase alquiler (UPDATE)|**@PathParam id**: Identificador de la instancia de alquiler|Objeto JSON de  alquiler|Instancia de alquiler actualizada
**DELETE**|/alquileres/*:id*|Borra instancia de alquiler en el servidor (DELETE)|**@PathParam id**: Identificador de la instancia de alquiler a eliminar||
