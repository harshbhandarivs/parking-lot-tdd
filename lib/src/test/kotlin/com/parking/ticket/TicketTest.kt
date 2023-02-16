package com.parking.ticket

import com.parking.parking_lot.spot.ParkingSpot
import com.parking.vehicle.Vehicle
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class TicketTest {
    @Test
    fun `Should create ticket with given time, vehicle and spot number`() {
        val id = 1u
        val parkingSpot = ParkingSpot(1u, false)
        val entryTime = Date()

        val ticket = Ticket(id, Vehicle(), parkingSpot, entryTime)

        assertEquals(id, ticket.getId())
        assertEquals(entryTime, ticket.entryTime)
    }
}