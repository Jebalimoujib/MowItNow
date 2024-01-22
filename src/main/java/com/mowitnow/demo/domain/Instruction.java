package com.mowitnow.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Instruction {

    D(true),G(true),A(false);

    private final boolean isDirection;

    public static boolean isValid(String strValue){
        return Stream.of(Instruction.values()).anyMatch(v -> v.name().equals(strValue));
    }
}
