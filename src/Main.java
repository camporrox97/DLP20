import codeGenerator.OffsetVisitor;
import parser.*;

import org.antlr.v4.runtime.*;

import ast.Program;
import errorhandler.EH;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import visitors.IdentificationVisitor;
import visitors.TypeCheckingVisitor;
import visitors.Visitor;

public class Main {

	public static void main(String... args) throws Exception {
		if (args.length<1) {
			System.err.println("Please, pass me the input file.");
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PmmParser parser = new PmmParser(tokens);
		Program ast = parser.program().ast;


		//VISITOR IDENTIFICACION
		Visitor identVisitor = new IdentificationVisitor();
		identVisitor.visit(ast, null);

		//VISITOR L-VALUE
		Visitor lValueVisitor = new TypeCheckingVisitor();
		lValueVisitor.visit(ast, null);

		// * Check errors
		if(EH.getEH().hasErrors()){
			// * Show errors
			EH.getEH().showErrors(System.err);
		}
		else{
			Visitor offsetVisitor = new OffsetVisitor();
			offsetVisitor.visit(ast, null);
			// * The AST is shown
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
		}
	}
}
