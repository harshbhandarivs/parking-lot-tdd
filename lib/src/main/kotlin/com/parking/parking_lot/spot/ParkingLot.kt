package com.parking.parking_lot.spot

class ParkingLot(private val parkingSpots: Array<ParkingSpot> = Array(100) { ParkingSpot(it.toUInt(), true) }) {
    fun getParkingSpots(): Array<ParkingSpot> = parkingSpots

}