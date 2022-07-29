# Simple Crud: Passo a passo

### MUITO IMPORTANTE:

AO CRIAR O CONSTRUTOR DO OBJETO/CLASSE, CRIE UM CONSTRUTOR VAZIO **public "objeto"(){}**



NGFORM POSSUI A PROPRIEDADE .VALUE QUE TRANSFORMA AS INFORMAÇÕES DE UM FORMULÁRIO EM JSON

AO ADICIONAR UMA NOVA TUPLA, ADICIONE NA RESPOSTA, A RENDERIZAÇÃO DOS DADOS NOVAMENTE

## Backend



#### Passo 1:

* Criar uma pasta model 
* Criar uma classe para cada "usuário"

#### Passo 2:

* Colocar todas as classes ligadas a um banco de dados como @Entity
* Colocar o id dessas classes como @ID e @GeneratedValue
  * strategy = GenerationType.INDENTITY

* (Opcional) Definir propriedades das colunas (Nullable, updatable, unique, etc...)
* Gerar Getters e Setters de cada variável

#### Passo 3:

* Configurar Mysql (default port: 3306)
  * spring.datasource.url=jdb:mysql://localhost:3306/employeemanager
  * spring.datasource.username = nome de usuário (default: root)
  * spring.datasource.password = senha (default: em branco)

* Criar o banco de dados (create Database)

#### Passo 4:

* Criar repositório das classes que farão parte do crud extendendo a classe para JPaRepository <classe usando crud, tipo da primary key utilizada>

#### Passo 5:

* Criar uma pasta Services
* Criar uma variável do tipo repositório criada no Passo 4
* @autowired o construtor
* Adicionar as funcionalidades CRUD
  * **UPDATE**:
    * .save("classe")
  * **DELETE**:
    * .deleteAll()
    * .delete"classe"ById(id)
  *  **CREATE** : 
    * set"variavel"(gerador de id)
    * .save("classe")  
  * **READ**:
    * .findAll()
    * .find"Classe"ById(id)

#### Passo 6

* Criar classe e atribuir @RestController e @RestMapping
* Injetar "classe".service na classe rest
* Adicionar Mappings
  * GetMapping(Ler)
  * PostMapping(Criar)
  * PutMapping(update)
  * DeleteMapping(Deletar)

* Todos os Mappings Possuem:
  * ResponseEntity<"Objeto"> na declaraçao
  * Return new ResponseEntity<>("variavel criada no metodo", httpStatus."ok")

* nos métodos post e put, usar @RequestBody dentro dos parâmetros

## FrontEnd

#### Passo 1

* NG new projeto
* Ng g i "Objeto" (os campos devem ser iguais)
* Ng g s "objeto"

#### Passo 2

* em services, importar HttpClient e instanciar uma variavel http: Httpclient para usar os métodos
* declarar uma variável que recebe a URL da api
* Todos os métodos terão retorno do tipo tipo Observable<"Objeto">
* Exceto delete Observable<"void">
* nos métodos usar <"objeto"> após o nome do método http
* em todos os métodos, é necessário passar a URL do @RestMapping

#### Passo 4

* Em um componente, construir o service e chamar os métodos colocando .subscribe((response: "Objeto") => Armazena response em outra variavel)