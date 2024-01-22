package com.mowitnow.demo.application;

import com.mowitnow.demo.domain.Tondeuse;
import com.mowitnow.demo.domain.port.outbound.inbound.MoveTondeuseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsoleUi {
    private final MoveTondeuseUseCase moveTondeuseUseCase;

    public void printTondeuse() throws IOException {
        List<Tondeuse> tondeuses = moveTondeuseUseCase.moveTondeuses();
        tondeuses.forEach(System.out::println);
    }
}
