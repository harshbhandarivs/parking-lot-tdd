package com.parking.fee

import java.util.*
import kotlin.math.ceil

class FeeCalculator {

    private val milliSecondInHours = 3_600_000
    private val perHourFee = 10

    fun calculateFee(entryTime: Date, exitTime: Date): Long =
        calculateNumberOfHours(entryTime, exitTime) * perHourFee

    private fun calculateNumberOfHours(entryTime: Date, exitTime: Date): Long {
        return ceil((exitTime.time - entryTime.time).toDouble() / milliSecondInHours).toLong()
    }
}