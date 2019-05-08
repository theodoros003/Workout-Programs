package com.example.workout_programs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(ctx: Context) : SQLiteOpenHelper(ctx,"Workouts", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL ("CREATE TABLE IF NOT EXISTS Workouts (Id INTEGER PRIMARY KEY, Title VARCHAR(255), SubTitle VARCHAR(255), Rest LONG, Rounds LONG, ExName1 VARCHAR(255), Reps LONG, ExName2 VARCHAR(255), Reps2 LONG, ExName3 VARCHAR(255), Reps3 LONG )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion:Int, newVersion:Int) {
        db.execSQL ("DROP TABLE IF EXISTS Workouts")
        onCreate(db)
    }

    fun addMusic(title: String, artist: String, year: Long) : Long{
        val db = writableDatabase
        val stmt = db.compileStatement("INSERT INTO Workouts (Title, SubTitle, Rest, Rounds, ExName1, Reps, ExName2, Reps2, ExName3, Reps3 ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.bindString(1, title)
        stmt.bindString(2, artist)
        stmt.bindLong(3, year)
        val id = stmt.executeInsert()
        return id
    }
}