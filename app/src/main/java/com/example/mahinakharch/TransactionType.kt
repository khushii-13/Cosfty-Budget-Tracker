package com.example.mahinakharch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class TransactionType : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    val transactiontype= arrayOf("Transaction type","Income","Expense")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_type)


        val spinner=findViewById<Spinner>(R.id.transactiontypeseclector)
        val arrayadapter= ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,transactiontype)
        spinner.adapter=arrayadapter
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                 val text: String = transactiontype[p2]
                val i:Intent
                if(transactiontype[p2]=="Transaction type"){
                    return
                }
                if(text=="Income"){
                    intent = Intent(this@TransactionType, AddTransactionActivity::class.java)
                    startActivity(intent)
                }
                if(text=="Expense"){
                    intent = Intent(this@TransactionType, AddTransactionActivity::class.java)
                    startActivity(intent)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
               return
            }

        }

    }
}
