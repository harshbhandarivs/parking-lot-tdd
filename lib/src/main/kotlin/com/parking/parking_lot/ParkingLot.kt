package com.parking.parking_lot

import com.parking.exception.InsufficientParkingSpaceException
import com.parking.parking_lot.spot.ParkingSpot
import com.parking.receipt.Receipt
import com.parking.ticket.Ticket
import com.parking.vehicle.Vehicle
import java.util.*
import kotlin.math.ceil

class ParkingLot(private val parkingSpots: Array<ParkingSpot> = Array(100) { ParkingSpot(it.toUInt(), true) }) {

    private var ticketId = 1u
    private var receiptId = 1u
    fun getParkingSpots(): Array<ParkingSpot> = parkingSpots
    fun parkVehicle(vehicle: Vehicle, entryTime: Date = Date()): Ticket {
        val parkingSpot: ParkingSpot = getAvailableParkingSpot()
        parkingSpot.occupy()
        return Ticket(ticketId++, vehicle, parkingSpot.getId(), entryTime)
    }

    private fun getAvailableParkingSpot(): ParkingSpot {
        for (parkingSpot in parkingSpots) {
            if (parkingSpot.getAvailability())
                return parkingSpot
        }
        throw InsufficientParkingSpaceException("Insufficient parking space")
    }

    fun unParkVehicle(ticket: Ticket, exitTime: Date = Date()): Receipt {
        parkingSpots[ticket.parkingSpotNumber.toInt()].vacate()
        val entryTime = ticket.entryTime
        val fee = calculateNumberOfHours(entryTime, exitTime) * 10
        return Receipt(receiptId++, entryTime, exitTime, fee)
    }

    private fun calculateNumberOfHours(entryTime: Date, exitTime: Date): Long {
        return ceil((exitTime.time - entryTime.time).toDouble() / 3_600_000).toLong()
    }

}
