package stages;

import exception.NoSuchRegisterException;
import abstracts.Instruction;

public class EXEC {
	public static void exec(Instruction i) throws NoSuchRegisterException
	{
		i.exec();
	}

}
