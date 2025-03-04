package omuny;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

    Random random;
    int xVelocity; // Скорость по X
    int yVelocity; // Скорость по Y
    int initialSpeed = 2; // Начальное ускорение мяча

    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
        // Направление X куда в начале полетит мячь
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) {
            randomXDirection--;
        }
        setXDirection((randomXDirection * initialSpeed));

        // Направление Y куда в начале полетит мячь
        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection((randomYDirection * initialSpeed));
    }

    // Установка скорости по X
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    // Установка скорости по Y
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    // Перемещение шара
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    // Отрисовка шара
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}