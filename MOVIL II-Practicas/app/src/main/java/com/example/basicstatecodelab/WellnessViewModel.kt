package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    // Lista interna modificable observable
    private val _tasks = getWellnessTasks().toMutableStateList()

    // Lista pública inmutable
    val tasks: List<WellnessTask>
        get() = _tasks

    // Elimina una tarea
    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    // Cambia el estado checked
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

// Función que genera las tareas
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task #$i") }