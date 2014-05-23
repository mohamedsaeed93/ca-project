package stages;

import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;
import abstracts.Instruction;

public class EXEC {
	public static void exec(Instruction i) throws NoSuchRegisterException, SyntaxErrorException {
		if (i != null) {
			i.exec();
		}
	}

}
