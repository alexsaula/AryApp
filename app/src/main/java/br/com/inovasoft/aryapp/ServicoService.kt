package br.com.inovasoft.aryapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ServicoService {

    val host = "https://aryapp.pythonanywhere.com"
    val TAG = "WS_AryApp"

    fun getServicos(): List<Servico> {

                val url ="$host/servicos"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        var servicos = parserJson<List<Servico>>(json)

        return servicos
    }

    fun getServicosDB(): List<Servico> {
        val dao = DatabaseManager.getServicoDAO()
        return dao.findAll()
    }

    fun saveServico(servico: Servico) : String {
        val json = HttpHelper.post("$host/servicos", servico.toJson())
        return json
    }

    fun saveServicoDB(servico: Servico): String {
        val dao = DatabaseManager.getServicoDAO()
        dao.insert(servico)

        return "ok"
    }

    inline fun <reified T> parserJson(json: String) : T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}