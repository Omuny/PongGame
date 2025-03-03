package omuny;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {

    int id; // id весла: 1 - первый игрок, 2 - второй игрок
    int yVelocity;
    int speed = 10; // Скорость весел

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    // Нажатие клавиши
    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }

    // Реализация клавиш
    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }

    // Установка вертикального положения весла
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    // Передвижение весла
    public void move() {
        y += yVelocity;
    }

    // Отрисовка весла
    public void draw(Graphics g) {
        if (id == 1) {
            g.setColor(Color.BLUE); // Цвет 1 игрока
        } else {
            g. setColor(Color.RED); // Цвет 2 игрока
        }
        g.fillRect(x, y, width, height);
    }
}