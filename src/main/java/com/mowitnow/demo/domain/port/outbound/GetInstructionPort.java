package com.mowitnow.demo.domain.port.outbound;

import com.mowitnow.demo.domain.Instruction;

import java.io.IOException;
import java.util.List;

public interface GetInstructionPort {

    List<List<Instruction>> getAllInstruction() throws IOException;
}
