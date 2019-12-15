**projeto Java Web usando Maven repository**
----------------------------------------------------------------------------
esse é um projeto feito para fazer o cadastro dos moradores do condominio, a ideia é deixar a vida dos condonimos mais facil e segura, pois ao cadastrar na plataforma é gerada uma senha de segurança para que a entrada ao condominio tenha autonomia para reconhecer quem entra e quem sai.
----------------------------------------------------------------------------
* escolha uma IDE
1. configure o servers (Toncat ou glassfish )

--------------------------------------------------------------------------------

para funcionar bastar clonar o repositorio depois entrar no repositorio configurar o hibernate.cfg.xml para configurar sua senha senha do banco mysql local.
proxima etapa é criar uma database no mysql (create database portaria;), em segida execulta o hibernateTeste.ja para criar as tabela no banco, para finalizar execulte o projeto.

--------------------------------------------------------------------------------

**Tecnologias usadas**
1. Maven
2. Hibernate
3. PrimeFace
4. JSP

--------------------------------------------------------------------------------

#Comandos úteis do Maven

## Criação de Projeto

### desktop java (jar)

```
mvn archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -Dversion=1.0-SNAPSHOT \
  -DgroupId=com.erkobridee.exemplo.mvn \
  -DartifactId=ExemploMavenDesktop
```

preparar o projeto para o eclipse

```
mvn eclipse:eclipse 
```


### web java

```
mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-webapp \
    -Dversion=1.0-SNAPSHOT \
    -DgroupId=com.erkobridee.exemplo.mvn \
    -DartifactId=ExemploMavenWeb
```

preparar o projeto para o eclipse

```
mvn eclipse:eclipse -Dwtpversion=2.0
```

## Comandos para utilizar em projeto

mostra a arvore de dependencies(.jar)

	mvn depedency:tree 

copia os jar(dependencies) para pasta target/dependency [ evita eventuais problemas de ambiente ]

	mvn dependency:copy-dependencies

compile o projeto

	mvn compile

executa os testes

	mvn test 

gerar os .jars , muito usado em projetos ear

	mvn package 

limpa todas as dependencies(.jars)

	mvn clean 

procura todos os comandos que vc deu para o maven

	history | grep mvn 

boa prática adotada para gerar o pacote de deploy do projeto

	mvn clean install


## Links úteis

* [Introduction to the Build Lifecycle](http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

* [maven em 5 minutos](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

* [iniciando com maven](http://maven.apache.org/guides/getting-started/index.html)


* [Introduction to Archetypes](http://maven.apache.org/guides/introduction/introduction-to-archetypes.html)


* [Archetypes List](http://docs.codehaus.org/display/MAVENUSER/Archetypes+List)

* [repositório do Maven](http://mvnrepository.com/)


## FLEX MOJOS

Flex : Creates a simple SWC project

```    
mvn \
    archetype:generate \
    -DarchetypeRepository=http://repository.sonatype.org/content/groups/flexgroup/ \
    -DarchetypeGroupId=org.sonatype.flexmojos \
    -DarchetypeArtifactId=flexmojos-archetypes-library \
    -DarchetypeVersion=3.6.1 \
    -Dversion=1.0-SNAPSHOT \
    -DgroupId=com.erkobridee.exemplo.mvn \
    -DartifactId=ExemploMavenFlexLib
```    
    
Flex : Creates a simple SWF project

```
mvn \
    archetype:generate \
    -DarchetypeRepository=http://repository.sonatype.org/content/groups/flexgroup/ \
    -DarchetypeGroupId=org.sonatype.flexmojos \
    -DarchetypeArtifactId=flexmojos-archetypes-application \
    -DarchetypeVersion=3.6.1 \
    -Dversion=1.0-SNAPSHOT \
    -DgroupId=com.erkobridee.exemplo.mvn \
    -DartifactId=ExemploMavenFlexApp
```

Flex : Creates a modular project containing one SWC, one SWF and one WAR

```
mvn \
    archetype:generate \
    -DarchetypeRepository=http://repository.sonatype.org/content/groups/flexgroup/ \
    -DarchetypeGroupId=org.sonatype.flexmojos \
    -DarchetypeArtifactId=flexmojos-archetypes-modular-webapp \
    -DarchetypeVersion=3.6.1 \
    -Dversion=1.0-SNAPSHOT \
    -DgroupId=com.erkobridee.exemplo.mvn \
    -DartifactId=ExemploMavenFlexModular
```    


comandos úteis

```
mvn clean install -DskipTests=true

mvn flexmojos:flexbuilder
``` 

* [Flexmojos - Available archetypes](https://docs.sonatype.org/display/FLEXMOJOS/Available+archetypes)

* [Compiling flex with maven 2](http://mayboroda.blogspot.com/2009/07/compiling-flex-with-maven-2-flexmojos.html)

