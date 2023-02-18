package com.parking.entity

import java.text.SimpleDateFormat
import java.util.*

data class Ticket(
    private val id: UInt,
    private val vehicle: Vehicle,
    val parkingSpotNumber: UInt,
    val entryTime: Date
) {
    fun getId(): UInt = id

    fun printTicket(): String {
        val simpleDateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
        val formattedEntryTime = simpleDateFormat.format(entryTime)
        return """Parking Ticket:
            Ticket Number: $id
            Spot Number: $parkingSpotNumber
            Entry Date-time: $formattedEntryTime
        """.trimMargin()
    }
}