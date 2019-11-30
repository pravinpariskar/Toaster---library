package com.example.toasterlibrary

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

object ToasterMessage {
    fun createToast(context: Context, message: String, duration: Int) {
        var toast: Toast = Toast(context)
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        /*first parameter is the layout you made
        second parameter is the root view in that xml
         */
        val layout =
            inflater.inflate(R.layout.toast_msg, (context as Activity).findViewById<ViewGroup>(R.id.linearLayout))

        layout.findViewById<TextView>(R.id.toast_text).text = message
        val close = layout.findViewById<ImageView>(R.id.toast_close)
        close.setOnClickListener {
            toast.cancel()
        }
        toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)
        toast.setDuration(duration)
        toast.setView(layout)
        toast.show()
    }
}