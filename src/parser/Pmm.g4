grammar Pmm;	

program : d= definitions m=main EOF
       ;

definitions:    (def=definition)* ;

main: d='def' 'main' p1='('')' ':' '{' dv=defVariablesLocales s=stms '}';

definition:     df= defFuncion
               |dv = defVariable
               ;

defFuncion:def='def' id=ID p1='(' par=parametros ')' ':' (sp=simpleTypes)? '{' dvl=defVariablesLocales s=stms '}' ;
defVariable:idList ':' types ;


parametros: (d=defVariable (',' d2= defVariable)*)?;
defVariablesLocales: (d=defVariable)*  ;
simpleTypes:
          'int'
		| 'double'
		| 'char'
		;

idList: id1 = ID (',' id2=ID)*;
types: st=simpleTypes
    |c= '[' i= INT_CONSTANT ']' types
    | s= 'struct' '{' dv= defVariableCampos '}'
    ;

defVariableCampos: (d=defRecord ';')+;
defRecord: idList ':' types;


stms: (st=statement)*;

statement :
			e1 = expression '=' e2 = expression ';'
			|printStatement
			|inputStatement
			|s=statementIf
			|'return' exp= expression? ';'
			|sw=statementWhile
			| ID '(' pi=paramsInvocation  ')' ';'
			;

listExpression: e1= expression (',' e2= expression ) *;

printStatement:'print' list= listExpression;
inputStatement:'input' list = listExpression;

statementIf:
            i='if' exp=expression ':' stm=statement ( 'else' stm2=statement )?
            | i='if' exp=expression ':' '{' stmsIf = stms '}' ('else' stm2=statement)?
            | i='if' exp=expression ':' '{' stmsIf=stms '}' ( 'else' '{' stmsElse=stms'}')?
            | i='if' exp=expression ':' stm=statement ( 'else' '{'stmsElse=stms'}' )?
;

statementWhile returns [WhileStatement ast]:
			i='while' exp=expression ':' '{' sts=stms '}'
			|i='while' exp=expression ':' stm=statement
			;


expression :
			'('exp = expression')'
			|exp1=expression '[' exp2=expression ']'
			|exp=expression '.' id=ID
			|'(' st=simpleTypes ')'
			|'-' exp= expression
			|'!' exp = expression
			|exp1=expression op=('*' | '/' |'%')
			|exp1=expression op=( '+' | '-')
			| exp1=expression op=('>' | '>=' | '<' |'<=' | '!=' | '==')
			|exp1=expression op=('&&' | '||')
			|ID '(' pi=paramsInvocation  ')'
			|INT_CONSTANT
			|REAL_CONSTANT
			|CHAR_CONSTANT
			|ID
			;

paramsInvocation: (exp1=expression   (','exp2 = expression )*)?
                 ;

//opcionalidad de vacio

/*
pi:
    | listapi
    ;
listapi:
   expression
   |listapi ',' expression
    ;
*/





 ////////////////////////////////////////////////////////LEXICO///////////////////////////////////////////////////////
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

WS: [ \n\t\r]+ -> skip;
LINE_COMMENT: '#'~[\n\r]* -> skip;
MULTILINE_COMMENT: '"""' .*? '"""' -> skip;

