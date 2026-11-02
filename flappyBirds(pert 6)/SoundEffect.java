import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
    private static Clip bgmClip;

    // Method untuk memutar Background Music secara looping (berputar terus)
    public static void playBGM(String soundFilePath) {
        try {
            // Jika musik sebelumnya sudah jalan, hentikan dulu
            stopBGM();

            File soundFile = new File(soundFilePath);
            if (soundFile.exists()) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                bgmClip = AudioSystem.getClip();
                bgmClip.open(audioIn);
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY); // Berputar otomatis tanpa henti
                bgmClip.start();
            } else {
                System.out.println("File BGM tidak ditemukan: " + soundFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method untuk menghentikan musik (opsional)
    public static void stopBGM() {
        if (bgmClip != null && bgmClip.isRunning()) {
            bgmClip.stop();
            bgmClip.close();
        }
    }
}