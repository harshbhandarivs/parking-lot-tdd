package com.parking.parking_lot

import com.parking.exception.InsufficientParkingSpaceException
import com.parking.parking_lot.spot.ParkingSpot
import com.parking.ticket.Ticket
import com.parking.vehicle.Vehicle
import java.util.*

class ParkingLot(private val parkingSpots: Array<ParkingSpot> = Array(100) { ParkingSpot(it.toUInt(), true) }) {

    private var ticketId = 1u
    fun getParkingSpots(): Array<ParkingSpot> = parkingSpots
    fun parkVehicle(vehicle: Vehicle, entryTime: Date = Date()): Ticket {
        val parkingSpot: ParkingSpot = getAvailableParkingSpot()
        parkingSpot.occupy()
        return Ticket(ticketId++, vehicle, parkingSpot, entryTime)
    }

    private fun getAvailableParkingSpot(): ParkingSpot {
        for(parkingSpot in parkingSpots) {
            if(parkingSpot.getAvailability())
                return parkingSpot
        }
        throw InsufficientParkingSpaceException("Insufficient parking space")
    }

}
