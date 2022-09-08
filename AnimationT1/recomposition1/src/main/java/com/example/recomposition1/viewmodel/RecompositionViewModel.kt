package com.example.recomposition1.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RecompositionViewModel: ViewModel() {

    /*companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                TODO("Not yet implemented")
            }

        }
    }*/

    private val studentList = listOf("AA", "BB", "CC", "DD", "EE" ) //Immutable

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var mutableStudentListState = mutableStateOf(studentList) // MutableState should hold the immutable data

    val  studentListState: State<List<String>>
    get() = mutableStudentListState //Single source of truth

    /*fun add(string: String) {
        studentList.add(string)
    }*/

    fun putAtFirst(string: String) {
        val ml = mutableListOf<String>()
        ml.addAll(studentList)
        ml[0] = string
        mutableStudentListState.value = ml //This statement will notify for recomposition
    }
}