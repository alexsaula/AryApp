package br.com.inovasoft.aryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.inovasoft.aryapp.TelaInicialActivity
import kotlinx.android.synthetic.main.login.*



class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        logo.setImageResource(R.drawable.logo)

        botao_login.setOnClickListener {
            Toast.makeText(this, "Clicou no botão de login", Toast.LENGTH_SHORT).show()
            // qualquer outra coisa que o evento de clique deve executar

            val nome_usuario = campo_usuario.text.toString()

            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            params.putString("nome", nome_usuario)
            params.putInt("numero", 10)
            var array: ArrayList<Int> = ArrayList<Int>()
            array.add(10)
            array.add(20)
            params.putIntegerArrayList("array_numeros", array)

            intent.putExtras(params)
            intent.putExtra("outro_paramentro", true)

            startActivity(intent)
        }




    }
}