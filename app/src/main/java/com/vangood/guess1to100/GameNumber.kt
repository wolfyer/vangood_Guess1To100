package com.vangood.guess1to100

class GameNumber {
    var ans :Int = 0
    var min = 1
    var max = 100
    var count = 0
    var end = false
    init {
        restartval()
    }

    fun compare(num :Int):String{
        count++
        var message = if (num <ans && min <= num) {
            min = num
            "Is Bigger Than $num. Please try again.\n Select a number in $min to $max"
        }else if (num > ans && max >= num) {
            max = num
            "Is Smaller Than $num. Please try again.\n Select a number in $min to $max"
        }else if (num == ans) {
            end = true
            "Good Job! The Answer is $num \n You Spend $count Time To Win The Game.\nChoose a new Number and Pause Bottom to start a new round"
        }else{"Wrong ! Please try again.\nSelect a number in $min to $max"}
        return message.toString()
    }
    fun restartval(){
        ans = (1..100).random()
        min = 1
        max = 100
        count = 0

    }

}