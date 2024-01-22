package com.mowitnow.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tondeuse {
    Position initialPosition;
    Position currentPosition;

    public void exucute(List<Instruction> instructions, Pelouse pelouse){
        instructions.forEach(instruction -> {
            if(instruction.isDirection()){
                this.currentPosition = currentPosition.changeDirection(instruction);
            }else {
                this.currentPosition = currentPosition.move(pelouse);
            }
        });
    }






}
