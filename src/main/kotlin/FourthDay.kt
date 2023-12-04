import utils.BaseClass

class FourthDay(private val input: List<String>, day: Int) : BaseClass(day) {

    override fun firstChallenge() {
        super.firstChallenge()

        val pattern = "(?=( \\d+))".toRegex()

        var sum = 0


        input.forEach { game ->
            val part1 = game.substringAfter(":").substringBefore("|")
            val part2 = game.substringAfter("|")
            val filtered = pattern.findAll(part1)


            val plop = filtered.map { matchResult ->
                matchResult.groupValues.filter { it.isNotEmpty() }
            }.toList().flatten().map {
                val supSpace = it.replace(" ", "")
                supSpace
            }

            println(plop)
            val ploup = part2.split(" ").filter { it.isNotEmpty() }

            println(ploup)

            var power = 0

            plop.forEach {
                if (ploup.contains(it)) {
                    if (power == 0) {
                        power = 1
                    } else {
                        power *= 2
                    }
                    println(power)
                }
            }

            println()
            sum += power
            println(sum)
            println()
        }

        println(sum)
    }

    override fun secondChallenge() {
        super.secondChallenge()
    }
}