import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
/**
   A component that draws images which located in where mouse clicks
*/
public class ShapeDrewerComponent extends JComponent{
    private Point2D points[];
    public int numPoints;
    private static final int MAX_POINTS = 5;
    public int[] shape = new int[5];
    public int[] size = new int[5];
    public int[] color = new int[5];


    /**
     Create a new image drawer component
     */
    public ShapeDrewerComponent(){
        points = new Point2D[MAX_POINTS];
        numPoints = 0;
    }


    /**
     Set the coordinates of the first point
     @param x x-coordinate
     @param y y-coordinate
     */
    public void setFirstPoint(int x, int y){
        setPoint(x, y, 0);
    }
    /**
     Set the coordinates of the second point
     @param x x-coordinate
     @param y y-coordinate
     */
    public void setSecondPoint(int x, int y){
        setPoint(x, y, 1);
    }
    /**
     Set the coordinates of the third point
     @param x x-coordinate
     @param y y-coordinate
     */
    public void setThirdPoint(int x, int y){
        setPoint(x, y, 2);
    }
    /**
     Set the coordinates of the fourth point
     @param x x-coordinate
     @param y y-coordinate
     */
    public void setFourthPoint(int x, int y){
        setPoint(x, y, 3);
    }
    /**
     Set the coordinates of the fifth point
     @param x x-coordinate
     @param y y-coordinate
     */
    public void setFifthPoint(int x, int y){
        setPoint(x, y, 4);
    }

    /**
     Get the horizontal axi of the first point
     @return the x of the first point
     */
    public double getFirstPointX(){
        return points[0].getX();
    }
    /**
     Get the ordinate of the first point
     @return the y of the first point
     */
    public double getFirstPointY(){
        return points[0].getY();
    }
    /**
     Get the horizontal axi of the second point
     @return the x of the first point
     */
    public double getSecondPointX(){
        return points[1].getX();
    }
    /**
     Get the ordinate axi of the second point
     @return the y of the first point
     */
    public double getSecondPointY(){
        return points[1].getY();
    }
    /**
     Get the horizontal axi of the third point
     @return the x of the first point
     */
    public double getThirdPointX(){
        return points[2].getX();
    }
    /**
     Get the ordinate axi of the third point
     @return the y of the first point
     */
    public double getThirdPointY(){
        return points[2].getY();
    }
    /**
     Get the horizontal axi of the fourth point
     @return the x of the first point
     */
    public double getFourthPointX(){
        return points[3].getX();
    }
    /**
     Get the ordinate axi of the fourth point
     @return the y of the first point
     */
    public double getFourthPointY(){
        return points[3].getY();
    }
    /**
     Get the horizontal axi of the fifth point
     @return the x of the first point
     */
    public double getFifthPointX(){
        return points[4].getX();
    }
    /**
     Get the ordinate axi of the fifth point
     @return the y of the first point
     */
    public double getFifthPointY(){
        return points[4].getY();
    }

    /**
     Set the coordinates of the idx point
     @param x x-coordinate
     @param y y-coordinate
     */
    private void setPoint(int x, int y, int nums){

        if(nums >= 0 && nums <= MAX_POINTS){
            points[nums] = new Point2D.Double(x,y);
            numPoints++;
        }
    }
    /**
     Clear the points
     */
    public void clearPoints(){
        numPoints = 0;
    }

