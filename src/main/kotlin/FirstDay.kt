import java.io.File


object FirstDay {
    fun firstChall() {
        val list = mutableListOf<String>()
        var sum = 0

        File("ListCoord").forEachLine {text ->
            if (text.contains(Regex("\\d"))){
                sum += sum(text)
            }
        }
        println("firstChall: $sum")
    }

    fun secondChall() {
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

        File("ListCoord").forEachLine {

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

        println("SecondChall : $sum")
    }

    enum class IntString(val text: String, val number: Int) {
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


    private fun sum(text: String) =
        (text.toList().first { c -> c.isDigit() }.toString() + text.toList().reversed().first { c -> c.isDigit() }
            .toString()).toInt()
}