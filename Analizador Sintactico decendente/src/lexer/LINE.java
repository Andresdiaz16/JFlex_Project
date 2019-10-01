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
public class LINE {
    private int line;
    private int column;
    private String text;
    public LINE(int linea, int columna, String texto){
        
        line = linea;
        column = columna;
        text = texto;
    }
    public int returnLine(){
        return line;
    }
    public int returnColumn(){
        return column;
    }
    public String getText(){
        return text;
    }
}
