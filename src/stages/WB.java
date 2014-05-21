package stages;

import abstracts.IFormat;
import abstracts.Instruction;
import abstracts.RFormat;

public class WB {

	public static void RegistetWriteBack(Instruction instruction) {
		if (instruction == null)
			return;
		if (instruction.isRegisterWrite()) {
			if (instruction instanceof RFormat) {
				((RFormat) instruction).getRd().setValue(
						instruction.getExecutedValue());
			} else if (instruction instanceof IFormat) {
				((IFormat) instruction).getRt().setValue(
						instruction.getExecutedValue());
			}
		}
	}

}