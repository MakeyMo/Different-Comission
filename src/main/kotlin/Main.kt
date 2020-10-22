import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    var currentMonthAmount: Long = 0
    val cardOrAccountType: String
    val transferAmount: Long

    fun countCommission(currentMonthAmount: Long, cardOrAccountType: String, transferAmount: Long): Long {
        val comission: Long
        if(cardOrAccountType == "MasterCard" || cardOrAccountType == "Maestro") {
            return if (currentMonthAmount < 75_000_00) {
                0
            } else {
                comission = transferAmount / 1_000 * 6 + 20_00
                comission
            }
        }
        else if (cardOrAccountType == "Visa" || cardOrAccountType == "Мир") {
            return if (transferAmount < 4_666_67) {
                35_00
            } else {
                comission = transferAmount / 10_000 * 75
                comission
            }
        }
        else {
            return 0
        }
    }

    fun checkLimitsThenOutput(currentMonthAmount: Long, cardOrAccountType: String, transferAmount: Long): String {
        return if (((cardOrAccountType == "Visa" || cardOrAccountType == "MasterCard" || cardOrAccountType == "Maestro"
            || cardOrAccountType == "Мир") && currentMonthAmount <= 600_000_00 && transferAmount <= 150_000_00)
            || (cardOrAccountType == "Счет VK Pay" && currentMonthAmount <= 40_000_00 && transferAmount <= 15_000_00)) {
            "Комиссия составит ${countCommission(currentMonthAmount, cardOrAccountType, transferAmount)} копеек"
        } else {
            "Извините, но вы не укладываетесь в лимиты :("
        }
    }

    println("Введите тип карты/счета (Visa / MasterCard / Maestro / Мир / Счет VK Pay)")
    cardOrAccountType = scanner.nextLine()
    println("На какую сумму вы уже совершали переводы в этом месяце?")
    currentMonthAmount = scanner.nextLong()
    println("Ввведите сумму перевода в копейках")
    transferAmount = scanner.nextLong()
    println(checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount))
}