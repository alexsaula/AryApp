package br.com.inovasoft.aryapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName= "servico")

class Servico: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var descricao = ""
    var foto = ""
    var profissional = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }


}