    /**
     Draw the image
     @return the image
     */
    public JPanel createDrawingArea() {
        JPanel draw = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                if (numPoints > 0) {
                    if (shape[0] == 1 && color[0] == 1) {
                        g2.setColor(Color.RED);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[0].getX(), points[0].getY(), size[0], size[0]);
                        g2.fill(circle);

                    } else if (shape[0] == 1 && color[0] == 2) {
                        g2.setColor(Color.BLUE);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[0].getX(), points[0].getY(), size[0], size[0]);
                        g2.fill(circle);
                    } else if (shape[0] == 1 && color[0] == 3) {
                        g2.setColor(Color.YELLOW);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[0].getX(), points[0].getY(), size[0], size[0]);
                        g2.fill(circle);

                    }
                    if (shape[0] == 2 && color[0] == 1) {

                        g2.setColor(Color.RED);
                        Rectangle box = new Rectangle((int) points[0].getX(), (int) points[0].getY(), size[0] + 50, size[0]);
                        g2.fill(box);
                    } else if (shape[0] == 2 && color[0] == 2) {
                        g2.setColor(Color.BLUE);
                        Rectangle box = new Rectangle((int) points[0].getX(), (int) points[0].getY(), size[0] + 50, size[0]);
                        g2.fill(box);
                    } else if (shape[0] == 2 && color[0] == 3) {
                        g2.setColor(Color.YELLOW);
                        Rectangle box = new Rectangle((int) points[0].getX(), (int) points[0].getY(), size[0] + 50, size[0]);
                        g2.fill(box);

                    }
                }
                if (numPoints > 1) {
                    if (shape[1] == 1 && color[1] == 1) {
                        g2.setColor(Color.RED);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[1].getX(), points[1].getY(), size[1], size[1]);
                        g2.fill(circle);
                    } else if (shape[1] == 1 && color[1] == 2) {
                        g2.setColor(Color.BLUE);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[1].getX(), points[1].getY(), size[1], size[1]);
                        g2.fill(circle);
                    } else if (shape[1] == 1 && color[1] == 3) {
                        g2.setColor(Color.YELLOW);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[1].getX(), points[1].getY(), size[1], size[1]);
                        g2.fill(circle);

                    }
                    if (shape[1] == 2 && color[1] == 1) {
                        g2.setColor(Color.RED);
                        Rectangle box = new Rectangle((int) points[1].getX(), (int) points[1].getY(), size[1] + 50, size[1]);
                        g2.fill(box);
                    } else if (shape[1] == 2 && color[1] == 2) {
                        g2.setColor(Color.BLUE);
                        Rectangle box = new Rectangle((int) points[1].getX(), (int) points[1].getY(), size[1] + 50, size[1]);
                        g2.fill(box);
                    } else if (shape[1] == 2 && color[1] == 3) {
                        g2.setColor(Color.YELLOW);
                        Rectangle box = new Rectangle((int) points[1].getX(), (int) points[1].getY(), size[1] + 50, size[1]);
                        g2.fill(box);
                    }
                }
                if (numPoints > 2) {
                    if (shape[2] == 1 && color[2] == 1) {
                        g2.setColor(Color.RED);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[2].getX(), points[2].getY(), size[2], size[2]);
                        g2.fill(circle);
                    } else if (shape[2] == 1 && color[2] == 2) {
                        g2.setColor(Color.BLUE);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[2].getX(), points[2].getY(), size[2], size[2]);
                        g2.fill(circle);
                    } else if (shape[2] == 1 && color[2] == 3) {
                        g2.setColor(Color.YELLOW);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[2].getX(), points[2].getY(), size[2], size[2]);
                        g2.fill(circle);
                    }
                    if (shape[2] == 2 && color[2] == 1) {
                        g2.setColor(Color.RED);
                        Rectangle box = new Rectangle((int) points[2].getX(), (int) points[2].getY(), size[2] + 50, size[2]);
                        g2.fill(box);
                    } else if (shape[2] == 2 && color[2] == 2) {
                        g2.setColor(Color.BLUE);
                        Rectangle box = new Rectangle((int) points[2].getX(), (int) points[2].getY(), size[2] + 50, size[2]);
                        g2.fill(box);
                    } else if (shape[2] == 2 && color[2] == 3) {
                        g2.setColor(Color.YELLOW);
                        Rectangle box = new Rectangle((int) points[2].getX(), (int) points[2].getY(), size[2] + 50, size[2]);
                        g2.fill(box);

                    }
                }
                if (numPoints > 3) {
                    if (shape[3] == 1 && color[3] == 1) {
                        g2.setColor(Color.RED);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[3].getX(), points[3].getY(), size[3], size[3]);
                        g2.fill(circle);
                    } else if (shape[3] == 1 && color[3] == 2) {
                        g2.setColor(Color.BLUE);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[3].getX(), points[3].getY(), size[3], size[3]);
                        g2.fill(circle);
                    } else if (shape[3] == 1 && color[3] == 3) {
                        g2.setColor(Color.YELLOW);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[3].getX(), points[3].getY(), size[3], size[3]);
                        g2.fill(circle);
                    }
                    if (shape[3] == 2 && color[3] == 1) {
                        g2.setColor(Color.RED);
                        Rectangle box = new Rectangle((int) points[3].getX(), (int) points[3].getY(), size[3] + 50, size[3]);
                        g2.fill(box);
                    } else if (shape[3] == 2 && color[3] == 2) {
                        g2.setColor(Color.BLUE);
                        Rectangle box = new Rectangle((int) points[3].getX(), (int) points[3].getY(), size[3] + 50, size[3]);
                        g2.fill(box);
                    } else if (shape[3] == 2 && color[3] == 3) {
                        g2.setColor(Color.YELLOW);
                        Rectangle box = new Rectangle((int) points[3].getX(), (int) points[3].getY(), size[3] + 50, size[3]);
                        g2.fill(box);

                    }
                }
                if (numPoints > 4) {
                    if (shape[4] == 1 && color[4] == 1) {
                        g2.setColor(Color.RED);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[4].getX(), points[4].getY(), size[3], size[3]);
                        g2.fill(circle);
                    } else if (shape[4] == 1 && color[4] == 2) {
                        g2.setColor(Color.BLUE);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[4].getX(), points[4].getY(), size[3], size[3]);
                        g2.fill(circle);
                    } else if (shape[4] == 1 && color[4] == 3) {
                        g2.setColor(Color.YELLOW);
                        Ellipse2D.Double circle = new Ellipse2D.Double(points[4].getX(), points[4].getY(), size[3], size[3]);
                        g2.fill(circle);
                    }
                    if (shape[4] == 2 && color[4] == 1) {
                        g2.setColor(Color.RED);
                        Rectangle box = new Rectangle((int) points[4].getX(), (int) points[4].getY(), size[3] + 50, size[3]);
                        g2.fill(box);
                    } else if (shape[4] == 2 && color[4] == 2) {
                        g2.setColor(Color.BLUE);
                        Rectangle box = new Rectangle((int) points[4].getX(), (int) points[4].getY(), size[3] + 50, size[3]);
                        g2.fill(box);
                    } else if (shape[4] == 2 && color[4] == 3) {
                        g2.setColor(Color.YELLOW);
                        Rectangle box = new Rectangle((int) points[4].getX(), (int) points[4].getY(), size[3] + 50, size[3]);
                        g2.fill(box);
                    }
                }
                repaint();
            }
        };
        return draw;
    }

    }





