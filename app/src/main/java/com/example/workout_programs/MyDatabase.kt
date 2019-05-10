package com.example.workout_programs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

var listWorkouts = ArrayList<WorkoutInfo>()
data class Program(val id: Long, val title: String, val subTitle: String, val rest: Long, val rounds: Long, val ex1: String, val rep1: Long, val ex2: String, val rep2: Long, val ex3: String, val rep3: Long)

class MyDatabase(ctx: Context) : SQLiteOpenHelper(ctx,"Workouts", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL ("CREATE TABLE IF NOT EXISTS Workouts (Id INTEGER PRIMARY KEY, Title VARCHAR(255), SubTitle VARCHAR(255), Rest LONG, Rounds LONG, ExName1 VARCHAR(255), Reps LONG, ExName2 VARCHAR(255), Reps2 LONG, ExName3 VARCHAR(255), Reps3 LONG )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion:Int, newVersion:Int) {
        db.execSQL ("DROP TABLE IF EXISTS Workouts")
        onCreate(db)
    }

    fun addWorkout(title: String, subTitle: String, rest: Long, rounds: Long, ex1: String, rep1: Long, ex2: String, rep2: Long, ex3: String, rep3: Long) : Long{
        val db = writableDatabase
        val stmt = db.compileStatement("INSERT INTO Workouts (Title, SubTitle, Rest, Rounds, ExName1, Reps, ExName2, Reps2, ExName3, Reps3 ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        stmt.bindString(1, title)
        stmt.bindString(2, subTitle)
        stmt.bindLong(3, rest)
        stmt.bindLong(4, rounds)
        stmt.bindString(5, ex1)
        stmt.bindLong(6, rep1)
        stmt.bindString(7, ex2)
        stmt.bindLong(8, rep2)
        stmt.bindString(9, ex3)
        stmt.bindLong(10, rep3)
        val id = stmt.executeInsert()
        return id
    }

    fun viewWorkout(id: Long) : Program? {
        val db = readableDatabase
        val id = id
        //val cursor = db.rawQuery("SELECT * FROM Workouts WHERE Id=? ", id)

        return null
    }


    fun findWorkouts () {
        val db = readableDatabase
        val projections = arrayOf("Id", "Title", "SubTitle")
        var loopid = 0
        val cursor = db.rawQuery("SELECT * FROM Workouts ", null)
        listWorkouts.clear()
        if (cursor.moveToFirst()){

            do{
                val id=cursor.getLong(cursor.getColumnIndex("Id"))
                val title=cursor.getString(cursor.getColumnIndex("Title"))
                val sub=cursor.getString(cursor.getColumnIndex("SubTitle"))

                listWorkouts.add(WorkoutInfo(id,title,sub))

            }while (cursor.moveToNext())

        }
        cursor.close()
    }
}