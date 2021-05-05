package br.com.inovasoft.aryapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class PadraoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_padrao)

        var params = intent.extras
        val botao = params?.getString("botao")

        if (botao =="Galeria") {
            supportActionBar?.title = "Galeria"
        }else if (botao == "Histórico") {
            supportActionBar?.title = "Histórico"
        }else if (botao =="Avaliação") {
            supportActionBar?.title = "Avaliação"
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()

        }
        return super.onOptionsItemSelected(item)

    }
}