package com.trild.fromtwenty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import com.trild.fromtwenty.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        methodLangualCheckBox()
        methodTimeCheckBox()
    }
    private var timeCheckBox = CompoundButton.OnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
        binding.apply {
            when(compoundButton){
                ckbOneMonth -> if (b){
                    ckbSixMonth.isChecked = !b
                    ckbOneYear.isChecked = !b
                }
                ckbSixMonth -> if (b){
                    ckbOneYear.isChecked = !b
                    ckbOneMonth.isChecked = !b
                }
                ckbOneYear -> if (b){
                    ckbOneMonth.isChecked = !b
                    ckbSixMonth.isChecked = !b
                }
                else -> { }
            }
        }
    }
    private var langueCheckBox = CompoundButton.OnCheckedChangeListener{ buttonView: CompoundButton?, b: Boolean ->
        binding.apply {
            if (buttonView == ckbAllLangual){
                //lock check box
                ckbEnglish.isEnabled = !b
                ckbJapanese.isEnabled = !b
                ckbVietnamese.isEnabled = !b
                //unTick Check box
                if(ckbAllLangual.isChecked){
                    ckbEnglish.isChecked = !b
                    ckbJapanese.isChecked = !b
                    ckbVietnamese.isChecked = !b
                }
                //methodLangualCheckBox()
            } else if(ckbEnglish.isChecked && ckbJapanese.isChecked && ckbVietnamese.isChecked){
                ckbAllLangual.isChecked = b
            }
        }
    }
    private fun init(){
        binding.apply {
            btnOK.setOnClickListener {
                var chooseLangual : String = " + You are choose Langual : "
                var chooseProgramsLangual : String = " + You are choose program langual : "
                var chooseTimeLean : String = " + You are choose time lean : "
                if (ckbAllLangual.isChecked) chooseLangual = chooseLangual + "All Langual"
                if (ckbVietnamese.isChecked) chooseLangual = chooseLangual + "Vietnamese ,"
                if (ckbEnglish.isChecked) chooseLangual = chooseLangual + "English ,"
                if (ckbJapanese.isChecked) chooseLangual = chooseLangual + "Japanese ,"
                if (ckbOneMonth.isChecked) chooseTimeLean = chooseTimeLean + "One Month"
                if (ckbSixMonth.isChecked) chooseTimeLean = chooseTimeLean + "Six Month"
                if (ckbOneYear.isChecked) chooseTimeLean = chooseTimeLean + "One Year"
                if (rdbJava.isChecked) chooseProgramsLangual = chooseProgramsLangual + "Java"
                if (rdbFluter.isChecked) chooseProgramsLangual = chooseProgramsLangual + "Fluter"
                if (rdbKotlin.isChecked) chooseProgramsLangual = chooseProgramsLangual + "Kotlin"
                Toast.makeText(this@DemoActivity, "Your registration information: \n" + chooseLangual + "\n" + chooseProgramsLangual + "\n" + chooseTimeLean, Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun methodLangualCheckBox(){
        binding.apply {
            ckbAllLangual.setOnCheckedChangeListener(langueCheckBox)
            ckbEnglish.setOnCheckedChangeListener(langueCheckBox)
            ckbJapanese.setOnCheckedChangeListener(langueCheckBox)
            ckbVietnamese.setOnCheckedChangeListener(langueCheckBox)
        }
    }
    private fun methodTimeCheckBox(){
        binding.apply {
            ckbOneMonth.setOnCheckedChangeListener(timeCheckBox)
            ckbSixMonth.setOnCheckedChangeListener(timeCheckBox)
            ckbOneYear.setOnCheckedChangeListener(timeCheckBox)
        }
    }
}