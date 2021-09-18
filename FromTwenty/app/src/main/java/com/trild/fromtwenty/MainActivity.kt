package com.trild.fromtwenty

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trild.fromtwenty.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listImgBackground: ArrayList<Int>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        var access = binding.apply {
            btnEnter.setOnClickListener() {
                val minTxt = etxtNumberMin.text.toString().trim {it <= ' '}
                val maxTxt = etxtNumberMax.text.toString().trim {it <= ' '}
                Log.e("Min_MAX:  ", minTxt + "_" + maxTxt)
                val min: Int
                val max: Int
                val random: Int
                if (minTxt.isEmpty() || maxTxt.isEmpty()){
                    Toast.makeText(this@MainActivity, "Please Enter Value Min and Max!", Toast.LENGTH_LONG).show()
                }else{
                     min = Integer.parseInt(minTxt)
                     max = Integer.parseInt(maxTxt)
                    if (min < max) {
                        random = Random.nextInt(min, max)
                    } else {
                        random = 0
                        Toast.makeText(this@MainActivity, "Please Enter Value Max is greater Value Min!", Toast.LENGTH_LONG).show()
                    }
                    txtRandomNumber.setText(random.toString())
                }
            }
            listImgBackground = ArrayList()
            listImgBackground!!.add(R.drawable.theme_02)
            listImgBackground!!.add(R.drawable.theme_03)
            listImgBackground!!.add(R.drawable.theme_04)
            listImgBackground!!.add(R.drawable.theme_05)
            Log.e("List Image: ", "" + listImgBackground!!.size)
            val sizeListBackground = listImgBackground!!.size
            var noThem = Random.nextInt(sizeListBackground - 1)
            root.setBackgroundResource(listImgBackground!![noThem])
        }
    }
}

