package com.parking.parking_lot.spot

data class ParkingSpot(
    private val id: UInt,
    private var isAvailable: Boolean
) {
    fun getId(): UInt = id
    fun getAvailability(): Boolean = isAvailable

    fun occupy() {
        isAvailable = false
    }

    fun vacate() {
        isAvailable = true
    }

}
