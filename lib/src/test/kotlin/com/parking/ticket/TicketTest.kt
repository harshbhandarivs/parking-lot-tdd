package com.parking.ticket

import com.parking.parking_lot.spot.ParkingSpot
import com.parking.vehicle.Vehicle
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*
import kotlin.test.assertEquals

class TicketTest {
    @Test
    fun `Should create ticket with given time, vehicle and spot number`() {
        val id = 1u
        val parkingSpot = ParkingSpot(1u, false)
        val entryTime = Date()

        val ticket = Ticket(id, Vehicle(), parkingSpot.getId(), entryTime)

        assertEquals(id, ticket.getId())
        assertEquals(entryTime, ticket.entryTime)
    }

    @Test
    fun `Should print ticket in right format`() {
        val id = 1u
        val parkingSpot = ParkingSpot(1u, false)
        val entryTime = Date.from(Instant.parse("2007-12-03T10:15:30.00Z"))
        val vehicle = Vehicle()
        val ticket = Ticket(id, vehicle, parkingSpot.getId(), entryTime)

        val printTicket = ticket.printTicket()

        assertEquals(
            printTicket,
            """Parking Ticket:
            Ticket Number: 1
            Spot Number: 1
            Entry Date-time: 03-Dec-2007 15:45:30
        """.trimMargin()
        )
    }
}