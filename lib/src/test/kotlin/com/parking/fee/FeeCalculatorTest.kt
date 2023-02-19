package com.parking.fee

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.Instant
import java.util.*

class FeeCalculatorTest {

    @ParameterizedTest(name = "{index} => entryTime={0}, exitTime={1}, expectedFee={2}")
    @MethodSource("calculation")
    fun `Calculate fee for given entry and exit date and time`(entryTime: Date, exitTime: Date, expectedFee: Long) {
        assertEquals(expectedFee, FeeCalculator().calculateFee(entryTime, exitTime))
    }

    companion object {
        @JvmStatic
        fun calculation() = listOf(
            Arguments.of(
                Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
                Date.from(Instant.parse("2007-12-03T15:15:31.00Z")),
                60L
            ),
            Arguments.of(
                Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
                Date.from(Instant.parse("2007-12-03T15:15:30.00Z")),
                50L
            ),
            Arguments.of(
                Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
                Date.from(Instant.parse("2007-12-03T10:15:31.00Z")),
                10L
            )
        )
    }
}