grammar Pmm;	

program: INT_CONSTANT
       ;


fragment DIGITO: '0' | [1-9] [0-9]*;
fragment LETRA: [a-zA-Z];
fragment OPTION1: '.'INT_CONSTANT ([eE]'-'? INT_CONSTANT)?; //._
fragment OPTION2: INT_CONSTANT ([eE]('-'|'+')? INT_CONSTANT)? '.'; //_.
fragment OPTION3:  INT_CONSTANT '.' (INT_CONSTANT([eE]'-'? INT_CONSTANT)?)?;  // 34.12E-3
fragment OPTION4: INT_CONSTANT [eE]('-'|'+')? INT_CONSTANT; //3e3


ID: (LETRA | '_') (LETRA | DIGITO | '_')*;
INT_CONSTANT: DIGITO+;
REAL_CONSTANT: (OPTION1)|(OPTION2)|(OPTION3)|(OPTION4);
CHAR_CONSTANT: '\'' . '\'' | '\'\\n\'' | '\'\\t\'' | '\'\\' INT_CONSTANT '\'';




//...
WS: [ \n\t\r]+ -> skip;
LINE_COMMENT: '#'~[\n\r]* -> skip;
MULTILINE_COMMENT: '"""' .*? '"""' -> skip;

