package com.itsrobocon.studentmanager.di

import androidx.room.Room
import com.itsrobocon.studentmanager.data.StudentDatabase
import com.itsrobocon.studentmanager.ui.viewmodel.StudentViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            StudentDatabase::class.java,
            "student_database"
        ).build()
    }
    single { get<StudentDatabase>().studentDao() }
    viewModel { StudentViewModel(get()) }
}
