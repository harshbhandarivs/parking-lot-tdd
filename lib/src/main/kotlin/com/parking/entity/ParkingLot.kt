package com.parking.entity

import com.parking.exception.InsufficientParkingSpaceException
import java.util.*
import kotlin.math.ceil

class ParkingLot(
    private val parkingSpots: Array<ParkingSpot> = parkingSpotsInit()
) {
    private val milliSecondInHours = 3_600_000
    private val perHourFee = 10

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
        val fee = calculateNumberOfHours(entryTime, exitTime) * perHourFee
        return Receipt(receiptId++, entryTime, exitTime, fee)
    }

    private fun calculateNumberOfHours(entryTime: Date, exitTime: Date): Long {
        return ceil((exitTime.time - entryTime.time).toDouble() / milliSecondInHours).toLong()
    }

}

private fun parkingSpotsInit() = Array(100) { ParkingSpot(it.toUInt(), true) }
