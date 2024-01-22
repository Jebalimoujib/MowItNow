package com.mowitnow.demo.domain.port.outbound.inbound;

import com.mowitnow.demo.domain.Tondeuse;

import java.io.IOException;
import java.util.List;

public interface MoveTondeuseUseCase {

    List<Tondeuse> moveTondeuses() throws IOException;
}
