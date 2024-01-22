package com.mowitnow.demo.infrastracture;

import com.mowitnow.demo.domain.Instruction;
import com.mowitnow.demo.domain.port.outbound.GetInstructionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class GetInstructionAdapter implements GetInstructionPort {

    private FileReader fileReader;

    @Override
    public List<List<Instruction>> getAllInstruction() throws IOException {
        return fileReader.getLines().stream().skip(1).filter(GetInstructionAdapter::isValid)
                .map(inst ->
                        Arrays.stream(inst.split("")).map(Instruction::valueOf).toList()).toList()
                ;
    }

    private static boolean isValid(String line) {
        if (line != null && !line.isBlank()) {
            return Arrays.stream(line.split("")).allMatch(Instruction::isValid);
        }
        return false;
    }

}
