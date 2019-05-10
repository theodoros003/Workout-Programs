package com.example.workout_programs

class WorkoutInfo {

    var workoutID:Long?=null
    var workoutTitle:String?=null
    var workoutSub:String?=null

    constructor(workoutID:Long,workoutTitle:String,workoutSub:String){
        this.workoutID=workoutID
        this.workoutTitle=workoutTitle
        this.workoutSub=workoutSub
    }
}