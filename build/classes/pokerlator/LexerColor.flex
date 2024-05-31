import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* funcion */
Funcion = funcion

/* letras mayuscula */
Mayus = [A-Z]

/* Palos */
Diamantes = ♦ | diamante
Corazones = ♥ | corazon
Treboles = ♣ | trebol
Picas = ♠ | pica

/* Valor cartas */
valor_carta = [2-9] | 10 | A | J | Q | K

/* Número */
Numero = 0 | [1-9][0-9]*

/* Texto */
Texto = ({Letra}|{Digito})*

%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\@{Identificador} { /*Ignorar*/ }

/* Tipos de carta y datos*/
diamantes | corazones | treboles |
picas |
numero |
texto |
bool |
mano |
funcion |
nada { return textColor(yychar, yylength(), new Color(148, 58, 173)); }

{Diamantes}{valor_carta} |
{Corazones}{valor_carta} { return textColor(yychar, yylength(), new Color(198, 40, 40)); }


{Treboles}{valor_carta} |
{Picas}{valor_carta} { return textColor(yychar, yylength(), new Color(7, 35, 122)); }

/* Número */
{Numero} { return textColor(yychar, yylength(), new Color(35, 120, 147)); }

/* Texto */
'{Texto}' { return textColor(yychar, yylength(), new Color(24, 53, 86)); }

/* Funcion */
{Funcion} { return textColor(yychar, yylength(), new Color(121, 107, 255)); }

/* Booleano */
verdadero | falso { return textColor(yychar, yylength(), new Color(176, 105, 10)); }

/* Operadores de agrupación */
"("|")"|"{"|"}"|"["|"]" { return textColor(yychar, yylength(), new Color(24, 148, 194)); }

/* Signos de puntuación */
","|
";"|
":"|
"#"|
comparar { return textColor(yychar, yylength(), new Color(24, 148, 194)); }

/* Operador de asignación */
=>|-->|-> { return textColor(yychar, yylength(), new Color(24, 148, 194)); }


/* Repetir */
repetir|
repetirMientras|
repartirPreflop|
repartirFlop|
repartirTurn|
repartirRiver|
interrumpir|
imprimir|
retorno|
si|
sino { return textColor(yychar, yylength(), new Color(121, 107, 255)); }


/* Movimientos */
fold|
check|
call|
raise { return textColor(yychar, yylength(), new Color(46, 140, 6)); }

/* Operadores lógicos */
"&" |
"|" |
"!" |
">" |
"<" { return textColor(yychar, yylength(), new Color(46, 125, 50)); }

/* Final */
Inicio { return textColor(yychar, yylength(), new Color(198, 40, 40)); }
Final { return textColor(yychar, yylength(), new Color(198, 40, 40)); }
/* Errores */
// Número erróneo
0 {Numero}+ { /* Ignorar */ }
// Identificador sin @
{Identificador} { /* Ignorar */ }
. { /* Ignorar */ }