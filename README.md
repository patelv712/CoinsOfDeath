# CoinsOfDeath
AP Computer Science A 2019 Final Java Application Project
Expectation for Game: 
In our game, at the beginning of every round, a player will be created in the center of screen. To control the player, the person playing the game will use the keys W, A, S, D to move the player up, down, left and right. In the game, the goal of the player is to move to obtain as many coins as possible. For each round, there is a time limit and once the time runs out, the round is over. Randomly generated coins will appear on the screen for the player to move to collect. Sound will play if the player collects a coin. As the game progresses, randomly generated obstacles will appear, and if the player hits the obstacle the round is over. As of now, a round will conclude once the player collects all of the coins and there are a total of nine levels. As the levels increase the game will become more challenging as there will be more obstacles and less time to collect all of the coins. As the coins accumulate, coins may be used in the shop to buy new items.  
In our program we will have several classes. These classes originate from the Java swing GUI (Graphical User Interface) library. This includes classes such as JFrame and JComponent which we will be using to implement our Java application. We will be using JFrame in order to create the window of the game in order to successfully display the background, the player icon and other important component of the game. On the other hand, we will use JComponent in order to provide support for the accessibility of our game. Additionally, we will be using the BufferedImage class in order to handle our image data so that we may display these pictures on our JFrame window. Using BufferedImage objects and several conditional statements, we will be able to fluctuate the background depending on the player’s level number. Moreover, we will have a game class which will be used to run the game. The background class is responsible for repeatedly updating information about the game and the background image. Information such as the score counter and remaining time will be displayed in this class. After three levels, the background will change. Furthermore, we will have a player class where the player will be moved by pressing keys being passed in through KeyListener, which is a class that extends EventListener. Finally, if time permits, we will include a shop class, where the player can buy certain items or different skins that they can use in the game. 


Links Being Used:
Background image link
https://previews.123rf.com/images/vitalim/vitalim1604/vitalim160400003/57221848-corn-field-with-a-bird-s-eye-view.jpg 
Emoji player image link
https://images-na.ssl-images-amazon.com/images/I/61O3LuvpDML._SY355_.png 
Coin collected sound beep
https://youtu.be/UfumsRKSpeo 
Game over sound effect
https://youtu.be/khTVEXCJKy8 
