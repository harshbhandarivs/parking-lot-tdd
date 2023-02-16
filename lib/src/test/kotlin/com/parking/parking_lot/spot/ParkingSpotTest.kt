package com.parking.parking_lot.spot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotTest {
    @Test
    fun `Should create a parking spot with a spot number and availability`() {
        val one: UInt = 1u
        val isAvailable = true

        val parkingSpot = ParkingSpot(one, isAvailable)

        assertEquals(one, parkingSpot.getId())
        assertEquals(isAvailable, parkingSpot.getAvailability())
    }
}