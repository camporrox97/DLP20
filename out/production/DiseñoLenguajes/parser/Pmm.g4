grammar Pmm;

@header{

import ast.*;
	import ast.expressions.*;
	import ast.definitions.*;
	import ast.statements.*;
	import ast.types.*;
}

program returns [Program ast]: d=definitions m=main EOF { $ast = new Program($d.start.getLine(), $d.start.getCharPositionInLine() + 1, $d.ast, $m.ast); }
	 ;

definitions returns [List<Definition> ast = new ArrayList<>()]: (def=definition {$ast.addAll($def.ast);} )*
	;

main returns [FuncDefinition ast]: d='def' 'main' p1='('')' ':' '{' dv=defVariablesLocales s=statements '}'
		{
			Type ft = new FunctionType($p1.getLine(), $p1.getCharPositionInLine() + 1, VoidType.getInstance(),new ArrayList<VarDefinition>());
			$ast = new FuncDefinition($d.getLine(), $d.getCharPositionInLine() + 1, ft, "main", $dv.ast, $s.ast);
		}
	;
definition returns [List<Definition> ast = new ArrayList<>()]: df=defFuncion {$ast.add($df.ast); }
			| dv=defVariable ';' {$ast.addAll($dv.ast);}
			;

defFuncion returns [FuncDefinition ast]: def='def' id=ID p1='(' par=parametros ')' ':' (sp=simpleTypes)? '{' dvl=defVariablesLocales s=statements '}'
		{
			Type tipoRetorno = ($sp.ctx == null) ? VoidType.getInstance() : $sp.ast;
			Type tipo = new FunctionType($p1.getLine(), $p1.getCharPositionInLine() + 1, tipoRetorno, $par.ast);
			$ast = new FuncDefinition($def.getLine(), $def.getCharPositionInLine() + 1, tipo, $id.text, $dvl.ast, $s.ast);
		}
		 ;

parametros returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]: (d=defVariable {$ast.addAll($d.ast);} (','d2=defVariable {$ast.addAll($d2.ast);} )*)?
	;

defVariablesLocales returns [List<VarDefinition> ast = new ArrayList<VarDefinition>() ]: (d=defVariable {$ast.addAll($d.ast);}  ';')*
	;

statements returns [List<Statement> ast = new ArrayList<Statement>()]: (st=statement {$ast.addAll($st.ast);})*
	;

defVariable returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()] : idList ':' types
		{
			for (String s : $idList.ast)
				$ast.add(new VarDefinition($idList.start.getLine(), $idList.start.getCharPositionInLine() + 1,
											s, $types.ast, 0, 0));
		}
			;

idList returns [List<String> ast = new ArrayList<String>()] :
			id1=ID
			{
				$ast.add($id1.text);
			}


			(',' id2=ID {
				$ast.add($id2.text);
			})*

			;

types returns [Type ast]: st=simpleTypes {$ast = $st.ast;}
		| c='[' i=INT_CONSTANT ']' types { $ast = new ArrayType($c.getLine(),$c.getCharPositionInLine() + 1, $types.ast, LexerHelper.lexemeToInt($i.text)); }
		| s='struct' '{' dv=defVariableCampos '}' { $ast = new RecordType($s.getLine(),$s.getCharPositionInLine() + 1, $dv.ast  );}
		;

defVariableCampos returns [List<FieldRecord> ast = new ArrayList<FieldRecord>() ]: (d=defRecord
			{
				for (FieldRecord fr: $d.ast) {


						$ast.add(fr);

				}
			}  ';')+
		;

defRecord returns [List<FieldRecord> ast = new ArrayList<FieldRecord>()] : idList ':' types
		{
			for (String s : $idList.ast)
				$ast.add(new FieldRecord($idList.start.getLine(), $idList.start.getCharPositionInLine() + 1,
											s, $types.ast));
		}
			;

simpleTypes returns [Type ast]: 'int' { $ast = IntType.getInstance(); }
		| 'double' { $ast = DoubleType.getInstance(); }
		| 'char' { $ast = CharType.getInstance(); }
		;


statement returns [List<Statement> ast = new ArrayList<Statement>()]:
			e1 = expression '=' e2 = expression ';'{$ast.add(new Assignament($start.getLine(), $start.getCharPositionInLine() + 1, $e1.ast, $e2.ast));}
			|printStatement
			{
								for (Print w : $printStatement.ast)
									$ast.add(w);
			}
			|inputStatement
			{
								for ( Input r : $inputStatement.ast)
									$ast.add(r);
			}
			|s=statementIf  { $ast.add($s.ast); }
			|'return' exp= expression ';' {$ast.add(new ReturnStatement($start.getLine(), $start.getCharPositionInLine() + 1, $exp.ast));}
			|sw=statementWhile {$ast.add($sw.ast);}
			| ID '(' pi=paramsInvocation  ')' ';' { $ast.add(new Invocation($start.getLine(), $start.getCharPositionInLine() + 1,
											$pi.ast, new Variable($start.getLine(), $start.getCharPositionInLine() + 1, $ID.text))); }
			;

printStatement returns [List<Print> ast = new ArrayList<Print>()]:
	'print' list= listExpression {
								for (Expression e : $list.ast)
								$ast.add(new Print($start.getLine(), $start.getCharPositionInLine() + 1, e));
							  }
					';'
							  ;

