package stages;

import exception.NoSuchAddressException;
import instructions.Lw;
import instructions.Sw;
import abstracts.Instruction;
import hardwares.Memory;
import hardwares.Register;

public class MEM {
	
	public static void readOrWrite(Instruction instruction) throws NoSuchAddressException{
		Memory memory = Memory.getInstance();
		if (instruction instanceof Lw ){
			int address = ((Lw) instruction).getRt().getValue();
			int offset = ((Lw) instruction).getAddress();
			int memory_address = address + offset;
			int executed_value = memory.getData(memory_address); 
			instruction.setExecutedValue(executed_value);
			
		}else if (instruction instanceof Sw){
			int address = ((Sw) instruction).getRt().getValue();
			int offset = ((Sw) instruction).getAddress();
			int memory_address = address + offset;
			memory.setData(memory_address, instruction.getExecutedValue());
		}
	}

}
