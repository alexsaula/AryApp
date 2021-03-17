package br.com.inovasoft.aryapp

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nome")
        Toast.makeText(this, "Nome do usuário $nome", Toast.LENGTH_LONG).show()
        var numero = params?.getInt("numero")

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(context, "Clicou buscar", Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou config", Toast.LENGTH_SHORT).show()
        } else if(id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}