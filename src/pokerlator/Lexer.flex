import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
/* letras mayuscula */
Mayus = [A-Z]

/* letras minuscula */
Minus = [a-z]

/* Identificador */

Identificador = {Mayus}({Letra}|{Digito})*

/* funcion */
Funcion = funcion

/* arreglo */
Arreglo = mano

/* Valor cartas */
valor_carta = [2-9] | 10 | A | J | Q | K

/* Palos */
Diamantes = ♦ | diamante
Corazones = ♥ | corazon
Treboles = ♣ | trebol
Picas = ♠ | pica

/* Número */
Numero = 0 | [1-9][0-9]*

/* Texto */
Texto = ({Letra}|{Digito}|{EspacioEnBlanco})*


%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\@{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Tipos de carta (primitivo)*/
diamantes | corazones | treboles |
picas { return token(yytext(), "TIPO_CARTA", yyline, yycolumn); }

/* Mano*/
{Arreglo} { return token(yytext(), "MANO", yyline, yycolumn); }

/* Tipos de dato */
numero |
texto |
bool { return token(yytext(), "TIPO_DATO", yyline, yycolumn); }

nada { return token(yytext(), "NADA", yyline, yycolumn); }

/* Número */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Texto */
'{Texto}' { return token(yytext(), "TEXTO", yyline, yycolumn); }

/* Boole */
verdadero | falso { return token(yytext(), "BOOLEANO", yyline, yycolumn); }

/* Funcion */
{Funcion} { return token(yytext(), "PROCESO", yyline, yycolumn); }

/* Comparar texto */
comparar { return token(yytext(), "COMPARAR", yyline, yycolumn); }

/* Cartas */
{Diamantes}{valor_carta} { return token(yytext(), "DIAMANTES", yyline, yycolumn); }
{Corazones}{valor_carta} { return token(yytext(), "CORAZONES", yyline, yycolumn); }
{Treboles}{valor_carta} { return token(yytext(), "TREBOLES", yyline, yycolumn); }
{Picas}{valor_carta} { return token(yytext(), "PICAS", yyline, yycolumn); }

/* Operadores de agrupación */
"(" { return token(yytext(), "PARENTESIS_A", yyline, yycolumn); }
")" { return token(yytext(), "PARENTESIS_C", yyline, yycolumn); }
"{" { return token(yytext(), "LLAVE_A", yyline, yycolumn); }
"}" { return token(yytext(), "LLAVE_C", yyline, yycolumn); }
"[" { return token(yytext(), "CORCHETE_A", yyline, yycolumn); }
"]" { return token(yytext(), "CORCHETE_C", yyline, yycolumn); }

/* Signos de puntuación */
"," { return token(yytext(), "COMA", yyline, yycolumn); }
";" { return token(yytext(), "PUNTO_COMA", yyline, yycolumn); }
":" { return token(yytext(), "DOS PUNTOS", yyline, yycolumn); }
"#" { return token(yytext(), "NUMERAL", yyline, yycolumn); }

/* Operador de asignación */
=> { return token (yytext(), "ASIGNACION", yyline, yycolumn); }
--> { return token (yytext(), "ASIGNACION_LAMBDA", yyline, yycolumn); }
-> { return token (yytext(), "ASIGNACION_RETORNO", yyline, yycolumn); }

/* Repartir cartas */
repartirPreflop |
repartirFlop |
repartirTurn |
repartirRiver { return token(yytext(), "REPARTIR", yyline, yycolumn); }

/* Movimientos */
fold |
check |
call |
raise |
mostrarCartas { return token(yytext(), "MOVIMIENTO", yyline, yycolumn); }

/* Repetir */
repetir |
repetirMientras { return token(yytext(), "REPETIR", yyline, yycolumn); }

/* Detener repetir */
interrumpir { return token(yytext(), "DETENER", yyline, yycolumn); }

/* Imprimir texto */
imprimir { return token(yytext(), "IMPRIMIR", yyline, yycolumn); }

/* Retorno de funcion*/
retorno { return token(yytext(), "RETORNO", yyline, yycolumn); }

/* Estructura si */
si |
sino { return token(yytext(), "ESTRUCTURA_SI", yyline, yycolumn); }

/* Operadores lógicos */
"&" |
"|" |
"!" |
">" |
"<" { return token(yytext(), "OP_LOGICO", yyline, yycolumn); }


/* Inicio */
Inicio { return token(yytext(), "INICIO", yyline, yycolumn); }

/* Final */
Final { return token(yytext(), "FINAL", yyline, yycolumn); }

/* Errores */
// Número erróneo
0 {Numero}+ { return token(yytext(), "ERROR_1", yyline, yycolumn); }

// Identificador sin @
{Identificador} { return token(yytext(), "ERROR_2", yyline, yycolumn); }

// Funcion sin Camel case
\@({Minus}|{Numero})({Letra}|{Digito})* { return token(yytext(), "ERROR_3", yyline, yycolumn); }

{Diamantes}[^[2-9]?[J]?[Q]?[K]?[A]?] |
{Corazones}[^[2-9]?[J]?[Q]?[K]?[A]?] |
{Treboles}[^[2-9]?[J]?[Q]?[K]?[A]?] |
{Picas}[^[2-9]?[J]?[Q]?[K]?[A]?] { return token(yytext(), "ERROR_4", yyline, yycolumn); }
// Cartas no validas
. { return token(yytext(), "ERROR", yyline, yycolumn); }