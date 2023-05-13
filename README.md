<h1 align="center">🎯 Sobre o projeto</h1>

Nesse projeto três questões foram abordadas para demonstração de conceitos da linguagem Java e manipulação de arquivos
em GUI.

Tasks:



## Questões 1 - 2 - 3

## Primeira Questão

      A validação de triplicatas em um número inserido e demonstrado seu resultado via JOptionPane.
  
        O uso de constantes faz um código mais legível e de fácil manutenção. 
        Outra solução mais clean poderia ser o String.Utils com o .repeat - para verificar índices numéricos repetidos, com isso a condicional da linha 54 poderia ser removido ao implementar essa lib, mas em contrapartida
        utilizamos o foreach para demonstrar a lógica de verificar o número repetido e o anterior ao anterior - para que essa lógica não ficasse escondida na lib.

<div align="center">
<img src="https://raw.githubusercontent.com/Camargovf/TesteJava/main/SkyTasksModulo/src/main/Resources/PRIMEIRA_QUESTAO.png" width="700px" />
</div>

## Segunda Questão

```
    A criação de uma classe principal podendo ser executada mostrando o conceito de polimorfismo e manipulação GUI com JOptionPane.
    
      Foi criado então uma simulação de batalha pokemon com regra de vida, ataque, crítico de dano e fuga da batalha. O adversário é randomizado assim como a força dos golpes.
      Cada pokémon tem suas peculiariedades, e mesmo ambos contendo o método ataque, eles possuem implementações diferentes com a mesma assinatura de método.
      Nesse caso, a classe mãe é o Pokemon, em um estilo Factory os dois pokemons são gerados. 
    
      Foi usado também o uso da collection do Java com map. Uso de blocos recursivos para fácil manutenção a longo prazo. Se esse projeto fosse ser levado a frente, 
      teríamos uma classe principal apenas puxando
      algumas classes que efetuaram o serviço e trabalharíamos com microservices. 
 ```
      
<div align="center">
<img src="https://github.com/Camargovf/TesteJava/blob/main/SkyTasksModulo/src/main/Resources/evidencia_pikachu.pngg" width="200px" />
</div>


## Terceira Questão

 ```
    A criação de um serviço que pudesse executar um player de mp4 em tela cheia. 
    
      Foi implementado alguns ajustes além da tela cheia:
      Botão mudo.
      Botão som.
      Botão pause.
      Botão close.
      
 ```

<div align="center">
<img src="https://github.com/Camargovf/TesteJava/blob/main/SkyTasksModulo/src/main/Resources/evidencia_video.png" width="700px" />
</div>
 

<h1 align="center">📦 Desenvolvimento</h1>


Realizado com framework em Java 11, gestor de dependência com Maven. Realizado três implantações com uso de conceitos da
línguagem java aplicadas em GUI e com uso de POO - polimorfismo. Manipulação de arquivo de modo geral.
O projeto está em um único arquivo de forma didática, e a longo prazo sua perfomance pode estar comprometida por não
estar em ambiente devidamente aplicada a cada projeto.

<h1 align="center"> 💻 Requisitos de inicialização do projeto</h1>

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de
desenvolvimento.

Consulte *Implantação* para saber como implantar o projeto.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

- [Maven](http://maven.apache.org)
- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [VLC](https://github.com/caprica/vlcj)

<h3>Unix</h3>

`
sudo apt install openjdk-11-jre-headless
`

 <h1 align="center">📍 Rodando a aplicação</h1>

```
bash

Clone este repositório
$ git clone Link do diretorio

Acesse a pasta do projeto no terminal/cmd
$ cd README-nomeprojeto

Vá para a pasta nomeprojeto
$ cd project-nomeprojeto

Instale as dependências
$ mvn install
$ mvn clean package

Execute a aplicação em modo de desenvolvimento
$ javac -nomedoprojeto.jar

```

 <h1 align="center">✒️  Desenvolvedor </h1>

[<img src="https://avatars.githubusercontent.com/u/59845047?v=4" width=115><br><sub>Valdeir Camargo</sub>](https://github.com/Camargovf)
| :---: | :---: | :---: | :---: | :---: | :---: | 

