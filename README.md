# Hundir la flota
He creado este juego a modo de práctica para estudiar para el examen de programación de mañana. Os dejo las directrices, recordad que si no os queda claro algo puedo cambiarlas y orientaros en ello.

## Directrices:
```
constante TAM_TABLERO que define el tamaño del tablero

String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

variable entera xBarco
variable entera yBarco

variable entera xBarcoHundido
variable entera yBarcoHundido

variable entera xUltimoMisil
variable entera yUltimoMisil


función estática generaCoordenadas() que genere unas coordenadas aleatorias para un barco (no pueden ser las mismas que las del barco undido en el turno anterior)

función lanzarMisil(x, y) que compruebe si en esas coordenadas hay un barco.
	en caso de no acertar devolverá -1 y guardará las coordenadas del misil
	en caso de acertar devolverá 0 y guardará las coordenadas del barco hundido
	y en caso de salirse del tablero devolverá -2

	
el tablero se generará en la función pintaTablero() y será así:
	1	2	3	4	5	6	7	8	9	10
A
B
C
D	H			M
E
F
G
H
I
J

El eje donde están los números es el eje X y el eje donde están las letras es el eje y.
* el tamaño del tablero podría modificarse de 1 a veinitisiete, abarcando todo el alfabeto en el eje y*
ABCDEFGHIJKLMNÑOPQRSTUVWXYZ

TEN EN CUENTA QUE PUEDES TENER EL ULTIMO MISIL LANZADO Y EL ULTIMO BARCO HUNDIDO EN LA MISMA FILA.

La H es un barco hundido de la anterior ronda y la M el ultimo misil lanzado

MAIN
deberás preguntar al usuario cuantas rondas quiere jugar, en caso de que meta una cadena o algun dato incorrecto debera de terminar el programa

deberás de generar las coordenadas del barco a hundir

deberás de ingeniartelas para que el jugador juegue el numero de rondas especificado anteriormente.
Una ronda se especifica como ese periodo de tiempo en el que lanzas misiles contra distintos cuadrantes hasta que hundes un barco, al undirlo se acaba la ronda y empezará la siguiente.

En una ronda:
	deberás pintar el tablero
	preguntar el cuadrante a donde va dirigido el misil
	deberás de convertir el string donde se guardan las coordenadas a numeros
	tip: pasa la letra a mayusculas, luego a char y restale 64 (ya que la a en ASCII es 65)
	tip2: para el numero de la coordenada recoge la cadena de caracteres a partir del primer caracter (porque es la letra), puedes hacer esto con cadena.substring(nCaracter) y luego puedes pasarlo a Integer.parseInt() para que te devuelva un numero
	
	cada vez que se derribe un barco deberá aparecer un mensaje por consola indicando que se ha derribado y la coordenada.
	al final de todas las rondas deberá de aparecer un mensaje de enhorabuena
```