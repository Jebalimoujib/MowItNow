package com.mowitnow.demo.infrastracture;

import com.mowitnow.demo.domain.Pelouse;
import com.mowitnow.demo.domain.port.outbound.GetPelousePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class GetPelouseAdapter implements GetPelousePort {

    private final FileReader fileReader;

    @Override
    public Pelouse getPelouse() throws IOException {
        String firstLine = fileReader.getLines().get(0);
        String[] split = firstLine.split(" ");
        return Pelouse.builder()
                .x(Integer.parseInt(split[0]))
                .y(Integer.parseInt(split[1]))
                .build();
    }
}
