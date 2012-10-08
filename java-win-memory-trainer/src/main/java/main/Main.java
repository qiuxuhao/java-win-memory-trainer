package main;

import java.util.Arrays;

import com.sprogcoder.memory.JTrainer;
import com.sprogcoder.memory.MemoryUtils;
import com.sprogcoder.memory.exception.MemoryException;
import com.sprogcoder.memory.exception.WindowNotFoundException;

public class Main
{

	private static final int MEMORY_ADDRESS = 0x00010ABF;

	public static void main(String[] args) throws WindowNotFoundException, MemoryException
	{
		JTrainer jtrainer = new JTrainer(null, "Minesweeper");
		
		// Old Bytes
		jtrainer.writeProcessMemory(MEMORY_ADDRESS, new int[] { 0x22, 0x22, 0x22, 0x22 });
		byte[] oldBytes = jtrainer.readProcessMemory(MEMORY_ADDRESS, 4);
		System.out.println(Arrays.toString(MemoryUtils.convertByteArrayToHex(oldBytes)));
		
		// New Bytes
		jtrainer.writeProcessMemory(MEMORY_ADDRESS, new int[] { 0x90, 0x90, 0x90, 0x90 }); // nop, nop, nop, nop
		byte[] newBytes = jtrainer.readProcessMemory(MEMORY_ADDRESS, 4);
		System.out.println(Arrays.toString(MemoryUtils.convertByteArrayToHex(newBytes)));
	}
}
