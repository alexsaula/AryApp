package br.com.inovasoft.aryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*



class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        logo.setImageResource(R.drawable.logo)

        botao_login.setOnClickListener {


            val nomeUsuario = campo_usuario.text.toString()
            val senhaUsuario = campo_senha.text.toString()


            if(nomeUsuario.equals("aluno") && senhaUsuario.equals("impacta")) {

                val intent = Intent(this, TelaInicialActivity::class.java)
                val params = Bundle()
                params.putString("nomeUsuario", nomeUsuario)
                intent.putExtras(params)

                startActivity(intent)

            }else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }

        }

        botaoCadastro.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)

            startActivity(intent)
        }


    }
}