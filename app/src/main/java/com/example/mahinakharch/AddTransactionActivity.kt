package com.example.mahinakharch

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
 class AddTransactionActivity : AppCompatActivity() {

    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("MMMM d, yyyy hh:mm:ss a", Locale.US)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtransaction)

       val  dateEdt = findViewById<EditText>(R.id.idEdtDate)

        dateEdt.setOnClickListener {


            val c = Calendar.getInstance()


            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(

                this,
                { view, year, monthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateEdt.setText("      "+dat)
                },

                year,
                month,
                day
            )

            datePickerDialog.show()
        }

    }

}
