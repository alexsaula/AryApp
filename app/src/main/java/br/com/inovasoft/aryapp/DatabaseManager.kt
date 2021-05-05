package br.com.inovasoft.aryapp

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: ARYDatabase

    init {
        val context = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            ARYDatabase::class.java,
            "ary.sqlite"
        ).build()

    }
    fun getServicoDAO(): ServicoDAO {
        return dbInstance.servicoDAO()
    }
}