const URL = 'http://localhost:8080/alunos';

async function consumirApi() {
    try {
        const resp = await fetch(URL);
        if (resp.ok) { // Verifica se a resposta foi bem-sucedida
            const text = await resp.text(); // Obtém a resposta como texto
            console.log('Resposta em texto:', text); // Exibe o texto da resposta
            if (text) {
                const obj = JSON.parse(text); // Tenta converter o texto para JSON
                console.log('Objeto JSON:', obj);
                inserirDadosNoHTML(obj);
            } else {
                console.log('Resposta vazia.');
            }
        } else {
            console.error('Erro na resposta:', resp.status, resp.statusText);
        }
    } catch (error) {
        console.error('Erro ao consumir a API:', error);
    }
}

consumirApi();

