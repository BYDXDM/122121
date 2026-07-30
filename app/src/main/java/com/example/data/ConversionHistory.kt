package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversion_history")
data class ConversionHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fileName: String,
    val conversionType: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isSuccess: Boolean,
    val outputUri: String? = null
)
