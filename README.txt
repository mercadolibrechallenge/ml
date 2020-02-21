Se desplego en el servidor Heroku y se utilizo una base de datos en memoria H2.

1) Para Nivel 2 
Ejecutar el metodo POST en la siguiente url: https://ml-app-challenge.herokuapp.com/mutant

//Ejemplos de body 
//No es mutante
{
"dna":["TTGCGA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"]
}

Response -> 403 (Forbidden)

//Es mutante
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Response-> 200 (ok)

2) Para Nivel 3
Ejecutar el metodo GET en la siguiente url: https://ml-app-challenge.herokuapp.com/stats
Luego de ejecutar el punto 1) y se ejecuta la url de estadistica el resultado esperado es el siguiente:

Response
{
    "count_mutant_dna": 1,
    "count_human_dna": 1,
    "ratio": 0.5
}