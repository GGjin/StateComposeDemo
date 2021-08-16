package com.gg.statecomposedemo

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.RestoreFromTrash
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.UUID

/**
 * @description:
 * @author: Jinyu.Guo3
 * @createDate: 2021/8/16 016 14:12
 * @updateUser:
 * @updateDate: 2021/8/16 016 14:12
 */
data class TodoItem(
    val task: String,
    val icon: TodoIcon = TodoIcon.Default,
    // since the user may generate identical tasks, give them each a unique ID
    val id: UUID = UUID.randomUUID()
)

enum class TodoIcon(val imageVector: ImageVector, @StringRes val contentDescription: Int) {
    Square(Icons.Default.CropSquare, R.string.cd_expand),
    Done(Icons.Default.Done, R.string.cd_done),
    Event(Icons.Default.Event, R.string.cd_event),
    Privacy(Icons.Default.PrivacyTip, R.string.cd_privacy),
    Trash(Icons.Default.RestoreFromTrash, R.string.cd_restore);

    companion object {
        val Default = Square
    }
}