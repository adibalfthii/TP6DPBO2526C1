import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JPanel {
    Logic logic;
    Image bgImg;
    Timer gameLoop;
    JLabel scoreLabel;

    public View(Logic logic) {
        this.logic = logic;
        setPreferredSize(new Dimension(360, 640));
        setFocusable(true);
        addKeyListener(logic);
        setLayout(null);

        // Load background langsung dari folder assets lokal
        bgImg = new ImageIcon("assets/flappybirdbg.png").getImage();

        // Inisialisasi JLabel untuk skor
        scoreLabel = new JLabel("0");
        scoreLabel.setBounds(20, 20, 100, 50);
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 32));
        scoreLabel.setVisible(false);
        add(scoreLabel);

        // Game loop timer (~60 FPS)
        gameLoop = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.isGameStarted() && !logic.isGameOver()) {
                    logic.move();
                    scoreLabel.setText(String.valueOf(logic.score));
                    scoreLabel.setVisible(true);
                } else if (logic.isGameOver()) {
                    scoreLabel.setVisible(false);
                }
                repaint();
            }
        });
        gameLoop.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // 1. Gambar Background
        g.drawImage(bgImg, 0, 0, 360, 640, null);

        // Jika game belum dimulai (Main Menu)
        if (!logic.isGameStarted()) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("FLAPPY BIRD", 65, 200);
            
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Tekan SPASI untuk Mulai", 75, 250);
            return;
        }

        // 2. Gambar Player (Burung)
        g.drawImage(
            logic.player.getImg(), 
            logic.player.getPosX(), 
            logic.player.getPosY(), 
            logic.player.getWidth(), 
            logic.player.getHeight(), 
            null
        );

        // 3. Gambar Pipa-pipa
        for (int i = 0; i < logic.pipes.size(); i++) {
            Pipe pipe = logic.pipes.get(i);
            g.drawImage(
                pipe.getImg(), 
                pipe.getPosX(), 
                pipe.getPosY(), 
                pipe.getWidth(), 
                pipe.getHeight(), 
                null
            );
        }

        // 4. Tampilan Game Over
        if (logic.isGameOver()) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            g.drawString("GAME OVER", 80, 280);

            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("Skor Anda: " + logic.score, 120, 320);
            g.drawString("Tekan 'R' untuk Restart", 85, 360);
        }
    }
}