package com.mowitnow.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    int x;
    int y;
    Direction direction;

    public Position move(Pelouse pelouse) {
        return switch (direction) {
            case N -> this.toBuilder().y(y + 1 > pelouse.y ? y : y + 1).build();
            case E -> this.toBuilder().x(x + 1 > pelouse.x ? x : x + 1).build();
            case W -> this.toBuilder().x(Math.max(x - 1, 0)).build();
            case S -> this.toBuilder().y(Math.max(y - 1, 0)).build();
        };
    }

    public Position changeDirection(Instruction instruction) {
        Direction newDirection = this.direction;
        switch (instruction) {
            case D -> {
                switch (direction) {
                    case N -> newDirection = Direction.E;
                    case E -> newDirection = Direction.S;
                    case S -> newDirection = Direction.W;
                    case W -> newDirection = Direction.N;
                }
            }
            case G -> {
                switch (direction) {
                    case N -> newDirection = Direction.W;
                    case E -> newDirection = Direction.N;
                    case S -> newDirection = Direction.E;
                    case W -> newDirection = Direction.S;
                }
            }
        }
        return this.toBuilder().direction(newDirection).build();
    }


}
