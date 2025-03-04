package omuny;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false); // Отключение ручного изменения размера окна
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); // Изменение размера окна под компоновку объектов
        this.setVisible(true);
        this.setLocationRelativeTo(null); // Окно посередине экрана
    }
}