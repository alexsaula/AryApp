package br.com.inovasoft.aryapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nomeUsuario")
        Toast.makeText(this, "Bem vindo, $nome", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Menu Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

        configuraMenuLateral()
    }

    private fun configuraMenuLateral() {

        var toogle = ActionBarDrawerToggle(
            this,
            layout_menu_lateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()

        nav_menu_lateral.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
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