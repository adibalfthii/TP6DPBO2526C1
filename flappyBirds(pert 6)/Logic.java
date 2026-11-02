import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Logic implements ActionListener, KeyListener {
    Player player;
    Image birdImg;
    ArrayList<Pipe> pipes;
    
    int gravity = 1;
    int pipeVelocityX = -4;
    Image topPipeImg;
    Image bottomPipeImg;
    Timer pipesCooldown;
    Random random = new Random();

    boolean gameStarted = false;
    boolean gameOver = false;
    int score = 0;

    public Logic() {
        // Load gambar langsung dari folder assets lokal
        birdImg = new ImageIcon("assets/flappybird.png").getImage();
        topPipeImg = new ImageIcon("assets/toppipe.png").getImage();
        bottomPipeImg = new ImageIcon("assets/bottompipe.png").getImage();

        player = new Player(100, 250, 34, 24, birdImg);
        pipes = new ArrayList<Pipe>();

        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
    }

    public void placePipe() {
        int randomPipeY = (int) (0 - 512/4 - Math.random() * (512/2));
        int openingSpace = 160;

        Pipe topPipe = new Pipe(360, randomPipeY, 64, 512, topPipeImg);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(360, topPipe.getPosY() + 512 + openingSpace, 64, 512, bottomPipeImg);
        pipes.add(bottomPipe);
    }

    public void move() {
        if (!gameStarted || gameOver) return;

        // 1. Gravitasi Player
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());

        // Batas bawah layar
        if (player.getPosY() > 640) {
            gameOver = true;
            SoundEffect.stopBGM(); // Matikan musik saat game over
        }

        // 2. Pergerakan Pipa & Cek Tabrakan
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipeVelocityX);

            if (collision(player, pipe)) {
                gameOver = true;
                SoundEffect.stopBGM(); // Matikan musik saat menabrak pipa
            }

            if (!pipe.isPassed() && player.getPosX() > pipe.getPosX() + pipe.getWidth()) {
                score += 1; 
                pipe.setPassed(true);
            }
        }

        if (gameOver) {
            pipesCooldown.stop();
        }
    }

    public boolean collision(Player a, Pipe b) {
        return a.getPosX() < b.getPosX() + b.getWidth() &&
               a.getPosX() + a.getWidth() > b.getPosX() &&
               a.getPosY() < b.getPosY() + b.getHeight() &&
               a.getPosY() + a.getHeight() > b.getPosY();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameStarted) {
                gameStarted = true;
                pipesCooldown.start();
                // Nyalakan Background Music saat pertama kali menekan spasi untuk mulai
                SoundEffect.playBGM("assets/bgm.wav");
            }
            if (!gameOver) {
                player.setVelocityY(-9);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_R && gameOver) {
            restartGame();
            // Nyalakan kembali musik saat game di-restart
            SoundEffect.playBGM("assets/bgm.wav");
        }
    }

    public void restartGame() {
        player.setPosY(250);
        player.setVelocityY(0);
        pipes.clear();
        score = 0;
        gameOver = false;
        gameStarted = true;
        pipesCooldown.restart();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}