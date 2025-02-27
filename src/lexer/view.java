/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 /* @author Andres Diaz
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    
    /*
    Global variable intances
    Some variables that are going to be used thru out the project
    */
    Lexer_Generator lGen;
    int returnVal;
    Map<String,String> symbolsTable;
    Path outFile;
    ArrayList<String> lines = new ArrayList<String>();
    int finalColumn;
    String ident;
    String userPath;
    String fileName;
    String[] splitString;
    
    public view() {
        //SETS THE LOOK AND FEEL OF WINDOWS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CHANGES THE TOOLTIP BACKGROUND COLOR TO WHITE
        UIManager.put("ToolTip.background", Color.WHITE);
        //INITIALIZES THE JFRAME AND ITS COMPONENTS
        initComponents();
        //GETS THE CURRENT DIRECTORY WHERE THE PROJECT IS CURRENTLY ON FOR FUTURE USE
        userPath = System.getProperty("user.dir");
        //SETS THE TEXT THAT WILL APPEAR UPON START
        jLabel1.setText("PLEASE GENERATE THE JAVA FILE");
        //GETS THE DIMENTIONS OF THE USER SCREEN
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //INITIALIZE THE  HASHMAP THAT WILL BE USE A DICTIONARY TO GET THE PUNCTUATION DESC OR VALUE
        symbolsTable = new HashMap();
        //ADDING THE KEYS AND VALUES TO THE HASMAP
        symbolsTable.put(".","POINT");
        symbolsTable.put("+","PLUS");
        symbolsTable.put("-","MINUS");
        symbolsTable.put("*","MULT");
        symbolsTable.put("/","DIV");
        symbolsTable.put("%","MOD");
        symbolsTable.put("<","LT");
        symbolsTable.put("<=","LE");
        symbolsTable.put(">","GT");
        symbolsTable.put(">=","GE");
        symbolsTable.put("=","EQUAL");
        symbolsTable.put("==","EQUAL_TO");
        symbolsTable.put("!=","DIF");
        symbolsTable.put("!","NOT");
        symbolsTable.put(";","SEMI_COL");
        symbolsTable.put("&&","AND");
        symbolsTable.put("||","OR");
        symbolsTable.put("|","PIPE");
        symbolsTable.put("&","AMPERSON");
        symbolsTable.put(",","COMA");
        symbolsTable.put("[","OPEN_BR");
        symbolsTable.put("]","CLOSE_BR");
        symbolsTable.put("(","OPEN_PARENT");
        symbolsTable.put(")","CLOSE_PARENT");
        symbolsTable.put("[]","BRAKETS");
        symbolsTable.put("()","PARENTHESIS");
        symbolsTable.put("{","OPEN_STAPE");
        symbolsTable.put("}","CLOSE_STAPE");
        symbolsTable.put("{}","STAPLES");
        symbolsTable.put("@","AT");
        symbolsTable.put("#","HASTAG");
        symbolsTable.put("##","DOUBLE_HASTAG");
        //INITIALIZING THE COUNTER FOR THE LINES
        finalColumn = 0;
        //INITIALIZE THE STRING VARIABLE THAT WILL BE USE TO PRINT THE IDENTIFIERS THAT ARE LONGER THAN 31 CHARACTERS
        ident = "";
        //INITIALIZE THE STRING VARIABLE THA WILL BE USE TO GET THE NAME OF THE SELECTED FILE.
        fileName="";
        //INITIALIZE THE STRING ARRAY VARIABLE THA WILL BE USE TO GET THE NAME OF THE SELECTED FILE.
        splitString = new String[2];
        //SETTING THE JFRAME LOCATION TO THE CENTER OF THE USERS SCREEN
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //SETTING THE RESIZABLE OPTION TO FALSE SO THE JFRAME KEEPS ITS INTENDED SIZE.
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Analyze File");
        jButton1.setToolTipText("Opens the .sql or .txt ile you want to analyze");
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generate Lexer");
        jButton2.setToolTipText("Generates the .java that will analyze the input  file");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Open File Location");
        jButton3.setToolTipText("Opens the project location");
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BUTTON THAT GENERATES THE .JAVA FILE FROM THE .LEXER FILE
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //CREATES A TEMPORARY FILE OF THE .JAVA THAT WAS GENERATED OF THE .LEXER FILE IF IT EXISTS
        File tempFile = new File(userPath+"\\src\\lexer\\Analyzer.java");
        boolean exists = tempFile.exists();
        /*
        COMPARES IF THE .JAVA FILE EXIST OR NOT
        IF IT DOESNT EXIST IT CREATES ONE IF IT DOES EXIST THEN
        IT WOULD FIRST DELETE THE FILE THAT EXISTS AND THEN IT WILL CREATE A NEW
        THIS TO PREVENT THE USER CHANGING THE .LEXER FILE AND THE PROGRAM USING THE 
        OLD ONE INSTEAD OF THE NEWLY ADDED.
        */
        if (exists) {
            tempFile.delete();
            lGen = new Lexer_Generator(userPath+"/src/lexer/Lexer.flex");
            lGen.GenerateLexer();
            jLabel1.setText("RULES ADDED");
        }
        else{
            lGen = new Lexer_Generator(userPath+"/src/lexer/Lexer.flex");
            lGen.GenerateLexer();
            jLabel1.setText("RULES ADDED");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    //BUTTON THAT ANALYZES THE INPUT FILE
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //INSTANCING A JFILECHOOSER TO SELECT A FILE
        JFileChooser flc = new JFileChooser();
        //CREATING A FILTER SO ONLY SQL AND TEXT FILES CAN BE SELECTED BY THE JFC
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL or TEXT files", "sql","txt");
        //ADDING THE PREVIOUS FILTER TO THE JFC
        flc.setFileFilter(filter);
        //SHOWS THE FILE DIALOG IN THE CENTER
        returnVal = flc.showOpenDialog(null);
        //CHECKS TO SE IF THE SELECTION MADE BY THE USER WAS A VALID FILE
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File fld = flc.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fld));
                Analyzer lexer = new Analyzer(reader);
                splitString = fld.getName().split("\\.");
                fileName = splitString[0];
                String line = "";
                File filePath = new File(userPath+"\\src\\lexer\\Output\\" +fileName +".out");
                boolean fileEX = filePath.exists();
                if(fileEX){
                    filePath.delete();
                    outFile = Paths.get(userPath+"\\src\\lexer\\Output\\" +fileName+".out");
                    Files.createFile(outFile);
                }
                else{
                    outFile = Paths.get(userPath+"\\src\\lexer\\Output\\"+fileName+".out");
                    Files.createFile(outFile);
                }
                do{
                    Tokens token = lexer.yylex();
                    if(token == null){
                    //return EOF
                    Files.write(outFile, lines,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    lines.clear();
                    Runtime.getRuntime().exec("explorer.exe /open, "+outFile);
                    return;
                    }
                    else{
                        switch(token){
                            //escribir el .out
                            case RESERVADA:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: " +lexer.yytext()+" TOKEN: RESERVADA, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                                break;
                            case PUNTUACION:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+ lexer.yytext()+" TOKEN:"+ symbolsTable.get(lexer.yytext()) +" "+", ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                                break;
                            case ENTERO:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+ lexer.yytext()+" TOKEN: ENTERO, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                                break;
                            case IDENTIFICADOR:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               if(lexer.yylength() > 31){
                                   ident = lexer.yytext().substring(0,31);
                                   lines.add("IDENTIFIER TOO LONG CUTTED DOWN TO 31 CHARS ON LINE: "+ (lexer.line+1) +" FOUND: "+ ident+" TOKEN: IDENTIFICADOR, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                                   ident = "";
                               }else{
                                   lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+ lexer.yytext()+" TOKEN: IDENTIFICADOR, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               }
                               finalColumn = 0;                                
                                break;
                            case ErrorToken:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("ERROR!!! LINE: "+ (lexer.line+1) +" FOUND: "+ lexer.yytext()+" TOKEN: ERROR TOKEN NOT SPECIFIED, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0; 
                                break;
                            case ErrorLINEA:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("ERROR COMMENT NOT FINALIZED! ON LINE: "+ (lexer.line+1) +" FOUND: "+lexer.yytext()+" TOKEN: INVALID STRING, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;                                 
                               break;
                            case DECIMAL:
                               finalColumn = finalColumn + lexer.yylength();
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+ lexer.yytext()+" TOKEN: DECIMAL, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                            break;
                            case EXPONENCIAL:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+lexer.yytext()+" TOKEN: EXPONENCIAL, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                            break;
                            case ERRORSTRING:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("ERROR STRING! ON LINE: "+ (lexer.line+1) +" FOUND: "+lexer.yytext()+" TOKEN:INVALID, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0; 
                            break;
                               case STRING:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+lexer.yytext()+" TOKEN: STRING, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                            break;
                               case BIT:
                               finalColumn = lexer.column + lexer.yylength()-1;
                               lines.add("LINE: "+ (lexer.line+1) +" FOUND: "+lexer.yytext()+" TOKEN: BIT, ON COLUMN: " +lexer.column+" TO: " + finalColumn );
                               finalColumn = 0;
                            break;
                        }
                    }                    
                }while(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            Runtime.getRuntime().exec("explorer.exe /open, "+userPath+"\\src\\lexer\\Output");
        } catch (IOException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
