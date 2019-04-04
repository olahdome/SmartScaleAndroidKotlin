package olah.dome.smartscale

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.android.UI as AndroidUI


object Contexts {
    val IO = Dispatchers.Default
    val UI = Dispatchers.Main
}

suspend fun <T> withIOContext(block: suspend CoroutineScope.() -> T) = withContext(Contexts.IO, block = block)

fun execute(task: suspend () -> Unit) = launch(Contexts.UI) {
    try {
        task()
    } catch (e: Throwable) {
        Log.d("error", e.message)
    }
}