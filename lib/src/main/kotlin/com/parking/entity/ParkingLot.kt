package com.parking.entity

import com.parking.exception.InsufficientParkingSpaceException
import com.parking.fee.FeeCalculator
import java.util.*

class ParkingLot(
    private val parkingSpots: Array<ParkingSpot> = parkingSpotsInit()
) {
    private val feeCalculator = FeeCalculator()

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
        val fee = feeCalculator.calculateFee(entryTime, exitTime)
        return Receipt(receiptId++, entryTime, exitTime, fee)
    }

}

private fun parkingSpotsInit() = Array(100) { ParkingSpot(it.toUInt(), true) }
