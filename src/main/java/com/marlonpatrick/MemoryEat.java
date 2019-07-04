package com.marlonpatrick;

import java.util.ArrayList;
import java.util.List;

public class MemoryEat {

	public static void main(String[] args) {
        List<byte[]> l = new ArrayList<>();
        Integer memoryChunkInBytes = Integer.valueOf(args[0]);
        
        while (true) {
            l.add(new byte[memoryChunkInBytes]);
            ComputeResourceLimits.main(args);
        }
    }
}
