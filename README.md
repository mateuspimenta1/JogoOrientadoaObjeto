# JogoOrientadoaObjeto



# EN

The provided code is an implementation of a simple game in Java using the Swing library for creating the graphical interface.

The main class is called "Janela" and extends the "JPanel" class, which is a Swing component used for drawing graphics and interacting with user events. Additionally, the class implements the "KeyListener" and "Runnable" interfaces.

The "Janela" class contains several attributes, such as player, enemy, and magic objects, a list of projectiles, and a background image. There are also boolean variables to track the state of the pressed keys.

In the constructor of the class, several initializations are performed, including reading the background image from a file, setting window properties, and adding listeners for keyboard and window resize events.

The "keyPressed", "keyTyped", and "keyReleased" methods implement the "KeyListener" interface and are responsible for updating the state of the keys pressed by the player.

The "moverJogador" method is responsible for updating the player's position based on the pressed keys. It checks the pressed keys and changes the player's X and Y position accordingly.

The "moverInimigo" method moves the enemy towards the player. It calculates the movement direction based on the current position of the player and the enemy and updates the enemy's position accordingly.

The "verificarColisao" method checks for collision between the player and the enemy. It compares the coordinates of the bounding rectangles of the player and the enemy to detect the collision. If a collision occurs, the player's life is reduced, and some additional actions may be performed.

The "moverRotationMagic" and "moverBoomerang" methods update the position and state of the "RotationMagic" and "BoomerangMagic" spells, respectively. These spells are drawn on the game panel and can have specific movement or animation behaviors.

The "moverProjeteis" method moves the projectiles on the screen. It iterates over the list of projectiles, updates their positions, and removes those that have gone out of the window's bounds.

The "processarColisao" method checks if there was a collision and performs additional actions when a collision occurs.

The "paintComponent" method is overridden to draw the game elements on the screen. It uses the "Graphics" object to draw the player, enemy, projectiles, and spells on the panel.

The "run" method is implemented from the "Runnable" interface and represents the main game loop. It runs on a separate thread and repeatedly calls the movement and update methods of the game, as well as redraws the screen.

The "redimensionarJanela" method is used to update the positions and sizes of the game objects when the window is resized.

In general, the code implements the basic logic of a game where the player can move, and the enemy pursues the player.






PT BR



O código fornecido é uma implementação de um jogo simples em Java, utilizando a biblioteca Swing para a criação da interface gráfica.

A classe principal é chamada de "Janela" e estende a classe "JPanel", que é um componente Swing usado para desenhar gráficos e interagir com eventos do usuário. Além disso, a classe implementa as interfaces "KeyListener" e "Runnable".

A classe "Janela" contém vários atributos, como objetos do jogador, inimigo e mágicas, uma lista de projéteis e uma imagem de plano de fundo. Também há variáveis booleanas para acompanhar o estado das teclas pressionadas.

No construtor da classe, são realizadas várias inicializações, incluindo a leitura da imagem de plano de fundo a partir de um arquivo, a definição de propriedades da janela e a adição de listeners para eventos de teclado e redimensionamento da janela.

Os métodos "keyPressed", "keyTyped" e "keyReleased" implementam a interface "KeyListener" e são responsáveis por atualizar o estado das teclas pressionadas pelo jogador.

O método "moverJogador" é responsável por atualizar a posição do jogador com base nas teclas pressionadas. Ele verifica as teclas pressionadas e altera a posição X e Y do jogador de acordo.

O método "moverInimigo" move o inimigo em direção ao jogador. Ele calcula a direção do movimento com base na posição atual do jogador e do inimigo e atualiza a posição do inimigo de acordo.

O método "verificarColisao" verifica se há colisão entre o jogador e o inimigo. Ele compara as coordenadas dos retângulos delimitadores do jogador e do inimigo para detectar a colisão. Se ocorrer uma colisão, a vida do jogador é reduzida e algumas ações adicionais podem ser executadas.

Os métodos "moverRotationMagic" e "moverBoomerang" atualizam a posição e o estado das mágicas "RotationMagic" e "BoomerangMagic", respectivamente. Essas mágicas são desenhadas no painel do jogo e podem ter comportamentos específicos de movimento ou animação.

O método "moverProjeteis" move os projéteis na tela. Ele itera sobre a lista de projéteis, atualiza suas posições e remove aqueles que saíram dos limites da janela.

O método "processarColisao" verifica se houve colisão e executa ações adicionais quando ocorre uma colisão.

O método "paintComponent" é sobrescrito para desenhar os elementos do jogo na tela. Ele utiliza o objeto "Graphics" para desenhar o jogador, inimigo, projéteis e as mágicas no painel.

O método "run" é implementado a partir da interface "Runnable" e representa o loop principal do jogo. Ele é executado em uma thread separada e chama repetidamente os métodos de movimento e atualização do jogo, além de redesenhar a tela.

O método "redimensionarJanela" é usado para atualizar as posições e tamanhos dos objetos do jogo quando a janela é redimensionada.

Em geral, o código implementa a lógica básica de um jogo onde o jogador pode se mover, o inimigo persegue o jogador
