package com.parking.ticket

import com.parking.parking_lot.spot.ParkingSpot
import com.parking.vehicle.Vehicle
import java.util.*

data class Ticket(
    private val id: UInt,
    private val vehicle: Vehicle,
    private val parkingSpot: ParkingSpot,
    val entryTime: Date
) {
    fun getId(): UInt = id
}