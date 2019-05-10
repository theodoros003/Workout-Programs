package com.example.workout_programs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_workout.*
import kotlinx.android.synthetic.main.activity_my__workouts.*

class AddWorkout : AppCompatActivity() {
    lateinit var myData: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_workout)
        toolbar3.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)

        toolbar3.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                finish()
            }
        })

        myData = MyDatabase(ctx = this)

        btnAdd.setOnClickListener {
            //val id = etID.text.toString().toLong()
            val title = etTitle.text.toString()
            val subTitle = etSubTitle.text.toString()
            val rest = etRest.text.toString().toLong()
            val rounds = etRounds.text.toString().toLong()
            val ex1 = etName.text.toString()
            val rep1 = etReps.text.toString().toLong()
            val ex2 = etName2.text.toString()
            val rep2 = etReps2.text.toString().toLong()
            val ex3 = etName3.text.toString()
            val rep3 = etReps3.text.toString().toLong()
            val id = myData.addWorkout(title, subTitle, rest, rounds, ex1, rep1, ex2, rep2, ex3, rep3)
            Toast.makeText(this, "You have added '$title' to the programs with id= " +id , Toast.LENGTH_LONG).show()
        }
    }
}
