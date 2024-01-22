package com.mowitnow.demo.domain.service;

import com.mowitnow.demo.domain.Instruction;
import com.mowitnow.demo.domain.Pelouse;
import com.mowitnow.demo.domain.Tondeuse;
import com.mowitnow.demo.domain.port.outbound.GetInstructionPort;
import com.mowitnow.demo.domain.port.outbound.GetPelousePort;
import com.mowitnow.demo.domain.port.outbound.GetTondeusePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MoveTondeuseServiceTest {

    @Mock
    private GetTondeusePort mockGetTondeusePort;
    @Mock
    private GetInstructionPort mockGetInstructionPort;
    @Mock
    private GetPelousePort mockGetPelousePort;

    private MoveTondeuseService moveTondeuseServiceUnderTest;

    @BeforeEach
    void setUp() {
        moveTondeuseServiceUnderTest = new MoveTondeuseService(mockGetTondeusePort, mockGetInstructionPort,
                mockGetPelousePort);
    }

    @Test
    void testMoveTondeuses() throws Exception {
        // Setup
        final List<Tondeuse> expectedResult = List.of(Tondeuse.builder().build());
        when(mockGetPelousePort.getPelouse()).thenReturn(Pelouse.builder().build());
        when(mockGetTondeusePort.getAllTondeuse()).thenReturn(List.of(Tondeuse.builder().build()));
        when(mockGetInstructionPort.getAllInstruction()).thenReturn(List.of(List.of(Instruction.D)));

        // Run the test
        final List<Tondeuse> result = moveTondeuseServiceUnderTest.moveTondeuses();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testMoveTondeuses_GetPelousePortThrowsIOException() throws Exception {
        // Setup
        when(mockGetPelousePort.getPelouse()).thenThrow(IOException.class);

        // Run the test
        assertThatThrownBy(() -> moveTondeuseServiceUnderTest.moveTondeuses()).isInstanceOf(IOException.class);
    }

    @Test
    void testMoveTondeuses_GetTondeusePortReturnsNoItems() throws Exception {
        // Setup
        when(mockGetPelousePort.getPelouse()).thenReturn(Pelouse.builder().build());
        when(mockGetTondeusePort.getAllTondeuse()).thenReturn(Collections.emptyList());
        when(mockGetInstructionPort.getAllInstruction()).thenReturn(List.of(List.of(Instruction.D)));

        // Run the test
        final List<Tondeuse> result = moveTondeuseServiceUnderTest.moveTondeuses();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testMoveTondeuses_GetTondeusePortThrowsIOException() throws Exception {
        // Setup
        when(mockGetPelousePort.getPelouse()).thenReturn(Pelouse.builder().build());
        when(mockGetTondeusePort.getAllTondeuse()).thenThrow(IOException.class);

        // Run the test
        assertThatThrownBy(() -> moveTondeuseServiceUnderTest.moveTondeuses()).isInstanceOf(IOException.class);
    }

    @Test
    void testMoveTondeuses_GetInstructionPortReturnsNoItems() throws Exception {
        // Setup
        final List<Tondeuse> expectedResult = List.of(Tondeuse.builder().build());
        when(mockGetPelousePort.getPelouse()).thenReturn(Pelouse.builder().build());
        when(mockGetTondeusePort.getAllTondeuse()).thenReturn(List.of(Tondeuse.builder().build()));
        when(mockGetInstructionPort.getAllInstruction()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Tondeuse> result = moveTondeuseServiceUnderTest.moveTondeuses();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testMoveTondeuses_GetInstructionPortThrowsIOException() throws Exception {
        // Setup
        when(mockGetPelousePort.getPelouse()).thenReturn(Pelouse.builder().build());
        when(mockGetTondeusePort.getAllTondeuse()).thenReturn(List.of(Tondeuse.builder().build()));
        when(mockGetInstructionPort.getAllInstruction()).thenThrow(IOException.class);

        // Run the test
        assertThatThrownBy(() -> moveTondeuseServiceUnderTest.moveTondeuses()).isInstanceOf(IOException.class);
    }
}
