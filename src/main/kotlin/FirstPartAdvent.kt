import java.io.File


object FirstPartAdvent {
    fun findDigit() {
        val list = mutableListOf<String>()

        val test = "nineeight1twone3"
        var sum = 0

        File("ListCoord").forEachLine {
            list.add(it)
        }

        list.filter { text -> text.contains(Regex("\\d")) }.forEach { text ->
            sum += sum(text)
        }

        println("sumAll: $sum")
    }

}

object SecondPartAdvent {
    fun findNumberWithDigitAndWord() {
        val list = mutableListOf<String>()
        var test = "two1nineightwo2one"
        val listofNumber = listOf(
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

        File("ListCoord").forEachLine {
            list.add(it)
        }

        val pattern = "(?=(\\d|one|two|three|four|five|six|seven|eight|nine))".toRegex()

        list.forEach {

            val pouet = pattern.findAll(it).map {
                it.groupValues.filter {
                    it.isNotEmpty()
                }
            }.toList()
                .flatten()
                .map { number ->
                    if (listofNumber.contains(number)) {
                        IntString.valueOf(number.uppercase()).number.toString()
                    } else {
                        number
                    }
                }.toString()
            sum += sum(pouet)
        }
        println(sum)
    }

    //53539
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

}


/*println("text: $text")
var coord = text
var plop: String
listofNumber.forEach {
    if (coord.contains(it.text)) {
        plop = coord.replace(it.text.dropLast(1).drop(1), "${it.number}")
        println("plop: $plop")
        coord = plop
    }
}
println("coord: $coord")
val filtered = coord.replace("[a-zA-Z]+".toRegex(), "")
println("filtre : $filtered")
sum += sum(filtered)
println("------------------")
}
println(sum)*/

internal fun sum(text: String) =
    (text.toList().first { c -> c.isDigit() }.toString() + text.toList().reversed().first { c -> c.isDigit() }
        .toString()).toInt()