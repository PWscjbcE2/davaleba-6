package com.example.davaleba6


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment1){
    private lateinit var noteEditText: EditText
    private lateinit var addNoteButton: Button
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        noteEditText = view.findViewById(R.id.editTextNote)
        addNoteButton = view.findViewById(R.id.buttonAdd)
        textView = view.findViewById(R.id.textView)

        val sharedPreferences = activity?.getSharedPreferences("MY_NOTES_PREF",
            AppCompatActivity.MODE_PRIVATE
        )
        val text = sharedPreferences?.getString("NOTE", "")
        textView.text = text

        addNoteButton.setOnClickListener {
            val note = noteEditText.text.toString()
            val text = textView.text.toString()
            val result = note + "\n" + text
            textView.text = result


            sharedPreferences?.edit()
                ?.putString("NOTE", result)
                ?.apply()

        }
    }
}