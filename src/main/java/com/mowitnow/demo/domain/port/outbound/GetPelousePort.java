package com.mowitnow.demo.domain.port.outbound;

import com.mowitnow.demo.domain.Pelouse;

import java.io.IOException;

public interface GetPelousePort {

    Pelouse getPelouse() throws IOException;
}
