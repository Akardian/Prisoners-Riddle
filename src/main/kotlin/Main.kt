import prison.Prison

fun main(args: Array<String>) {
    println("Program arguments: ${args.joinToString()} \n")
    val prison = Prison()
    prison.printStats()

    var won = 0
    var lost = 0
    var played = 0
    val runNumber = 100000
    val repeat = 10
    println("\nNumber of Runs: ${runNumber * repeat} \n")

    for (int in 0 until repeat) {
        for (index in 1 .. runNumber) {
            prison.shuffle()
            if (prison.loopStrategy()) {
                won++
            }else {
                lost++
            }
            played++
        }

        val percentage = won.toDouble() / (lost + won)
        println("Played: $played, Wins: $won, Lost: $lost, Percentage Won: $percentage")
    }
}