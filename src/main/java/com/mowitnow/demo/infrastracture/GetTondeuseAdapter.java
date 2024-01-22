package com.mowitnow.demo.infrastracture;

import com.mowitnow.demo.domain.Direction;
import com.mowitnow.demo.domain.Position;
import com.mowitnow.demo.domain.Tondeuse;
import com.mowitnow.demo.domain.port.outbound.GetTondeusePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class GetTondeuseAdapter implements GetTondeusePort {

    private final FileReader fileReader;



    @Override
    public List<Tondeuse> getAllTondeuse() throws IOException {
        return fileReader.getLines().stream().skip(1)
                .filter(GetTondeuseAdapter::isValid)
                .map(GetTondeuseAdapter::from).toList();
    }

    private static boolean isValid(String line) {
        return line != null && !line.isBlank() && line.split(" ").length == 3;
    }

    public static Tondeuse from(String s) {
        List<String> list = Arrays.asList(s.split(" "));
        Position position = Position.builder()
                .x(Integer.parseInt(list.get(0)))
                .y(Integer.parseInt(list.get(1)))
                .direction(Direction.valueOf(list.get(2)))
                .build();

        return Tondeuse.builder()
                .currentPosition(position)
                .initialPosition(position)
                .build();
    }
}
