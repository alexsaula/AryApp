package br.com.inovasoft.aryapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nomeUsuario")
        Toast.makeText(this, "Bem vindo, $nome", Toast.LENGTH_LONG).show()

        supportActionBar?.title = "Menu Inicial"

        val intent = Intent(this, PadraoActivity::class.java)

        bt_galeria.setOnClickListener {
            val bt_galeria = bt_galeria.text.toString()
            val params = Bundle()
            params.putString("botao", bt_galeria)
            intent.putExtras(params)
            startActivity(intent)
        }

        bt_historico.setOnClickListener {
            val bt_historico = bt_historico.text.toString()
            val params = Bundle()
            params.putString("botao", bt_historico)
            intent.putExtras(params)
            startActivity(intent)
        }

        bt_avaliacao.setOnClickListener {
            val bt_avaliacao = bt_avaliacao.text.toString()
            val params = Bundle()
            params.putString("botao", bt_avaliacao)
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_adicionar) {
            val intent = Intent(this, AgendamentoActivity::class.java)

            startActivity(intent)

        } else if (id == R.id.action_logout) {
            finish()

        } else if (id == R.id.action_config) {

            val intent = Intent(this, ConfigActivity::class.java)

            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}