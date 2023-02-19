package com.parking.entity

import com.parking.exception.InsufficientParkingSpaceException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Instant
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

        assertEquals(Ticket(1u, vehicle, parkingSpots[0].getId(), entryTime), ticket)
    }

    @Test
    fun `Should throw error if parking space is not available`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }
        val parkingLot = ParkingLot(parkingSpots)
        val vehicle = Vehicle()
        val entryTime = Date()

        assertFailsWith<InsufficientParkingSpaceException> {
            repeat(101) {
                println(
                    parkingLot.parkVehicle(
                        vehicle,
                        entryTime
                    )
                )
            }
        }
    }

    @Test
    fun `Should unPark vehicle and generate receipt with fees`() {
        val parkingSpots = Array(100) { ParkingSpot(it.toUInt(), true) }
        val parkingLot = ParkingLot(parkingSpots)
        val vehicle = Vehicle()
        val entryTime = Date.from(Instant.parse("2007-12-03T10:15:30.00Z"))
        val exitTime = Date.from(Instant.parse("2007-12-03T15:15:31.00Z"))
        val ticket = parkingLot.parkVehicle(vehicle, entryTime)

        val receipt: Receipt = parkingLot.unParkVehicle(ticket, exitTime)

        assertEquals(Receipt(1u, entryTime, exitTime, 60), receipt)
    }
}
