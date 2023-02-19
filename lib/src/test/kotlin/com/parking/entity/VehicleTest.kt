package com.parking.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VehicleTest {
    @Test
    fun `Create a vehicle`() {
        val vehicle = Vehicle()

        val type = vehicle.type

        assertEquals("CAR", type)
    }
}
