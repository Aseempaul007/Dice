package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val arrayOfDice = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
        )
        var playerOneScore = 0
        var playerTwoScore = 0
        var status = true

        binding.button.setOnClickListener {
            val randomNum = (1..6).random()
            binding.imageView.setImageResource(arrayOfDice[randomNum-1])
            if(status){
                playerOneScore += randomNum
                if(playerOneScore>=100){
                    binding.button.visibility= View.INVISIBLE
                    binding.result.visibility= View.VISIBLE
                    binding.result.text="Player 1 win"
                    binding.restart.visibility=View.VISIBLE
                }
                binding.playerOneScore.text=playerOneScore.toString()
                status=false
            }else{
                playerTwoScore += randomNum
                if(playerTwoScore>=100){
                    binding.button.visibility= View.INVISIBLE
                    binding.result.visibility= View.VISIBLE
                    binding.result.text="Player 2 win"
                    binding.restart.visibility=View.VISIBLE

                }
                binding.playerTwoScore.text=playerTwoScore.toString()
                status=true
            }

        }

        binding.restart.setOnClickListener {
            playerTwoScore=0
            playerOneScore=0
            binding.playerOneScore.text="Score"
            binding.playerTwoScore.text="Score"
            binding.result.visibility=View.INVISIBLE
        }


    }
}