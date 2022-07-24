package com.poecat.exercise;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinatesTest {

    @Test
    void constructorShouldFailIfAnyValueBelow0() {

        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 0));
    }

    @Test
    void constructorShouldFailIfAnyValueAbove100() {

        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 0));
    }

    @Test
    void copyShouldCreateNewObject() {

        //given
        Coordinates coordinates = new Coordinates(10, 10);

        //when
        Coordinates copyCoordinate = Coordinates.copy(coordinates, 0, 0);

        //then
        assertThat(copyCoordinate, not(sameInstance(coordinates)));
        assertThat(copyCoordinate, equalTo(coordinates));
    }

    @Test
    void copyShouldReturnSumOfCoordinatesValues() {

        //given
        Coordinates coordinates = new Coordinates(10, 10);

        //when
        Coordinates copyCoordinates = Coordinates.copy(coordinates, 12, 13);

        //then
        assertThat(copyCoordinates.getX(), equalTo(22));
        assertThat(copyCoordinates.getY(), equalTo(23));
    }

}
