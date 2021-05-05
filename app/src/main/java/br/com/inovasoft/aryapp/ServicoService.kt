package br.com.inovasoft.aryapp

object ServicoService {

    fun getServicos(): List<Servico> {

        var servicos = mutableListOf<Servico>()

        for (i in 1..5) {
            val s = Servico()
            s.nome = "Servico $i"
            s.descricao = "Descricao $i"
            s.profissional = "Profissional $i"
            s.foto = "https://i.pinimg.com/564x/77/62/15/77621501b0c9d868708e202d07b52e03.jpg"
            servicos.add(s)

        }

        return servicos
    }
}