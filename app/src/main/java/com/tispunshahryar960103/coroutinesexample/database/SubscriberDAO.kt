package com.tispunshahryar960103.coroutinesexample.database

import androidx.room.*
import com.tispunshahryar960103.coroutinesexample.model.Subscriber
import kotlinx.coroutines.flow.Flow


@Dao
interface SubscriberDAO {



    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long


    @Update
    suspend fun updateSubscriber(subscriber: Subscriber) : Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers(): Flow<List<Subscriber>>


}