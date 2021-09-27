package com.trild.recyclerproject.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Year

@RequiresApi(Build.VERSION_CODES.O)
class Student(val name: String, val birthYear: Int){
    private var year : Year
    var age :Int
    init{
        year = Year.now();
        age = Integer.valueOf(year.toString()) - Integer.valueOf(birthYear.toString())
    }
}