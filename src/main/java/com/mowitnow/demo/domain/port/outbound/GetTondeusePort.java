package com.mowitnow.demo.domain.port.outbound;

import com.mowitnow.demo.domain.Tondeuse;

import java.io.IOException;
import java.util.List;

public interface GetTondeusePort {

    List<Tondeuse> getAllTondeuse() throws IOException;
}
