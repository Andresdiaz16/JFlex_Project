/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author Andres Diaz
 */
public class ErrorJ {
    private int linea ;
    private int columna;
    private String token;
    
    public ErrorJ(int line, int column, String lexeme){
        linea = line +1;
        columna = column +1 ;
        token = lexeme;
    }
    
    public int getLinea(){
        return linea;
    }
    public int getColumna(){
        return columna;
    }
    public String getToken(){
        return token;
    }
    
}
