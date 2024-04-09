# Projeto DLEA WEB SYSTEM BanckAnd 

O Projeto DLEA WEB SYSTEM BanckAnd é uma plataforma web que visa proporcionar interatividade ao usuário. Ao clicar em uma opção de jogo, o sistema retorna as informações do jogo selecionado.

 [<img src="../Assets/Animacao.gif" alt="git da tela inicial do projeto">] 



## Tecnologias utilizadas
-Spring boot
-Spring Data / JPA
-Java
-Docker
-Deployee Raiwail
-Postgresql

## Repository
```
@Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
List<GameMinProjection> searchByList(Long listId);
```

## Aprendizados
Este projeto me proporcionou a oportunidade de aprimorar minhas habilidades na criação de APIs, fornecendo controladores para que meu frontend faça as requisições necessárias.

## Dificuldades
Uma das principais dificuldades enfrentadas foi desenvolver a lógica para a listagem dinâmica de jogos.
