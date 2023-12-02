import utils.BaseClass

class SecondDay(private val input: List<String>, day: Int) : BaseClass(day) {

    override fun firstChallenge() {
        super.firstChallenge()

        val pattern = "(?=(\\d+ red|\\d+ blue|\\d+ green|))".toRegex()
        var sum = 0

        input.forEachIndexed { index, line ->

            val plopMap = mutableMapOf<String, MutableList<Int>>()
            val filtered = pattern.findAll(line)

            val num = index + 1

            filtered.map { matchResult ->
                matchResult.groupValues.filter { it.isNotEmpty() }
            }.toList()
                .flatten().map { text ->
                    val list = text.split(" ")
                    if (!plopMap.containsKey(list[1])) {
                        plopMap[list[1]] = mutableListOf()
                    }
                    plopMap[list[1]]?.add(list[0].toInt())
                }

            if (plopMap["red"]?.max()!! <= 12 && plopMap["blue"]?.max()!! <= 14 && plopMap["green"]?.max()!! <= 13) {
                sum += num
            }
        }
        println(sum)
    }

    override fun secondChallenge() {
        super.secondChallenge()

        val pattern = "(?=(\\d+ red|\\d+ blue|\\d+ green|))".toRegex()
        var sum = 0

        input.forEach {
            val plopMap = mutableMapOf<String, MutableList<Int>>()
            val filtered = pattern.findAll(it)

            filtered.map { matchResult ->
                matchResult.groupValues.filter { it.isNotEmpty() }
            }.toList()
                .flatten().map { text ->
                    val list = text.split(" ")
                    if (!plopMap.containsKey(list[1])) {
                        plopMap[list[1]] = mutableListOf()
                    }
                    plopMap[list[1]]?.add(list[0].toInt())
                }

            val higherBlue = plopMap["blue"]?.maxOrNull() ?: 0
            val higherRed = plopMap["red"]?.maxOrNull() ?: 0
            val higherGreen = plopMap["green"]?.maxOrNull() ?: 0
            val power = higherBlue * higherRed * higherGreen

            sum += power
        }

        println(sum)
    }

}