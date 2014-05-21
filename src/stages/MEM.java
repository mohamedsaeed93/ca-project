package stages;

import hardwares.Memory;
import instructions.Lw;
import instructions.Sw;
import abstracts.Instruction;
import exception.NoSuchAddressException;

public class MEM {

	public static void readOrWrite(Instruction instruction)
			throws NoSuchAddressException {
		if (instruction == null)
			return;
		Memory memory = Memory.getInstance();
		if (instruction instanceof Lw) {
			int address = ((Lw) instruction).getRs().getValue();
			int offset = ((Lw) instruction).getAddress();
			if (offset % 4 != 0)
				throw new NoSuchAddressException("The Offset " + offset
						+ " isnot multiple of 4");
			int memory_address = address + offset;
			int executed_value = memory.getData(memory_address);
			instruction.setExecutedValue(executed_value);

		} else if (instruction instanceof Sw) {
			int address = ((Sw) instruction).getRt().getValue();
			int offset = ((Sw) instruction).getAddress();
			if (offset % 4 != 0)
				throw new NoSuchAddressException("The Offset " + offset
						+ " isnot multiple of 4");
			int memory_address = address + offset / 4;
			memory.setData(memory_address, ((Sw) instruction).getRs()
					.getValue());
		}
	}
}
