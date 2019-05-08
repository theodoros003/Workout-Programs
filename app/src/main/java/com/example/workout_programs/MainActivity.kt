package com.example.workout_programs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)

        btnFullBody.setOnClickListener {
            val intent = Intent(this, MyWorkouts::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu);
        val item = menu?.findItem(R.id.action_search);

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
        val id = item!!.getItemId()
        val intent = Intent(this, AddWorkout::class.java)

        if (id == R.id.menuAdd){
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}
