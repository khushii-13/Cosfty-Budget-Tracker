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
import androidx.core.widget.addTextChangedListener
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

        var mydate="1/1/2000"

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
                    mydate=dat
                },

                year,
                month,
                day
            )

            datePickerDialog.show()
        }


        val labelLayout=findViewById<TextInputLayout>(R.id.labelLayout)

        val labelInput=findViewById<TextInputEditText>(R.id.labelInput)
        labelInput.addTextChangedListener {
            if(it!!.count() > 0)
                labelLayout.error = null
        }

        val amountInput=findViewById<TextInputEditText>(R.id.amountInput)
        val amountLayout=findViewById<TextInputLayout>(R.id.amountLayout)
        amountInput.addTextChangedListener {

            if(it!!.count() > 0)
                amountLayout.error = null
        }

        val addTransactionBtn=findViewById<Button>(R.id.addTransactionBtn)
       // val descriptionInput=findViewById<TextInputEditText>(R.id.descriptionInput)
        addTransactionBtn.setOnClickListener {
            val label = labelInput.text.toString()

           val date= mydate
            val amount = amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                labelLayout.error = "Please enter a valid label"

            else if(amount == null)
                amountLayout.error = "Please enter a valid amount"
            else {
//                val transaction  =Transaction(0, label, amount, date)
//                insert(transaction)
            }

        }

        val closeBtn=findViewById<ImageButton>(R.id.closeBtn)
        closeBtn.setOnClickListener {
            finish()
        }
    }


    private fun insert(transaction: Transaction){
        val db = Room.databaseBuilder(this,
            AppDatabase::class.java,
            "transactions").build()

        GlobalScope.launch {
            db.transactionDao().insertAll(transaction)
            finish()
        }
    }


}

