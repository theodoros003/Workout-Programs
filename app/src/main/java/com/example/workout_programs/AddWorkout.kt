package com.example.workout_programs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_workout.*
import kotlinx.android.synthetic.main.activity_my__workouts.*

class AddWorkout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_workout)
        toolbar3.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)

        toolbar3.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                finish()
            }
        })
    }
}
