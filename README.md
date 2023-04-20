# Taller02POO

Integrantes:

-Enzo Loren

-Juan Paiva

Primero, vamos a inicializar una matriz que represente las habitaciones del hotel. La matriz tendrá 10 filas (una por cada habitación) y 3 columnas. La primera columna almacenará el estado de la habitación (0 para disponible, 1 para ocupada y 2 para reservada), la segunda columna indicará si se incluyen comidas (0 para sin comidas, 1 para con comidas) y la tercera columna almacenará la cantidad de días de estadía.

Luego, mostraremos un menú de opciones al administrador, que le permitirá realizar diversas acciones como consultar el estado de las habitaciones, reservar una habitación, ocupar una habitación, liberar una habitación o reiniciar el hotel.

Cuando el administrador elija una opción, el sistema ejecutará la acción correspondiente. Por ejemplo, si elige reservar una habitación, el sistema cambiará el estado de la habitación a "reservada" y preguntará si se incluirán comidas y por cuántos días se reservará. Similarmente, si elige ocupar una habitación, el sistema cambiará el estado de la habitación a "ocupada", y preguntará si se incluirán comidas y por cuántos días se ocupará.

Si el administrador decide liberar una habitación, el sistema calculará el total a cancelar, teniendo en cuenta la cantidad de días de estadía y si se incluyeron comidas, luego imprimirá una boleta con estos detalles. Después, la habitación quedará en estado "disponible".

Si el administrador desea reiniciar el hotel, el sistema solicitará la confirmación de la clave "1234" antes de cambiar todas las habitaciones a estado "disponible".

El sistema seguirá ejecutándose hasta que el administrador decida salir.
