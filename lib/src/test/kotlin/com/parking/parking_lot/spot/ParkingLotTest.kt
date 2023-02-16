package com.parking.parking_lot.spot

import com.parking.exception.InsufficientParkingSpaceException
import com.parking.parking_lot.ParkingLot
import com.parking.ticket.Ticket
import com.parking.vehicle.Vehicle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFailsWith

class ParkingLotTest {
    @Test
    fun `Should create parking lot with 100 spots`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }

        val parkingLot = ParkingLot(parkingSpots)

        assertEquals(parkingSpots, parkingLot.getParkingSpots())
    }

    @Test
    fun `Should park vehicle and create ticket`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }
        val parkingLot = ParkingLot(parkingSpots)
        val vehicle = Vehicle()
        val entryTime = Date()

        val ticket = parkingLot.parkVehicle(vehicle, entryTime)

        assertEquals(Ticket(1u, vehicle, parkingSpots[0], entryTime), ticket)
    }

    @Test
    fun `Should throw error if parking space is not available`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }
        val parkingLot = ParkingLot(parkingSpots)
        val vehicle = Vehicle()
        val entryTime = Date()

        assertFailsWith<InsufficientParkingSpaceException> {
            repeat(101) {
                parkingLot.parkVehicle(
                    vehicle,
                    entryTime
                )
            }
        }
    }
}
