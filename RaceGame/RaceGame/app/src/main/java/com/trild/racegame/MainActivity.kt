package com.trild.racegame

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.core.view.isInvisible
import com.trild.racegame.databinding.ActivityMainBinding
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countDownTimer: CountDownTimer
    //private var score by Delegates.notNull<Int>()
    private var score :Int = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //fix screen LandScape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)
        methodCheckBox()
        init()
    }
    private fun init() {
        countDownTimer = object : CountDownTimer(6000,200){
            override fun onTick(millisUntilFinished: Long) {
                //score = Integer.parseInt(binding.txtViewNumber.text.toString())
                //Set Radom number
                var randomOne =  Random.nextInt(3, 10)
                var randomTwo =  Random.nextInt(3, 10)
                var randomThree =  Random.nextInt(3, 10)
                //Calculator
                var seakBarSet = binding.apply {
                    skbOne.setProgress(skbOne.progress + randomOne)
                    skbTwo.setProgress(skbTwo.progress + randomTwo)
                    skbThree.setProgress(skbThree.progress + randomThree)
                    methodRace(ckbOne,skbOne)
                    methodRace(ckbTwo,skbTwo)
                    methodRace(ckbThree,skbThree)
                    txtViewNumber.setText(score.toString())
                }
            }
            override fun onFinish() {
            }
        }
        binding.btnAction.setOnClickListener() {
            it.isInvisible
            binding.apply {
                if (ckbOne.isChecked || ckbTwo.isChecked || ckbThree.isChecked){
                    countDownTimer.start()
                    btnAction.visibility = View.INVISIBLE
                    skbOne.setProgress(0)
                    skbTwo.setProgress(0)
                    skbThree.setProgress(0)
                    lockCheckBox(true)
                }else{
                    Toast.makeText(this@MainActivity,"Please Bet!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.apply {
            skbOne.setEnabled(false);
            skbTwo.setEnabled(false);
            skbThree.setEnabled(false);
        }
    }
    private var selectionCheckBox = CompoundButton.OnCheckedChangeListener(){ compoundButton: CompoundButton, b: Boolean ->
        when(compoundButton.id){
            R.id.ckbOne -> if (b) {
                binding.ckbTwo.isChecked = !b
                binding.ckbThree.isChecked = !b
            }
            R.id.ckbTwo -> if (b) {
                binding.ckbOne.isChecked = !b
                binding.ckbThree.isChecked = !b
            }
            R.id.ckbThree -> if (b) {
                binding.ckbOne.isChecked = !b
                binding.ckbTwo.isChecked = !b
            }
            else-> {
            }
            }
        }

    fun methodCheckBox() {
        var method = binding.apply {
            ckbOne.setOnCheckedChangeListener(selectionCheckBox)
            ckbTwo.setOnCheckedChangeListener(selectionCheckBox)
            ckbThree.setOnCheckedChangeListener(selectionCheckBox)
        }
    }
    fun methodRace(checkBox: CheckBox, seakBar: SeekBar){
        if(seakBar.progress >= seakBar.max){
            countDownTimer.cancel()
            lockCheckBox(false)
            binding.btnAction.visibility = View.VISIBLE
            if (checkBox.isChecked){
                Toast.makeText(this@MainActivity,"You Win!",Toast.LENGTH_SHORT).show()
                score += 10
            }else{
                Toast.makeText(this@MainActivity,"You Over!",Toast.LENGTH_SHORT).show()
                score -= 5
            }
        }
    }
    private fun lockCheckBox(lock: Boolean){
        binding.apply {
            ckbOne.isEnabled = !lock
            ckbTwo.isEnabled = !lock
            ckbThree.isEnabled = !lock
        }
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/
}