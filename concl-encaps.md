# Arquitetura

De acordo com nossa arquitetura atual, será necessário que está etapa fique entre:
- Para WEB: Entre as transformers > spec_loader
- Para NATIVO: Pode fazer parte da etapa de transformers dado que a codificação de IOS e Android, ainda está como Nativo puro.
<br><br/>

# Logica 

<details>
<summary><b>1. Busca e estruturação</b></summary>
Nesta etapa temos estruturada a logica que realiza o find, pegando como base os padrões de construção para cada linguagem/framework/sistema.
Basicamente trabalhamos capturando as linhas que serão estudadas e aplicamos a logica de Regex.
<br><br/>

**Exemplo de script:**
```python
def funcao_ex ()
    print('Lalala')
```
**Ex de saida:**
| repository_name | file_name        | file_path              | selector    | file_name_html   | file_names_stilos | class      |
|-----------------|------------------|------------------------|-------------|------------------|-------------------|------------|
| repo-xxx-app-01 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-02 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-02.ts  | \src\app\components\   | component02 | component02.html | component02.scss  | comp02class|

</details>

<details>
<summary><b>2. Agregação </b></summary>
Tendo as informações associadas a construção do encapsulamento, podemos associar agora as informações da spec para cada um dos encapsulamentos.

**Ex de Saida:**
| repository_name | file_name        | file_path              | selector    | file_name_html   | file_names_stilos | class      |
|-----------------|------------------|------------------------|-------------|------------------|-------------------|------------|
| repo-xxx-app-01 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-02 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-02.ts  | \src\app\components\   | component02 | component02.html | component02.scss  | comp02class|

</details>

<details>
<summary><b>3. Reordenação</b></summary>
Sabendo o nome do componente e tendo quais são os componentes usados no encapsulamento, podemos reorganizar os apontamentos na nossa spec_loader.

**Ex de Saida:**
| repository_name | file_name        | file_path              | selector    | file_name_html   | file_names_stilos | class      |
|-----------------|------------------|------------------------|-------------|------------------|-------------------|------------|
| repo-xxx-app-01 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-02 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-01.ts  | \src\app\components\   | component01 | component01.html | component01.scss  | comp01class|
| repo-xxx-app-03 | component-02.ts  | \src\app\components\   | component02 | component02.html | component02.scss  | comp02class|

</details>
<br/>

Como podemos ver no caso do componente "", ele  trouxe 'x' componentes, 'y' class e 'z' modulos para o arquivo que o usou ele durante a codificação.
Se fizermos uma conta de padeiro, pensando somente em relacionamento de componentes, temos um aumento no uso de 