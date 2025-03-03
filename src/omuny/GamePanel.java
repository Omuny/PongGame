package omuny;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (5/9));
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

    }

    // Создание нового мяча
    public void newBall() {

    }

    // Создание нового весла
    public void newPaddles() {

    }

    // Рисование предметов на экране
    public void paint(Graphics g) {

    }

    // Отрисовка экрана
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

    }

    // Класс для прослушивания действий
    public class AL extends KeyAdapter {
        // Ожидание нажатия клавиш
        public void keyPressed(KeyEvent e) {

        }

        // Реализация нажатия клавиш
        public void keyReleased(KeyEvent e) {

        }
    }

}
