package ru.netology

import countCommission
import checkLimitsThenOutput
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun countCommission_MasterCardAndMinCurrentMonthAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "MasterCard"
        val transferAmount: Long = 100_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(0, result)
    }

    @Test
    fun countCommission_MasterCardAndMaxCurrentMonthAmount() {
        val currentMonthAmount: Long = 75_000_00
        val cardOrAccountType = "MasterCard"
        val transferAmount: Long = 100_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(2060, result)
    }

    @Test
    fun countCommission_MaestroAndMinCurrentMonthAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Maestro"
        val transferAmount: Long = 100_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(0, result)
    }

    @Test
    fun countCommission_MaestroAndMaxCurrentMonthAmount() {
        val currentMonthAmount: Long = 75_000_00
        val cardOrAccountType = "Maestro"
        val transferAmount: Long = 100_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(2060, result)
    }

    @Test
    fun countCommission_VisaAndMinTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 1_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(3500, result)
    }

    @Test
    fun countCommission_VisaAndMaxTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 4_666_67

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(3525, result)
    }

    @Test
    fun countCommission_MirAndMinTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Мир"
        val transferAmount: Long = 1_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(3500, result)
    }

    @Test
    fun countCommission_MirAndMaxTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Мир"
        val transferAmount: Long = 4_666_67

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(3525, result)
    }

    @Test
    fun countCommission_VKPay() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Счет VK Pay"
        val transferAmount: Long = 100_00

        val result = countCommission(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(0, result)
    }

    @Test
    fun checkLimitsThenOutput_VisaAndMinCurrentMonthAmountAndMinTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 1_00

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Комиссия составит 3500 копеек", result)
    }

    @Test
    fun checkLimitsThenOutput_VisaAndMaxCurrentMonthAmountAndMaxTransferAmount() {
        val currentMonthAmount: Long = 600_000_01
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 150_000_01

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }

    @Test
    fun checkLimitsThenOutput_VisaAndMinCurrentMonthAmountAndMaxTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 150_000_01

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }

    @Test
    fun checkLimitsThenOutput_VisaAndMaxCurrentMonthAmountAndMinTransferAmount() {
        val currentMonthAmount: Long = 600_000_01
        val cardOrAccountType = "Visa"
        val transferAmount: Long = 1_00

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }

    @Test
    fun checkLimitsThenOutput_VKPayMinCurrentMonthAmountAndMinTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Счет VK Pay"
        val transferAmount: Long = 1_00

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Комиссия составит 0 копеек", result)
    }

    @Test
    fun checkLimitsThenOutput_VKPayMaxCurrentMonthAmountAndMaxTransferAmount() {
        val currentMonthAmount: Long = 40_000_01
        val cardOrAccountType = "Счет VK Pay"
        val transferAmount: Long = 15_000_01

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }

    @Test
    fun checkLimitsThenOutput_VKPayMinCurrentMonthAmountAndMaxTransferAmount() {
        val currentMonthAmount: Long = 0
        val cardOrAccountType = "Счет VK Pay"
        val transferAmount: Long = 15_000_01

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }

    @Test
    fun checkLimitsThenOutput_VKPayMaxCurrentMonthAmountAndMinTransferAmount() {
        val currentMonthAmount: Long = 40_000_01
        val cardOrAccountType = "Счет VK Pay"
        val transferAmount: Long = 1_00

        val result = checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount)

        assertEquals(0, result)
    }
}