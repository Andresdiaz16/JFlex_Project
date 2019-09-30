/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.File;

/**
 *
 * @author Andres Diaz
 */

public class Lexer_Generator {
   String path = "";
   
  public Lexer_Generator(String Path){
       path = Path;
   }
   
   public void GenerateLexer(){
   File file = new File(path);
   jflex.Main.generate(file);
   }
}
