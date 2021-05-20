# Teste Sicredi
### No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação.

## Rotas da API:
    - PostPauta
    `http://localhost:8080/pauta`

    - PostSessao
    `http://localhost:8080/pauta/{idPauta}/abrirSessao?time=3600000` 

    - GetPauta
    `http://localhost:8080/pauta`

    - GetPauta
    `http://localhost:8080/pauta/{idPauta}`

    - PostVoto
    `http://localhost:8080/sessao/{idSessao}?associado={cpf}&voto={voto}`