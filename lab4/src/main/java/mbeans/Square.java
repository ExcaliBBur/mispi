package mbeans;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "squareBean")
public class Square implements Serializable, SquareMBean {
    public float square;

    public void calculateSquare(float R) {
        float rect = R * R / 2;
        float circle = (float) (Math.PI * R * R / 4);
        float triangle = R / 2 * R / 2;

        square = rect + circle + triangle;
    }
    public float getSquare() {
        return square;
    }

    public void printSquare() {
        System.out.println("Площадь получившейся фигуры: " + square);
        System.out.println();
    }

}
