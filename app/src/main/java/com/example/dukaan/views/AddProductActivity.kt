package com.example.dukaan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dukaan.R
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        btnContinueAddProduct.setOnClickListener {
            if (checkValidity()) {
                val intent = Intent(this, AddProductDetailsActivity::class.java)
                intent.putExtra("name", etProductNameAddProduct.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter properly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkValidity(): Boolean {
        if (etProductNameAddProduct.text.toString().isEmpty()) {
            etProductNameAddProduct.error = "Can not be empty"
            return false
        }
        return true
    }
}