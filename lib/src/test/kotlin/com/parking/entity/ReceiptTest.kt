package com.parking.entity

import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*
import kotlin.test.assertEquals

class ReceiptTest {
    @Test
    fun `Should create receipt with given id, entryTime, exitTime and fee`() {
        val id = 1u
        val entryTime = Date.from(Instant.parse("2007-12-03T10:15:30.00Z"))
        val exitTime = Date.from(Instant.parse("2007-12-03T15:15:31.00Z"))
        val fee = 100L

        val receipt = Receipt(id, entryTime, exitTime, fee)

        assertEquals(1u, receipt.getId())
        assertEquals(entryTime, receipt.entryTime)
        assertEquals(exitTime, receipt.exitTime)
    }

    @Test
    fun `Should print receipt in right format`() {
        val receipt = Receipt(
            1u, Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
            Date.from(Instant.parse("2007-12-03T15:15:31.00Z")), 100
        )

        val printReceipt = receipt.printReceipt()

        assertEquals("""Parking Receipt:
            Receipt Number: R-1
            Entry Date-time: 03-Dec-2007 15:45:30
            Exit Date-time: 03-Dec-2007 20:45:31
            Fees: 100
        """.trimMargin(), printReceipt
        )
    }
}
