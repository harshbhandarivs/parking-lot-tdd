package com.parking.entity

import com.parking.entity.Vehicle
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VehicleTest {
    @Test
    fun `Create a vehicle`() {
        val vehicle = Vehicle()

        val type = vehicle.type

        assertEquals("CAR", type)
    }
}
