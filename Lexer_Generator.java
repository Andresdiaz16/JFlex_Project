/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Andres Diaz
 */

public class Lexer_Generator {
   String path = "";
   String path2 = "";
   String array[];
   
  public Lexer_Generator(String Path, String Path2,String[]n){
       path = Path;
       path2 = Path2;
       array =n;
   }
   
   public void GenerateLexer() throws IOException, Exception{
   File file;
   file= new File(path);
   jflex.Main.generate(file);
   file= new File(path2);
   jflex.Main.generate(file);
   java_cup.Main.main(array);
   
   Path rutaSym = Paths.get(System.getProperty("user.dir")+"/src/lexer/sym.java");
   if(Files.exists(rutaSym)){
       Files.delete(rutaSym);
   }
   
   Files.move(Paths.get(System.getProperty("user.dir")+"/sym.java"), Paths.get(System.getProperty("user.dir")+"/src/lexer/sym.java"));
       if (Files.exists(Paths.get(System.getProperty("user.dir")+"/src/lexer/sintax.java"))) {
           Files.delete(Paths.get(System.getProperty("user.dir")+"/src/lexer/sintax.java"));
       }
   Files.move(Paths.get(System.getProperty("user.dir")+"/sintax.java"), Paths.get(System.getProperty("user.dir")+"/src/lexer/sintax.java"));

   
   }
}
