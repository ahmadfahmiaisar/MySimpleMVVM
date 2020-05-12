package inn.mroyek.mysimplemvvm.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String?) {
    message?.let {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}