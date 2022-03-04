package com.vangood.guess1to100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    var box :String =""
    //var box = binding.edTextview.text.toString()
    fun startgame(view: View){
        var num : Int = binding.edNum.text.toString().toInt()
        if (num < ans && min <= num){
            min = num
            box = "Is Bigger Than $num. Please try again.\n" +
                    "Select a number in $min to $max"
            binding.edTextview.text = box
            count = count+1
        }else if (num > ans && max >= num){
            max =num
            box = "Is Smaller Than $num. Please try again.\n" +
                    "Select a number in $min to $max"
            binding.edTextview.text = box
            count = count+1
        }else if (num == ans){
            box = "Good Job! The Answer is $num \n You Spend $count Time To Win The Game."+
                    "\nChoose a new Number and Pause Bottom to start a new round"
            binding.edTextview.text = box
            ans = (1..100).random()
            min = 1
            max = 100
            count = 1

        }else{
            box = "Wrong ! Please try again.\nSelect a number in $min to $max"
            binding.edTextview.text = box
            count = count+1
        }


    }

}