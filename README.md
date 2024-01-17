************************************
ACERCA DEL AUTOR
************************************

David M.

elarreglador@protonmail.cocm

https://github.com/elarreglador


************************************
ACERCA DE LA APLICACION
************************************

Cliente y servidor que se comunicarán mediante sockets:

El cliente pedirá por teclado y enviará al servidor el nombre.

A continuación, el servidor enviará al cliente preguntas, que las tomará del archivo «PreguntasRespuestas.txt».

Cada vez que el cliente reciba la pregunta, la mostrará por pantalla y tomará del teclado la respuesta del usuario, enviándola al servidor.

Será el servidor el que evaluará si la respuesta es correcta o no, en función de la respuesta almacenada en el archivo. Cada respuesta correcta, se le sumará un punto al usuario.

Por último, cuando el servidor haya evaluado todas las preguntas del archivo, el servidor enviará al cliente la puntuación y el cliente la mostrará.

El servidor guardará el nombre y la puntuación en el archivo «Puntuaciones.txt».

Podemos modificar el número de preguntas del archivo.

El servidor acepta múltiples conexiones (TCP multihilo).


************************************
LANZAR LA APP 
************************************

Esta aplicacion requiere tener java instalado

Iniciamos el servidor:
<pre>
javac Servidor.java 
java Servidor
</pre>

Iniciamos el cliente:
<pre>
javac Cliente.java
java Cliente
</pre>

Obtendremos algo similar a esto por el lado del cliente:

Introduce tu nombre: Luis
Que extension tienen los documentos de Microsoft Word?
.java
Como se denomina el ordenador donde se encuentran las paginas web?
servidor
Que es Google?
buscador
En binario como se escribe 10?
10001
La IP 192.168.25.25 es publica o privada?
privada
Puntuacion de Luis: 3


                                                                                David M.
                                                                 11 de diciembre de 2023