inputStatement returns [List<Input> ast = new ArrayList<Input>()]:
	'input' list = listExpression {
								for (Expression e : $list.ast)
								$ast.add(new Input($start.getLine(), $start.getCharPositionInLine() + 1, e));
							  }
					';'
			;

listExpression returns [List<Expression> ast = new ArrayList<Expression>()]:
	e1= expression {$ast.add($e1.ast);} (',' e2=expression {$ast.add($e2.ast);} )*
		;

paramsInvocation returns [List<Expression> ast = new ArrayList<Expression>()]: (exp1=expression {$ast.add($exp1.ast);}  (',' exp2 = expression {$ast.add($exp2.ast);})*)?
	;
expression returns [Expression ast]:
			'('exp = expression')' { $ast = $exp.ast; }
			|exp1=expression '[' exp2=expression ']'{$ast = new Indexing($start.getLine(), $start.getCharPositionInLine() + 1, $exp1.ast, $exp2.ast);}
			|exp=expression '.' id=ID 	{$ast = new FieldAccess($start.getLine(), $start.getCharPositionInLine() + 1, $exp.ast, $id.text);}
			|'(' st=simpleTypes ')' exp=expression { $ast = new Cast($exp.start.getLine(), $exp.start.getCharPositionInLine() + 1,$exp.ast, $st.ast); }
			|'-' exp= expression { $ast = new UnaryMinus($exp.start.getLine(), $exp.start.getCharPositionInLine() + 1, $exp.ast); }
			|'!' exp = expression { $ast = new UnaryNot($exp.start.getLine(), $exp.start.getCharPositionInLine() + 1, $exp.ast); }
			|exp1=expression op=('*' | '/' |'%') exp2=expression {$ast = new Arithmetic($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1,$exp1.ast, $op.text, $exp2.ast);}
			|exp1=expression op=( '+' | '-') exp2=expression {$ast = new Arithmetic($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1,$exp1.ast, $op.text, $exp2.ast);}
			| exp1=expression op=('>' | '>=' | '<' |'<=' | '!=' | '==') exp2=expression {$ast = new Comparison($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1,$exp1.ast, $op.text, $exp2.ast);}
			|exp1=expression op=('&&' | '||') exp2=expression {$ast = new Logical($exp1.start.getLine(), $exp1.start.getCharPositionInLine() + 1,$exp1.ast, $op.text, $exp2.ast);}

			| ID '(' pi=paramsInvocation  ')' { $ast = new Invocation($start.getLine(), $start.getCharPositionInLine() + 1,  //AQUI INTERROGANTE O NO
											$pi.ast, new Variable($start.getLine(), $start.getCharPositionInLine() + 1, $ID.text)); }
			|INT_CONSTANT {$ast = new IntLiteral($start.getLine(), $start.getCharPositionInLine() + 1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
			|REAL_CONSTANT {$ast = new RealLiteral($start.getLine(), $start.getCharPositionInLine() + 1,LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
			|CHAR_CONSTANT {$ast = new CharLiteral($start.getLine(), $start.getCharPositionInLine() + 1,LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
			|ID {$ast = new Variable($start.getLine(), $start.getCharPositionInLine() + 1, $ID.text);}

			;


statementIf returns [IfStatement ast]:
			i='if' exp=expression ':' stm=statement ( 'else' stm2=statement )?
				{
					List<Statement> statementsIf = new ArrayList<>();
					statementsIf.addAll($stm.ast);
					List<Statement> statementsElse = new ArrayList<>();
					if ($stm2.ctx != null) statementsElse.addAll($stm2.ast);
					$ast = new IfStatement($i.getLine(), $i.getCharPositionInLine(),$exp.ast, statementsIf, statementsElse);
				}
			| i='if' exp=expression ':' '{' stmsIf = statements '}' ('else' stm2=statement)?
				{
					List<Statement> statementsElse = new ArrayList<>();
					if ($stm2.ctx != null) statementsElse.addAll($stm2.ast);
					$ast = new IfStatement($i.getLine(), $i.getCharPositionInLine(),$exp.ast, $stmsIf.ast, statementsElse);
				}
			| i='if' exp=expression ':' '{' stmsIf=statements '}' ( 'else' '{' stmsElse=statements'}')?
				{
					List<Statement> statementsElse = new ArrayList<>();
					if ($stmsElse.ctx != null) statementsElse = $stmsElse.ast;
					$ast = new IfStatement($i.getLine(), $i.getCharPositionInLine(),$exp.ast ,$stmsIf.ast, statementsElse);
				}
			| i='if' exp=expression ':' stm=statement ( 'else' '{'stmsElse=statements'}' )?
			{
					List<Statement> statementsIf = new ArrayList<>();
					statementsIf.addAll($stm.ast);
					List<Statement> statementsElse = new ArrayList<>();
					if ($stmsElse.ctx != null) statementsElse = $stmsElse.ast;
					$ast = new IfStatement($i.getLine(), $i.getCharPositionInLine(),$exp.ast, statementsIf, statementsElse);
			}
			;

statementWhile returns [WhileStatement ast]:
			i='while' exp=expression ':' '{' sts=statements '}'{
					$ast = new WhileStatement($i.getLine(), $i.getCharPositionInLine(), $exp.ast, $sts.ast);
			}
			|i='while' exp=expression ':' stm=statement{
				List<Statement> sts = new ArrayList<>();
				sts.addAll($stm.ast);
				$ast = new WhileStatement($i.getLine(), $i.getCharPositionInLine(), $exp.ast, sts);

			}
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

