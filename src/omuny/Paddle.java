package omuny;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {

    int id;
    int yVelocity;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    // Нажатие клавиши
    public void keyPressed(KeyEvent e) {

    }

    // Реализация клавиш
    public void keyReleased(KeyEvent e) {

    }

    // Установка вертикального положения весла
    public void setYDirection(int yDirection) {

    }

    // Передвижение весла
    public void move() {

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
