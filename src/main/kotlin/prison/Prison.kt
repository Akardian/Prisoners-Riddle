package prison

import kotlin.math.ceil
import kotlin.math.log10
import kotlin.math.sqrt
import kotlin.random.Random

class Prison(
    boxNumber: Int = 100
) {
    private val boxArray = IntArray(boxNumber)
    private val inmates: ArrayList<Inmate>

    private val tries = boxNumber / 2
    //Pretty print
    private val boxNumberLength = (log10((boxNumber - 1).toDouble()) + 1).toInt()
    private val roomLength = ceil(sqrt(boxNumber.toDouble())).toInt()

    init {
        for (index in boxArray.indices) {
            boxArray[index] = index
        }

        inmates = ArrayList()
        for (index in 0 until boxNumber){
            inmates.add(Inmate(index))
        }


    }

    fun printPretty() {
        //Number of rooms before linebreak
        for (index in boxArray.indices) {
            //Break line if length reached ignore first 0
            if (index % roomLength == 0 && index != 0) {
                println()
            }

            val format = (boxArray[index].toString().padStart(boxNumberLength, '0'))
            print("$format ")
        }
    }

    fun printStats() {
        println("Create box room")
        println("Room size: ${boxArray.size}")
        println("Inmate count: ${inmates.size}")
        println("Room length: $roomLength")
        println("Box number length: $boxNumberLength")
        println("Max number of tries: $tries")
    }

    fun shuffle() {
        boxArray.shuffle()
    }

    fun shuffle(seed: Int) {
        boxArray.shuffle(Random(seed))
    }

    //All inmates have to find each name inside a box with limited amount of tries
    fun loopStrategy(): Boolean {
        for (inmate in inmates) {
            if (!checkBox(inmate)) {
                return false
            }
        }
        return true
    }

    private fun checkBox(inmate: Inmate): Boolean {
        //Open box with his own name as first try
        if (boxArray[inmate.name] == inmate.name) {
            return true
        }

        //Select start box
        var nextBox = boxArray[inmate.name]
        for (index in 1 until tries) {
            if (boxArray[nextBox] == inmate.name){
                return true
            } else {
                nextBox = boxArray[nextBox]
            }
        }
        return false
    }
}