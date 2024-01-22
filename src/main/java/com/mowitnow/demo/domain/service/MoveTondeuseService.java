package com.mowitnow.demo.domain.service;

import com.mowitnow.demo.domain.Instruction;
import com.mowitnow.demo.domain.Pelouse;
import com.mowitnow.demo.domain.Tondeuse;
import com.mowitnow.demo.domain.port.outbound.GetInstructionPort;
import com.mowitnow.demo.domain.port.outbound.GetPelousePort;
import com.mowitnow.demo.domain.port.outbound.GetTondeusePort;
import com.mowitnow.demo.domain.port.outbound.inbound.MoveTondeuseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
public class MoveTondeuseService implements MoveTondeuseUseCase {
    private final GetTondeusePort getTondeusePort;
    private final GetInstructionPort getInstructionPort;
    private final GetPelousePort getPelousePort;

    @Override
    public List<Tondeuse> moveTondeuses() throws IOException {
        Pelouse pelouse = getPelousePort.getPelouse();
        List<Tondeuse> tondeuseList = getTondeusePort.getAllTondeuse();
        List<List<Instruction>> instructionList = getInstructionPort.getAllInstruction();
        Iterator<Tondeuse> iteratorMower = tondeuseList.iterator();
        Iterator<List<Instruction>> iteratorInstructions = instructionList.iterator();
        while (iteratorInstructions.hasNext() && iteratorMower.hasNext()){
            List<Instruction> instruction = iteratorInstructions.next();
            Tondeuse tondeuse = iteratorMower.next();
            tondeuse.exucute(instruction,pelouse);
        }
        return tondeuseList;
    }
}
