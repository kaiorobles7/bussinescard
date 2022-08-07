package com.example.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.businesscard.App
import com.example.businesscard.R
import com.example.businesscard.data.viewmodel.MainViewModel
import com.example.businesscard.data.viewmodel.MainViewModelFactory
import com.example.businesscard.databinding.ActivityAddBusinessCardBinding
import com.example.businesscard.databinding.ActivityMainBinding
import com.example.businesscard.domain.BusinessCard

class AddBusinessCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBusinessCardBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListener()
    }

    private fun insertListener(){
        binding.ibClose.setOnClickListener{
            finish()
        }

        binding.btConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                backgroundColor = binding.tilColor.editText?.text.toString().uppercase()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.txt_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}