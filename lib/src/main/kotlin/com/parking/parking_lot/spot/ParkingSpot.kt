package com.parking.parking_lot.spot

data class ParkingSpot(
    private val id: UInt,
    private val isAvailable: Boolean
) {
    fun getId(): UInt = id
    fun getAvailability(): Boolean = isAvailable

}