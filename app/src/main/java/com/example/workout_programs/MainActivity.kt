package com.example.workout_programs

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_dynamic.view.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: MyDatabase
    var listWorkouts = ArrayList<WorkoutInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)
        myData = MyDatabase(ctx = this)

        //btnFullBody.setOnClickListener {
        //    val intent = Intent(this, MyWorkouts::class.java)
        //    startActivity(intent)
        //}
        //val title = ""
        myData.findWorkouts()
        var myAdapter= MyWorkoutAdpater(this, listWorkouts)
        lvPrograms.adapter=myAdapter
        
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu);
        val item = menu?.findItem(R.id.action_search)
        val sv = MenuItemCompat.getActionView(item) as SearchView

        // Note how we create an object implementing the SearchView.OnQueryTextListener
        // in Kotlin, i.e. object:SearchView.OnQueryTextListener.
        // As there are 2 methods in the interface, we cannot use SAM conversions.

        sv.setOnQueryTextListener(object: SearchView.OnQueryTextListener {


            // Called when the text in the search view changes (e.g. user types new character)
            override fun onQueryTextChange(txt: String): Boolean {
                //toast("character typed: $txt") // Assumes we have Anko Commons
                return true
            }

            // Called when the user presses the search button
            override fun onQueryTextSubmit(txt: String): Boolean {
                //toast("search submitted: $txt")
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item != null){
            when(item.itemId)
            {
                R.id.menuAdd->{
                    val intent = Intent(this, AddWorkout::class.java)
                    startActivity(intent)
                }
            }

        }

        return super.onOptionsItemSelected(item)
    }

    inner class  MyWorkoutAdpater:BaseAdapter{

        var listNotesAdpater=ArrayList<WorkoutInfo>()
        var context:Context?=null
        constructor(context:Context, listNotesAdpater:ArrayList<WorkoutInfo>):super(){
            this.listNotesAdpater=listNotesAdpater
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var myView=layoutInflater.inflate(R.layout.activity_main_dynamic,null)
            var myWorkout=listNotesAdpater[position]
            var workID = myWorkout.workoutID
            myView.btnFullBody.text=myWorkout.workoutTitle
            myView.tvSubTitle.text=myWorkout.workoutSub

            return myView
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(position: Int): Any {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return listNotesAdpater[position]
        }

        override fun getItemId(position: Int): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return listNotesAdpater.size
        }
    }


}
