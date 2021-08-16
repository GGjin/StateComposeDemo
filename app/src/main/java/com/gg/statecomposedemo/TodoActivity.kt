package com.gg.statecomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.gg.statecomposedemo.ui.theme.StateComposeDemoTheme
import androidx.compose.runtime.livedata.observeAsState

/**
 * @description:
 * @author: Jinyu.Guo3
 * @createDate: 2021/8/16 016 14:16
 * @updateUser:
 * @updateDate: 2021/8/16 016 14:16
 */
class TodoActivity : ComponentActivity() {

    private val viewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateComposeDemoTheme {
                Surface {
                    TodoActivityScreen(todoViewModel = viewModel)
                }
            }
        }
    }
}

@Composable
private fun TodoActivityScreen(todoViewModel: TodoViewModel) {
    TodoScreen(
        items = todoViewModel.todoItems,
        currentlyEditing = todoViewModel.currentEditItem,
        onAddItem = todoViewModel::addItem,
        onRemoveItem = todoViewModel::removeItem,
        onStartEdit = todoViewModel::onEditItemSelected,
        onEditItemChange = todoViewModel::onEditItemChange,
        onEditDone = todoViewModel::onEditDone
    )

}
