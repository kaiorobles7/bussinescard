package com.example.businesscard.repository

import com.example.businesscard.data.BusinessCardDao
import com.example.businesscard.domain.BusinessCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDao){

    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
         dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

}