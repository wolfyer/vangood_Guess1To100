package com.vangood.guess1to100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vangood.guess1to100.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    var ans = (1..100).random()
    var min = 1
    var max = 100
    var count = 1
    var box = binding.edTextview.text.toString()
    fun startgame(view: View){
        var num : Int = binding.edNum.text.toString().toInt()
        if (num < ans){
            min = num
            box = "Is Bigger Than $num. Please try again.\n" +
                    "Select a number in $min to $max"
            count = count+1
        }else if (num > ans){
            max =num
            box = "Is Smaller Than $num. Please try again.\n" +
                    "Select a number in $min to $max"
            count = count+1
        }else if (num == ans){
            box = "Good Job! The Answer is $num \n You Spend $count Time To Win The Game."
            var ans = (1..100).random()

        }else{
            box = "Wrong ! Please try again."
            count = count+1
        }


    }

}