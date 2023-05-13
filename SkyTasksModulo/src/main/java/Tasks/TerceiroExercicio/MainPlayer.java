package Tasks.TerceiroExercicio;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainPlayer {
    private final JFrame frame;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public static void main(String[] args) {
        new MainPlayer();
    }

    public MainPlayer() {
        frame = new JFrame("My Media Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent(
                null,
                null,
                new AdaptiveFullScreenStrategy(frame),
                null,
                null
        );
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(controlsPane, BoxLayout.X_AXIS);
        controlsPane.setLayout(boxLayout);
        JButton pauseButton = new JButton("Pause");
        JButton muteButton = new JButton("Mute");
        JButton unmuteButton = new JButton("Unmute");
        JButton closeButton = new JButton("Close");
        controlsPane.add(Box.createHorizontalGlue()); // Adiciona uma "cola" para centralizar os botões à direita
        controlsPane.add(pauseButton);
        controlsPane.add(muteButton);
        controlsPane.add(unmuteButton);
        controlsPane.add(closeButton);
        controlsPane.add(Box.createHorizontalGlue()); // Adiciona uma "cola" para centralizar os botões à esquerda
        contentPane.add(controlsPane, BorderLayout.SOUTH);

        pauseButton.addActionListener(e -> mediaPlayerComponent.mediaPlayer().controls().pause());
        muteButton.addActionListener(e -> mediaPlayerComponent.mediaPlayer().audio().setMute(true));
        unmuteButton.addActionListener(e -> mediaPlayerComponent.mediaPlayer().audio().setMute(false));
        closeButton.addActionListener(e -> frame.dispose());

        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.pack();

        String path = "apos_skytef_rede_ancora.mp4";
        try {
            URL url = new URL(path);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            if (responseCode == 200) {
                mediaPlayerComponent.mediaPlayer().fullScreen().set(true);
                mediaPlayerComponent.mediaPlayer().media().play(path);
            } else {
                throw new Exception("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }

    }
}
