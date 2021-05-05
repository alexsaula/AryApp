package br.com.inovasoft.aryapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
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

        val nomeShared = Prefs.getString("nomedousuario")
        Toast.makeText(this, "Valor em SharedPreferences: $nomeShared", Toast.LENGTH_SHORT).show()


        setSupportActionBar(toolbar)

        supportActionBar?.title = "Menu Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        configuraMenuLateral()

        recycler_servicos?.layoutManager = LinearLayoutManager(this)


    }

    private var servicos = listOf<Servico>()

    override fun onResume() {
        super.onResume()
        Thread {
            servicos = ServicoService.getServicos()

            runOnUiThread {
                recycler_servicos?.adapter = ServicoAdapter(servicos) {
                    onClickServico(it)
                }
            }
        }.start()
    }

    fun onClickServico(servico: Servico) {
        Toast.makeText(this, "Clicou serviço ${servico.nome}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetalheServicoActivity::class.java)

        intent.putExtra("Serviço", servico)

        startActivity(intent)
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

        when(item.itemId){
            R.id.nav_servicos-> {
                Toast.makeText(this, "Clicou em Serviços", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_forum -> {
                Toast.makeText(this, "Clicou em Fórum", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou em Localização", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sair -> {
                finish()
            }
        }

        layout_menu_lateral.closeDrawer(GravityCompat.START)

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

        } else if (id ==R.id.action_servico){
            val intent = Intent(this, ServicoActivity::class.java)
            startActivity(intent)

        }

        return super.onOptionsItemSelected(item)
    }

}