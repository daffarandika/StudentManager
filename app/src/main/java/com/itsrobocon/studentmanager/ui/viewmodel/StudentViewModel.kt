package com.itsrobocon.studentmanager.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itsrobocon.studentmanager.data.Student
import com.itsrobocon.studentmanager.data.StudentDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class StudentViewModel(private val studentDao: StudentDao) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val students: StateFlow<List<Student>> = combine(
        studentDao.getAllStudents(),
        _searchQuery,
    ) { studentList, query ->
        if (query.isBlank()) {
            studentList
        } else {
            studentList.filter { student ->
                student.name.contains(query, ignoreCase = true) ||
                    student.nim.contains(query, ignoreCase = true) ||
                    student.department.contains(query, ignoreCase = true)
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList(),
    )

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    suspend fun getStudentByNim(nim: String): Student? {
        return studentDao.getStudentByNim(nim)
    }

    fun upsertStudent(name: String, nim: String, department: String) {
        viewModelScope.launch {
            val student = Student(name = name, nim = nim, department = department)
            studentDao.upsertStudent(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            studentDao.deleteStudent(student)
        }
    }
}
