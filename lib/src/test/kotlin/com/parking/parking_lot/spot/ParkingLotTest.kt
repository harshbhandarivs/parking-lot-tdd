package com.parking.parking_lot.spot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingLotTest {
    @Test
    fun `Should create parking lot with 100 spots`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }
        val parkingLot = ParkingLot(parkingSpots)

        assertEquals(parkingSpots, parkingLot.getParkingSpots())
    }
}