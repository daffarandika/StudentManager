package com.itsrobocon.studentmanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    val name: String,
    @PrimaryKey
    val nim: String,
    val department: String,
)
