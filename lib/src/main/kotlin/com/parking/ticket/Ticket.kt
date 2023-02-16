package com.parking.ticket

import com.parking.parking_lot.spot.ParkingSpot
import com.parking.vehicle.Vehicle
import java.text.SimpleDateFormat
import java.util.*

data class Ticket(
    private val id: UInt,
    private val vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    val entryTime: Date
) {
    fun getId(): UInt = id

    fun printTicket(): String {
        val simpleDateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
        val formattedEntryTime = simpleDateFormat.format(entryTime)
        return """Parking Ticket:
            Ticket Number: $id
            Spot Number: ${parkingSpot.getId()}
            Entry Date-time: $formattedEntryTime
        """.trimMargin()
    }
}