package br.com.inovasoft.aryapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Servico::class), version = 1)
abstract class ARYDatabase: RoomDatabase() {
    abstract fun servicoDAO(): ServicoDAO

}