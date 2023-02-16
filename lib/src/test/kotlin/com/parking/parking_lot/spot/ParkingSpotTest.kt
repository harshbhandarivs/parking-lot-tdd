package com.parking.parking_lot.spot

import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `Should occupy parking spot and check its availability`() {
        val parkingSpot = ParkingSpot(1u, true)

        parkingSpot.occupy()

        assertEquals(false, parkingSpot.getAvailability())
    }

    @Test
    fun `Should vacate parking spot and check its availability`() {
        val parkingSpot = ParkingSpot(1u, true)
        parkingSpot.occupy()

        parkingSpot.vacate()

        assertEquals(true, parkingSpot.getAvailability())
    }
}
