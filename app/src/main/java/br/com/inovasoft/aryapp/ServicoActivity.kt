package br.com.inovasoft.aryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_servico.*

class ServicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servico)

        salvar.setOnClickListener {
            val textoNome = nome.text.toString()
            val textodescricao = descricao.text.toString()
            val textoprofissional = profissional.text.toString()
            val textofoto = foto.text.toString()

            val s = Servico()
            s.nome = textoNome
            s.descricao = textodescricao
            s.profissional = textoprofissional
            s.foto = textofoto

            Thread {
                ServicoService.saveServicoDB(s)
                runOnUiThread{
                    finish()
                }
            }.start()

        }
    }
}