package com.gg.statecomposedemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * @description:
 * @author: Jinyu.Guo3
 * @createDate: 2021/8/16 016 14:13
 * @updateUser:
 * @updateDate: 2021/8/16 016 14:13
 */
class TodoViewModel : ViewModel() {

    var todoItems = mutableStateListOf<TodoItem>()
        private set

    // private state
    private var currentEditPosition by mutableStateOf(-1)

    // state
    val currentEditItem: TodoItem?
        get() = todoItems.getOrNull(currentEditPosition)

    fun addItem(item: TodoItem) {
        todoItems.add(item)
    }


    // event: removeItem
    fun removeItem(item: TodoItem) {
        todoItems.remove(item)
        onEditDone() // don't keep the editor open when removing items
    }


    // event: onEditItemSelected
    fun onEditItemSelected(item: TodoItem) {
        currentEditPosition = todoItems.indexOf(item)
    }

    // event: onEditDone
    fun onEditDone() {
        currentEditPosition = -1
    }

    // event: onEditItemChange
    fun onEditItemChange(item: TodoItem) {
        val currentItem = requireNotNull(currentEditItem)
        require(currentItem.id == item.id) {
            "You can only change an item with the same id as currentEditItem"
        }

        todoItems[currentEditPosition] = item
    }

}