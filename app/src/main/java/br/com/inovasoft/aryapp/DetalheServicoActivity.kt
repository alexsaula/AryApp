package br.com.inovasoft.aryapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalheServicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_servico)
        val servico = intent.extras?.getSerializable("Serviço") as Servico

        Toast.makeText(this, "Clicou serviço ${servico.nome}", Toast.LENGTH_SHORT).show()
    }
}