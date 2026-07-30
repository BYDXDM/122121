package com.example.data

import kotlinx.coroutines.flow.Flow

class ConversionRepository(private val historyDao: ConversionHistoryDao) {
    val allHistory: Flow<List<ConversionHistory>> = historyDao.getAllHistory()

    suspend fun insert(history: ConversionHistory) = historyDao.insertHistory(history)

    suspend fun delete(id: Int) = historyDao.deleteHistory(id)

    suspend fun deleteBatch(ids: List<Int>) = historyDao.deleteHistories(ids)
}
