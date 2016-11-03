
# Requisitos Taller-microservicios:
  
  GIT
  
  JDK 1.8
  
  maven 3
  
  eclipse u otro IDE

# Bajarse el código de la siguiente URL

  git clone https://github.com/CoP-Kata16/Taller-microservicios.git

# Compilacion de todo el modulo

    mvn eclipse:clean eclipse:eclipse clean install

# Importacion de todos los proyectos en eclipse

  Equipo1:
    
    Completar microservicio crearNotificacion
    
  Equipo2:
  
    Completar microservicio configuracionUsuarios
    
  Equipo3:
  
    Completar servicio eurekaServer
   
  Equipo4:
  
    Completar balanceador de cliente ribbonbalancer
  
  Equipo5:
  
    Completar configuracion de zuul
    
# Notas:

	URL dashboard

		http://localhost:8082/hystrix (puerto del crearNotificacion)
	
	URL a monitorizar:
	
		http://localhost:8082/hystrix.stream
		
	Turbine (agrega informacion de todas las intanciaciones de una aplicación en un cluster):
	
		https://github.com/spring-cloud-samples/turbine
		
		http://www.java-allandsundry.com/2016/01/spring-cloud-with-turbine.html
		
  
  

