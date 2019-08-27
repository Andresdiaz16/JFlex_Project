# JFlex Lexical Analyzer Proyect

This project is a SQL lexical analyzer that contains each an every word documented on [Microsoft SQL Keywords](https://docs.microsoft.com/en-us/sql/t-sql/language-elements/reserved-keywords-transact-sql?view=sql-server-2017) page, I used the Java library [JFlex](https://jflex.de/) to analyze this words and other tokens such as: __+ - * / % < <= > >= = == != && || ! ; , . [ ] ( ) { } [] () {} @ # ##__, also this analyzer takes into account both types of comments that SQL accepts, one line comment (--) or multi-line comment (/* */).

### Token Report
Each found token or error would be documented on a .out file contained in a folder called Output on the project's main folder under Lexer\src\lexer, each token report contains the line where it was found, what character or set of characters the lexical analyzer found, the column in wich the token starts and ends, and what type of token it is, this also applies to errors this are easy to find since they do not start with the word "LINE: " as the succesful tokens do. 

### Error Reports

This is a simple analyzer an as such it only reports 4 types of errors, the first one being an invalid token error, this appears when the program finds a token that is not part of the previous mention rules (Keywords and operands previously mentioned), the second type of error that this project reports is if a multi-line comment was not properly ended at some point, the program will report the whole line as an error but will resume analyzing the on next line.

You can also encounter an error that will let you know that you didnt properly wrote a string, this program analyzes strings as any set of characters contained in quotes __' '__ so if you find this error most likely will be because it found a sigle quote __'__ and it didnt found the closing quote, its worth mentioning that this program ***can't*** recognize multi-line strings, so a string must end on the same line that it started.

The last type or error is mostly a warning rather than an error, for the purpose of this project identifiers cannot be larger than 31 characters, so if the analyzer finds an identifier that is longer than this, it will cut it down to exactly 31 characters, is also worth mentiong that this programs considers an identifier a set of characters that start with a letter and ends with a set of letters,digits or/and underscores, anything that matches this description will be consider an identifier (e.g. Foo1_, F_o_o2).

## Getting Started

When you start the program you will be prompted with a really simple UI containing for the moment only 3 buttons: 

![Main_Program](https://user-images.githubusercontent.com/45214848/63795611-8826d380-c8c1-11e9-98f8-9de5225f7d74.jpg)

The first button will let you select a text or SQL file to analyze, but if it's the first time you are using this program ***you need to generate the set of rules*** for this you should click on the second button that says generate lexer, this will create a .java file on the projects src folder that will be used to analyze the file, when the bottom text changes to "Rules added" you are ready to go, though in some cases the program may not recognize inmediatly the newly created .java file so I recommend restarting the program, after this unless you changed the set of rules on the .lexer file you do not need to generate the lexer again and if you do but you didnt changed the rules restarting the program will not be necesary.

After generating the lexer you can now select a file to analyze though as previously mentioned this program only works with text an sql files so you will only be able to select this type of files.

After selecting a file a notepad instace will open with each token found in the selected file analyzed, so you can check there the tokens, and if you want to access to where this file is contained you can press the third button wich will open the Output folder where all the .out files are saved.  
