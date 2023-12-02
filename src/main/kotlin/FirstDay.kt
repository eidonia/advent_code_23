import utils.BaseClass

class FirstDay(private val input: List<String>, day: Int) : BaseClass(day) {

    override fun firstChallenge() {
        super.firstChallenge()
        var sum = 0
        input.forEach { text ->
            if (text.contains(Regex("\\d"))) {
                sum += sum(text)
            }
        }
        println(sum)
    }

    override fun secondChallenge() {
        super.secondChallenge()

        val listOfNumber = listOf(
            IntString.ONE.text,
            IntString.TWO.text,
            IntString.THREE.text,
            IntString.FOUR.text,
            IntString.FIVE.text,
            IntString.SIX.text,
            IntString.SEVEN.text,
            IntString.EIGHT.text,
            IntString.NINE.text
        )

        var sum = 0
        val pattern = "(?=(\\d|one|two|three|four|five|six|seven|eight|nine))".toRegex()

        input.forEach {
            val sumList = pattern.findAll(it).map {
                it.groupValues.filter {
                    it.isNotEmpty()
                }
            }.toList()
                .flatten()
                .map { number ->
                    if (listOfNumber.contains(number)) {
                        IntString.valueOf(number.uppercase()).number.toString()
                    } else {
                        number
                    }
                }.toString()
            sum += sum(sumList)

        }

        println(sum)

    }

    private fun sum(text: String) =
        (text.toList().first { c -> c.isDigit() }.toString() + text.toList().reversed().first { c -> c.isDigit() }
            .toString()).toInt()

    private enum class IntString(val text: String, val number: Int) {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9)
    }

}