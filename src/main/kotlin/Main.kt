import java.io.File

fun main(args: Array<String>) {
    FirstDay(File("ListCoord").readLines(), 1).apply {
        firstChallenge()
        secondChallenge()
    }

   SecondDay(File("ListGame").readLines(), 2).apply {
        firstChallenge()
        secondChallenge()
    }

    FourthDay(File("ListScratchCard").readLines(), 4).apply {
        firstChallenge()
    }


}


