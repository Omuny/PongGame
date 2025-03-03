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
        //random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
    }

    // Создание нового весла
    public void newPaddles() {
        paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WEIGHT, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WEIGHT, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WEIGHT, PADDLE_HEIGHT, 2);
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
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
    }

    // Перемещение элементов
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    // Проверка столкновений
    public void checkCollision() {
        // Отскакивание шара от краев окна
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        // Отскакивание шара от вёсел
        if (ball.intersects(paddle1)) { // Проверка коллизии перрвого весла
            ball.xVelocity = -ball.xVelocity;

            // ОПЦИОНАЛЬНО. Ускорение шара после столкновения с веслом
            ball.xVelocity++;
            if (ball.yVelocity > 0) {
                ball.yVelocity++;
            } else {
                ball.yVelocity--;
            }
            // ОПЦИОНАЛЬНО. Ускорение шара после столкновения с веслом

            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paddle2)) { // Проверка коллизии второго весла
            ball.xVelocity = -ball.xVelocity;

            // ОПЦИОНАЛЬНО. Ускорение шара после столкновения с веслом
            ball.xVelocity++;
            if (ball.yVelocity > 0) {
                ball.yVelocity++;
            } else {
                ball.yVelocity--;
            }
            // ОПЦИОНАЛЬНО. Ускорение шара после столкновения с веслом

            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        // Останавливает весла краями экрана
        if (paddle1.y <= 0) {
            paddle1.y = 0;
        }
        if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if (paddle2.y <= 0) {
            paddle2.y = 0;
        }
        if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }

        // Добавим игроку очко и создадим новые вёсла и мячь
        if (ball.x <= 0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Игрок 2: " + score.player2);
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Игрок 1: " + score.player1);
        }
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
            }
        }
    }

    // Класс для прослушивания действий
    public class AL extends KeyAdapter { // Action Listener
        // Ожидание нажатия клавиш
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        // Реализация нажатия клавиш
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}