package lexer;
import java_cup.runtime.Symbol;

%%
%class Cup_Flex
%type java_cup.runtime.Symbol
%unicode 9.0
%line
%column
%cup
Letra = [a-zA-Z]+
LetraUnder =  [a-zA-Z_]+
Digit = 0|[1-9][0-9]*
Identifier = {Letra}({LetraUnder}|{Digit})*
Decimal =["-"]?[0-9]+["."][0-9]*
Int = ["-"]?[1-9]*[0-9]+
Exp = ([0-9]+["."][0-9]*["E"|"e"]["+"|"-"][0-9]*)|([0-9]+["."][0-9]*["E"|"e"][0-9]*)

/*Line Terminator and white spaces*/
LineTerminator = \r|\n|\r\n 
InputCharacter = [^\r\n] 
WhiteSpace = {LineTerminator} | [ \t\f]

/*Comments*/
TraditionalComment = "--" {InputCharacter}*
MultiLineComment = "/*" [^] ~"*/"| "/*" "*"+ "/"
Comment = {TraditionalComment} | {MultiLineComment}
ErrorLinea = ("/*" [^\r\n.*]*)
ErrorCadena = ("'"([^'\r\n])*)
String =("'"([^'\r\n])*"'")
Bit = 1|0|"NULL"

%{
    private Symbol symbol(int type, Object value){
    return new Symbol (type,yyline,yycolumn,value);
    }
    private Symbol symbol(int type){
    return new Symbol (type,yyline,yycolumn);
    }
    int line;
    int column;
%}

%init{
line = 0;
column = 0;
%init}

%%

    
FOR { 
        return new Symbol(sym.FOR ,yycolumn, yyline, yytext()); 
      }     
    
AS { 
        return new Symbol(sym.AS ,yycolumn, yyline, yytext()); 
      }     
    
     
FULL { 
        return new Symbol(sym.FULL ,yycolumn, yyline, yytext());  
      }     
    
    
GROUP { 
        return new Symbol(sym.GROUP ,yycolumn, yyline, yytext());  
      }
RIGHT { 
        return new Symbol(sym.RIGHT ,yycolumn, yyline, yytext());  
      }        
     
    
IN { 
        return new Symbol(sym.IN ,yycolumn, yyline, yytext());  
      }     
     
INSERT { 
        return new Symbol(sym.INSERT ,yycolumn, yyline, yytext());  
      }              
SET { 
        return new Symbol(sym.SET ,yycolumn, yyline, yytext());  
      }                 
TOP { 
        return new Symbol(sym.TOP ,yycolumn, yyline, yytext());  
      }                    
DEFAULT { 
        return new Symbol(sym.DEFAULT ,yycolumn, yyline, yytext()); 
      }         
DELETE { 
        return new Symbol(sym.DELETE ,yycolumn, yyline, yytext()); 
      }                    
UNPIVOT { 
        return new Symbol(sym.UNPIVOT ,yycolumn, yyline, yytext());  
      }              
/*DISTINCT { 
        return new Symbol(sym.DISTINCT ,yycolumn, yyline, yytext()); 
      } */                           
PERCENT { 
        return new Symbol(sym.PERCENT ,yycolumn, yyline, yytext()); 
      }       
PIVOT { 
        return new Symbol(sym.PIVOT ,yycolumn, yyline, yytext()); 
      }                       
FROM { 
        return new Symbol(sym.FROM ,yycolumn, yyline, yytext());  
      }                
GO { 
        return new Symbol(sym.GO ,yycolumn, yyline, yytext()); 
      }                             
SELECT { 
        return new Symbol(sym.SELECT ,yycolumn, yyline, yytext());  
      }   
INNER { 
        return new Symbol(sym.INNER ,yycolumn, yyline, yytext());  
      }              
INTO { 
        return new Symbol(sym.INTO ,yycolumn, yyline, yytext());  
      }         
JOIN { 
        return new Symbol(sym.JOIN ,yycolumn, yyline, yytext());  
      }       
LEFT { 
        return new Symbol(sym.LEFT ,yycolumn, yyline, yytext());  
      }     
NULL { 
        return new Symbol(sym.NULL ,yycolumn, yyline, yytext());  
      }      
VALUES { 
        return new Symbol(sym.VALUES,yycolumn, yyline, yytext());  
      }          
OUTER { 
        return new Symbol(sym.OUTER ,yycolumn, yyline, yytext()); 
      }            
OUTPUT { 
        return new Symbol(sym.OUTPUT ,yycolumn, yyline, yytext()); 
      }
UPDATE { 
        return new Symbol(sym.UPDATE ,yycolumn, yyline, yytext()); 
      }
ALL  { 
        return new Symbol(sym.ALL ,yycolumn, yyline, yytext()); 
      }          
DISTINCT  { 
        return new Symbol(sym.DISTINCT ,yycolumn, yyline, yytext()); 
      }          
AVG  { 
        return new Symbol(sym.AVG ,yycolumn, yyline, yytext()); 
      }
          
COUNT  { 
        return new Symbol(sym.COUNT ,yycolumn, yyline, yytext()); 
      }  
BY  { 
        return new Symbol(sym.BY ,yycolumn, yyline, yytext()); 
      }
DESC  { 
        return new Symbol(sym.DESC ,yycolumn, yyline, yytext()); 
      } 
ASC  { 
        return new Symbol(sym.ASC ,yycolumn, yyline, yytext()); 
      }
ORDER  { 
        return new Symbol(sym.ORDER ,yycolumn, yyline, yytext()); 
      }
WHERE  { 
        return new Symbol(sym.WHERE ,yycolumn, yyline, yytext()); 
      }
ON  { 
        return new Symbol(sym.ON ,yycolumn, yyline, yytext()); 
      }
NOT  { 
        return new Symbol(sym.NOT ,yycolumn, yyline, yytext()); 
      }
BETWEEN  { 
        return new Symbol(sym.BETWEEN ,yycolumn, yyline, yytext()); 
      }
LOOP  { 
        return new Symbol(sym.LOOP ,yycolumn, yyline, yytext()); 
      }
HASH  { 
        return new Symbol(sym.HASH ,yycolumn, yyline, yytext()); 
      }
MERGE  { 
        return new Symbol(sym.MERGE ,yycolumn, yyline, yytext()); 
      }
REMOTE  { 
        return new Symbol(sym.REMOTE ,yycolumn, yyline, yytext()); 
      }
IS  { 
        return new Symbol(sym.IS ,yycolumn, yyline, yytext()); 
      }
LIKE  { 
        return new Symbol(sym.LIKE ,yycolumn, yyline, yytext()); 
      }
AND  { 
        return new Symbol(sym.AND ,yycolumn, yyline, yytext()); 
      }
ESCAPE  { 
        return new Symbol(sym.ESCAPE ,yycolumn, yyline, yytext()); 
      }
HAVING  { 
        return new Symbol(sym.HAVING ,yycolumn, yyline, yytext()); 
      }
CONSTRAINT  { 
        return new Symbol(sym.CONSTRAINT ,yycolumn, yyline, yytext()); 
      }
IDENTITY  { 
        return new Symbol(sym.IDENTITY ,yycolumn, yyline, yytext()); 
      }
PRIMARY  { 
        return new Symbol(sym.PRIMARY ,yycolumn, yyline, yytext()); 
      }
KEY  { 
        return new Symbol(sym.KEY ,yycolumn, yyline, yytext()); 
      }
CLUSTERED  { 
        return new Symbol(sym.CLUSTERED ,yycolumn, yyline, yytext()); 
      }
NONCLUSTERED  { 
        return new Symbol(sym.NONCLUSTERED ,yycolumn, yyline, yytext()); 
      }
UNIQUE  { 
        return new Symbol(sym.UNIQUE ,yycolumn, yyline, yytext()); 
      }
FOREIGN  { 
        return new Symbol(sym.FOREIGN ,yycolumn, yyline, yytext()); 
      }
REFERENCES  { 
        return new Symbol(sym.REFERENCES ,yycolumn, yyline, yytext()); 
      }
 CHECK  { 
        return new Symbol(sym.CHECK ,yycolumn, yyline, yytext()); 
      }
 REPLICATION  { 
        return new Symbol(sym.REPLICATION ,yycolumn, yyline, yytext()); 
      }
 INDEX   { 
        return new Symbol(sym.INDEX  ,yycolumn, yyline, yytext()); 
      }
 ACTION    { 
        return new Symbol(sym.ACTION   ,yycolumn, yyline, yytext()); 
      }      
 DATABASE    { 
        return new Symbol(sym.DATABASE   ,yycolumn, yyline, yytext()); 
      }      
 NAME    { 
        return new Symbol(sym.NAME   ,yycolumn, yyline, yytext()); 
      }
 NAMES    { 
        return new Symbol(sym.NAMES   ,yycolumn, yyline, yytext()); 
      }      
  COLLATE    { 
        return new Symbol(sym.COLLATE   ,yycolumn, yyline, yytext()); 
      }         
  FILE    { 
        return new Symbol(sym.FILE   ,yycolumn, yyline, yytext()); 
      }
  SIZE    { 
        return new Symbol(sym.SIZE   ,yycolumn, yyline, yytext()); 
      }
  INCLUDE    { 
        return new Symbol(sym.INCLUDE   ,yycolumn, yyline, yytext()); 
      }
  CREATE    { 
        return new Symbol(sym.CREATE   ,yycolumn, yyline, yytext()); 
      }
  VIEW    { 
        return new Symbol(sym.VIEW   ,yycolumn, yyline, yytext()); 
      }
  MODIFY    { 
        return new Symbol(sym.MODIFY   ,yycolumn, yyline, yytext()); 
      }
  CURRENT    { 
        return new Symbol(sym.CURRENT   ,yycolumn, yyline, yytext()); 
      }
  ADD    { 
        return new Symbol(sym.ADD   ,yycolumn, yyline, yytext()); 
      }
  ALTER    { 
        return new Symbol(sym.ALTER   ,yycolumn, yyline, yytext()); 
      }
  COLUMN    { 
        return new Symbol(sym.COLUMN   ,yycolumn, yyline, yytext()); 
      }
  DROP    { 
        return new Symbol(sym.DROP   ,yycolumn, yyline, yytext()); 
      }
  CHAR    { 
        return new Symbol(sym.CHAR   ,yycolumn, yyline, yytext()); 
      }
  BINARY    { 
        return new Symbol(sym.BINARY   ,yycolumn, yyline, yytext()); 
      }
  BLOB    { 
        return new Symbol(sym.BLOB   ,yycolumn, yyline, yytext()); 
      }
  BIT    { 
        return new Symbol(sym.BIT   ,yycolumn, yyline, yytext()); 
      }
  SMALLINT  { 
        return new Symbol(sym.SMALLINT   ,yycolumn, yyline, yytext()); 
      }
 INT    { 
        return new Symbol(sym.INT   ,yycolumn, yyline, yytext()); 
      }
 INTEGER    { 
        return new Symbol(sym.INTEGER   ,yycolumn, yyline, yytext()); 
      }
 VARCHAR    { 
        return new Symbol(sym.VARCHAR   ,yycolumn, yyline, yytext()); 
      }
 FLOAT    { 
        return new Symbol(sym.FLOAT   ,yycolumn, yyline, yytext()); 
      }
 BOOLEAN    { 
        return new Symbol(sym.BOOLEAN   ,yycolumn, yyline, yytext()); 
      }
 DATE    { 
        return new Symbol(sym.DATE   ,yycolumn, yyline, yytext()); 
      }
 YEAR     { 
        return new Symbol(sym.YEAR   ,yycolumn, yyline, yytext()); 
      }
 IMAGE    { 
        return new Symbol(sym.IMAGE    ,yycolumn, yyline, yytext()); 
      }
 REAL     { 
        return new Symbol(sym.REAL     ,yycolumn, yyline, yytext()); 
      }
 TIME      { 
        return new Symbol(sym.TIME      ,yycolumn, yyline, yytext()); 
      }
 TIMESTAMP { 
        return new Symbol(sym.TIMESTAMP       ,yycolumn, yyline, yytext()); 
      }
 TEXT { 
        return new Symbol(sym.TEXT         ,yycolumn, yyline, yytext()); 
      }
 BYTE { 
        return new Symbol(sym.BYTE          ,yycolumn, yyline, yytext()); 
      }
 LONG { 
        return new Symbol(sym.LONG           ,yycolumn, yyline, yytext()); 
      }
 DOUBLE { 
        return new Symbol(sym.DOUBLE            ,yycolumn, yyline, yytext()); 
      }
 NCHAR { 
        return new Symbol(sym.NCHAR             ,yycolumn, yyline, yytext()); 
      }
 MAX  { 
        return new Symbol(sym.MAX             ,yycolumn, yyline, yytext()); 
      }
 MIN  { 
        return new Symbol(sym.MIN             ,yycolumn, yyline, yytext()); 
      }
 USER  { 
        return new Symbol(sym.USER ,yycolumn, yyline, yytext()); 
      }
 IF  { 
        return new Symbol(sym.IF ,yycolumn, yyline, yytext()); 
      }
 EXISTS  { 
        return new Symbol(sym.EXISTS ,yycolumn, yyline, yytext()); 
      }
 NO  { 
        return new Symbol(sym.NO ,yycolumn, yyline, yytext()); 
      }
 BEGIN  { 
        return new Symbol(sym.BEGIN ,yycolumn, yyline, yytext()); 
      }
 TRANSACTION  { 
        return new Symbol(sym.TRANSACTION ,yycolumn, yyline, yytext()); 
      }
 TRAN  { 
        return new Symbol(sym.TRAN ,yycolumn, yyline, yytext()); 
      }
 COMMIT  { 
        return new Symbol(sym.COMMIT ,yycolumn, yyline, yytext()); 
      }
 SAVEPOINT  { 
        return new Symbol(sym.SAVEPOINT ,yycolumn, yyline, yytext()); 
      }
 ROLLBACK  { 
        return new Symbol(sym.ROLLBACK ,yycolumn, yyline, yytext()); 
      }
 DECLARE  { 
        return new Symbol(sym.DECLARE ,yycolumn, yyline, yytext()); 
      }
 CURSOR  { 
        return new Symbol(sym.CURSOR ,yycolumn, yyline, yytext()); 
      }
 LOCAL  { 
        return new Symbol(sym.LOCAL ,yycolumn, yyline, yytext()); 
      }
 GLOBAL  { 
        return new Symbol(sym.GLOBAL ,yycolumn, yyline, yytext()); 
      }
 SCROLL  { 
        return new Symbol(sym.SCROLL ,yycolumn, yyline, yytext()); 
      }
 FORWARD_ONLY  { 
        return new Symbol(sym.FORWARD_ONLY ,yycolumn, yyline, yytext()); 
      }
 STATIC  { 
        return new Symbol(sym.STATIC ,yycolumn, yyline, yytext()); 
      }
KEYSET { 
        return new Symbol(sym.KEYSET ,yycolumn, yyline, yytext()); 
      }
DYNAMIC { 
        return new Symbol(sym.DYNAMIC ,yycolumn, yyline, yytext()); 
      }
FAST_FORWARD { 
        return new Symbol(sym.FAST_FORWARD ,yycolumn, yyline, yytext()); 
      }
READ_ONLY { 
        return new Symbol(sym.READ_ONLY ,yycolumn, yyline, yytext()); 
      }
SCROLL_LOCKS { 
        return new Symbol(sym.SCROLL_LOCKS ,yycolumn, yyline, yytext()); 
      }
OPTIMISTIC { 
        return new Symbol(sym.OPTIMISTIC ,yycolumn, yyline, yytext()); 
      }
TYPE_WARNING { 
        return new Symbol(sym.TYPE_WARNING ,yycolumn, yyline, yytext()); 
      }
MODULAR { 
        return new Symbol(sym.MODULAR ,yycolumn, yyline, yytext()); 
      }
FILEGROWTH { 
        return new Symbol(sym.FILEGROWTH ,yycolumn, yyline, yytext()); 
      }
UNLIMITED { 
        return new Symbol(sym.UNLIMITED ,yycolumn, yyline, yytext()); 
      }
MAXSIZE { 
        return new Symbol(sym.MAXSIZE ,yycolumn, yyline, yytext()); 
      }
KB { 
        return new Symbol(sym.KB ,yycolumn, yyline, yytext()); 
      }
MB { 
        return new Symbol(sym.MB ,yycolumn, yyline, yytext()); 
      }
GB { 
        return new Symbol(sym.GB ,yycolumn, yyline, yytext()); 
      }
TB { 
        return new Symbol(sym.TB ,yycolumn, yyline, yytext()); 
      }
FILENAME { 
        return new Symbol(sym.FILENAME ,yycolumn, yyline, yytext()); 
      }
ROWGUIDCOL { 
        return new Symbol(sym.ROWGUIDCOL ,yycolumn, yyline, yytext()); 
      }
OF { 
        return new Symbol(sym.OF ,yycolumn, yyline, yytext()); 
      }
SUM { 
        return new Symbol(sym.SUM ,yycolumn, yyline, yytext()); 
      }
TABLE { 
        return new Symbol(sym.TABLE ,yycolumn, yyline, yytext()); 
      }
NVARCHAR { 
        return new Symbol(sym.NVARCHAR ,yycolumn, yyline, yytext()); 
      }
{WhiteSpace} {/*Ignore*/}
{Comment} {/*Ignore*/}

"+" { 
        return new Symbol(sym.Suma ,yycolumn, yyline, yytext()); 
      }
"-" { 
        return new Symbol(sym.Resta ,yycolumn, yyline, yytext()); 
      }
"*" { 
        return new Symbol(sym.Multiplicacion ,yycolumn, yyline, yytext()); 
      }
"/" { 
        return new Symbol(sym.Division ,yycolumn, yyline, yytext()); 
      }
"%" { 
        return new Symbol(sym.Porcentaje ,yycolumn, yyline, yytext()); 
      }

"=" { 
        return new Symbol(sym.Igual ,yycolumn, yyline, yytext()); 
      }
"#" { 
        return new Symbol(sym.Numeral ,yycolumn, yyline, yytext()); 
      }
"##" { 
        return new Symbol(sym.Doble_numeral ,yycolumn, yyline, yytext()); 
      }
";" { 
        return new Symbol(sym.Punto_y_coma ,yycolumn, yyline, yytext()); 
      }
"," { 
        return new Symbol(sym.Coma ,yycolumn, yyline, yytext()); 
      }
"." { 
        return new Symbol(sym.Punto ,yycolumn, yyline, yytext()); 
      }
"(" { 
        return new Symbol(sym.Parentesis_de_apertura ,yycolumn, yyline, yytext()); 
      }
")" { 
        return new Symbol(sym.Parentesis_de_cierre ,yycolumn, yyline, yytext()); 
      }
"<" { 
        return new Symbol(sym.Menor ,yychar, yyline, yytext()); 
      }
"<=" { 
        return new Symbol(sym.Menor_o_igual ,yychar, yyline, yytext()); 
      }
">" { 
        return new Symbol(sym.Mayor ,yychar, yyline, yytext()); 
      }
">=" { 
        return new Symbol(sym.Mayor_o_igual ,yychar, yyline, yytext()); 
      }
"==" { 
        return new Symbol(sym.Igualdad ,yychar, yyline, yytext()); 
      }
"!=" { 
        return new Symbol(sym.Diferente ,yychar, yyline, yytext()); 
}
"@" { 
        return new Symbol(sym.Arroba ,yycolumn, yyline, yytext()); 
      }
"{" { 
        return new Symbol(sym.Corchete_de_apertura ,yycolumn, yyline, yytext()); 
      }
"}" { 
        return new Symbol(sym.Corchete_de_cierre ,yycolumn, yyline, yytext()); 
      }

{Identifier} { 
        return new Symbol(sym.Identificador ,yycolumn, yyline, yytext()); 
      }

{Int} { 
        return new Symbol(sym.Int ,yycolumn, yyline, yytext()); 
      }

{Bit} { 
        return new Symbol(sym.Bit ,yycolumn, yyline, yytext()); 
      }

{Decimal} { 
        return new Symbol(sym.Float ,yycolumn, yyline, yytext()); 
      }

{Exp} { 
        return new Symbol(sym.Float ,yycolumn, yyline, yytext()); 
      }

{String} { 
        return new Symbol(sym.String ,yycolumn, yyline, yytext()); 
      }
{WhiteSpace} {/*Ignore*/}
{Comment} {/*Ignore*/}
/*Errores*/

.   {
        return new Symbol(sym.error ,yycolumn, yyline, yytext());
    }