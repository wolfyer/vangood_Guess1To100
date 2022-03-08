package com.vangood.guess1to100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.vangood.guess1to100.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val game =GameNumber()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //var box = binding.edTextview.text.toString()
    fun startgame(view: View){
        var num : Int = binding.edNum.text.toString().toInt()
        binding.edTextview.text = game.compare(num)
        if (game.end) {
            AlertDialog.Builder(this)
                .setTitle("WIN the game")
                .setMessage("replay on more time?")
                .setPositiveButton("OK"){
                        d,w->game.restartval()
                    game.end = false
                    binding.edNum.setText("")
                }
                .show()
        }

    }

}