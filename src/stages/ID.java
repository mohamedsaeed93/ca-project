package stages;

import instructionSet.InstructionString;
import instructions.*;
import abstracts.Instruction;
import exception.NoSuchInstructionException;
import exception.NoSuchRegisterException;
import exception.OverFlowException;

public class ID {

	public static Instruction id(InstructionString instruc) throws NoSuchInstructionException, NoSuchRegisterException, OverFlowException {
		if(instruc == null)
			throw new NoSuchInstructionException("No such instruchtion found");
		
		String opc = instruc.getOpcode();
		String[] address_String = instruc.getRest().split(",");
		String[] rs_mem;
		String rs,rt,rd,label;
		int shiftAmount;
		short address;

		switch (opc.toLowerCase()) {
		case "add":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Add(rs, rt, rd);
			
		case "addi":
			rs = address_String[1];
			rt = address_String[0];
			if (Integer.parseInt(address_String[2]) > Short.MAX_VALUE ||
				Integer.parseInt(address_String[2]) < Short.MIN_VALUE ) 
				throw new OverFlowException("");
			address = (short)Integer.parseInt(address_String[2],16);
			return new Addi(rs, rt, address);
			
		case "and":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new And(rs, rt, rd);
			
		case "andi":
			rs = address_String[1];
			rt = address_String[0];
			if (Integer.parseInt(address_String[2]) > Short.MAX_VALUE ||
				Integer.parseInt(address_String[2]) < Short.MIN_VALUE ) 
				throw new OverFlowException("");
			address = (short)Integer.parseInt(address_String[2],16);
			return new Andi(rs, rt, address);

		case "beq":
			rs = address_String[0];
			rt = address_String[1];
			label = address_String[2];
			return new Beq(rs, rt, label);
			
		case "bne":
			rs = address_String[0];
			rt = address_String[1];
			label = address_String[2];
			return new Bne(rs, rt, label);

		case "j":
			label = address_String[0];
			return new J(label);
			
		case "jal":
			label = address_String[0];
			return new Jal(label);
			
		case "jr":
			return new Jr();
			
		case "lw":
			rt = address_String[0];
			rs_mem = address_String[1].split("(");
			address = (short) Integer.parseInt(rs_mem[0],16);
			rs = rs_mem[1].substring(0, rs_mem[1].length()-1);
			return new Lw(rs, rt, address);
			
		case "nor":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Nor(rs, rt, rd);
			
		case "or":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Or(rs, rt, rd);
			
		case "ori":
			rs = address_String[1];
			rt = address_String[0];
			if (Integer.parseInt(address_String[2]) > Short.MAX_VALUE ||
				Integer.parseInt(address_String[2]) < Short.MIN_VALUE ) 
				throw new OverFlowException("");
			address = (short)Integer.parseInt(address_String[2],16);
			return new Ori(rs, rt, address);
			
		case "sll":
			rs = address_String[1];
			rd = address_String[0];
			shiftAmount = Integer.parseInt(address_String[0]);
			return new Sll(rs, "", rd, shiftAmount);
			
		case "slt":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Slt(rs, rt, rd);
			
		case "sltu":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Sltu(rs, rt, rd);
			
		case "srl":
			rs = address_String[1];
			rd = address_String[0];
			shiftAmount = Integer.parseInt(address_String[0]);
			return new Srl(rs, "", rd, shiftAmount);
			
		case "sub":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			return new Sub(rs, rt, rd);

		case "sw":
			rt = address_String[0];
			rs_mem = address_String[1].split("(");
			address = (short) Integer.parseInt(rs_mem[0],16);
			rs = rs_mem[1].substring(0, rs_mem[1].length()-1);
			return new Lw(rs, rt, address);

		default:
			throw new NoSuchInstructionException("No such instruchtion found");
		}
	}
	
}
