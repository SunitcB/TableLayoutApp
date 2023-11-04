package com.example.tablelayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tableLayout = findViewById<TableLayout>(R.id.androidTableLayout)
        var versionTxt = findViewById<EditText>(R.id.versionTxt)
        var codeNameTxt = findViewById<EditText>(R.id.codeNameTxt)
        var addBtn = findViewById<Button>(R.id.button)
        addBtn.setOnClickListener {
            addItemToTableLayout(tableLayout, versionTxt.text.toString(), codeNameTxt.text.toString())
            versionTxt.setText("")
            versionTxt.clearFocus()
            codeNameTxt.setText("")
            codeNameTxt.clearFocus()
            Toast.makeText(this,"A new row of android version is added successfully.", Toast.LENGTH_SHORT).show()
        }
    }


    fun addItemToTableLayout(tableLayout: TableLayout, text1: String, text2: String) {
        var tableRow = TableRow(ContextThemeWrapper(this, R.style.TableRowStyle))
        var layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        tableRow.layoutParams = layoutParams

        val textView1 = TextView(this)
        textView1.text = text1
        textView1.setPadding(8, 8, 8, 8)

        val textView2 = TextView(this)
        textView2.text = text2
        textView2.setPadding(8, 8, 8, 8)

        tableRow.addView(textView1)
        tableRow.addView(textView2)

        tableLayout.addView(tableRow)
    }
}