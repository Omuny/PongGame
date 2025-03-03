package omuny;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static  final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WEIGHT = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true); // Настройка фокусировки панели
        this.addKeyListener(new AL()); // Добавление прослушивателя нажатий
        this.setPreferredSize(SCREEN_SIZE); // Установка предпочтительного размера

        gameThread = new Thread(this);
        gameThread.start();
    }

    // Создание нового мяча
    public void newBall() {

    }

    // Создание нового весла
    public void newPaddles() {

    }

    // Отрисовка панели
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    // Рисование объектов на экране
    public  void draw(Graphics g) {

    }

    // Перемещение элементов
    public void move() {

    }

    // Проверка столкновений
    public void checkCollision() {

    }

    // Запуск
    public void run() {
        // Игровой цикл
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
                System.out.println("Test");
            }
        }
    }

    // Класс для прослушивания действий
    public class AL extends KeyAdapter { // Action Listener
        // Ожидание нажатия клавиш
        public void keyPressed(KeyEvent e) {

        }

        // Реализация нажатия клавиш
        public void keyReleased(KeyEvent e) {

        }
    }

}
