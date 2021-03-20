package br.com.inovasoft.aryapp

import android.os.Bundle
import android.view.MenuItem

class CadastroActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        supportActionBar?.title = "Cadastro de usuário"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

         if(id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}