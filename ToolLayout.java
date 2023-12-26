import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
/**
 This frame contains a drawing panel and a control panel
 to status of image.
 */
public class ToolLayout extends JFrame {
    private JRadioButton circleButton;
    private JRadioButton rectangleButton;
    private JComboBox sizeCombo;
    private JButton buttonRed;
    private JButton buttonYellow;
    private JButton buttonBlue;
    private JFrame frame;
    int shape = 1;
    int size = 300;
    int color = 1;
    /**
     Constructs the frame.
     */
    ShapeDrewerComponent component = new ShapeDrewerComponent();

    public ToolLayout()
    {
        frame =  new JFrame("Shape Drawing Tool");
        JPanel draw = component.createDrawingArea();
        draw.setBorder(new TitledBorder(new EtchedBorder(), "Draw Area"));
        JPanel selection = createControlPanel();
        draw.add(component);
        frame.add(selection, BorderLayout.NORTH);
        frame.add(draw, BorderLayout.CENTER);
        frame.setSize(800,900);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        final int MAX_CLICKS = 5;


        class MousePressedListener extends MouseAdapter {

            public void mousePressed(MouseEvent event)
            {
                if(clicks >= MAX_CLICKS)
                {
                    component.clearPoints();
                    clicks = 0;
                }

                int mouseX = event.getX();
                int mouseY = event.getY();

                if(clicks == 0){
                    component.shape[0] = shape;
                    component.color[0] = color;
                    component.size[0] = size;
                    component.setFirstPoint(mouseX,mouseY);
                }else if(clicks == 1){
                    component.shape[1] = shape;
                    component.color[1] = color;
                    component.size[1] = size;
                    component.setSecondPoint(mouseX,mouseY);
                }else if(clicks == 2){
                    component.shape[2] = shape;
                    component.color[2] = color;
                    component.size[2] = size;
                    component.setThirdPoint(mouseX,mouseY);
                }else if(clicks == 3){
                    component.shape[3] = shape;
                    component.color[3] = color;
                    component.size[3] = size;
                    component.setFourthPoint(mouseX,mouseY);
                }else if(clicks == 4){
                    component.shape[4] = shape;
                    component.color[4] = color;
                    component.size[4] = size;
                    component.setFifthPoint(mouseX,mouseY);
                }

                clicks++;
            }
            private int clicks = 0;
        }

        MousePressedListener listener = new MousePressedListener();
        draw.addMouseListener(listener);


    }
    /**
     Creates the Mouse Listener to listen the selection of shape.
     */
    class MousePressedListener2 implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(circleButton.isSelected()) {
                shape = 1;
            }else if(rectangleButton.isSelected()){
                shape = 2;
            }

        }
    }
    /**
     Creates the Mouse Listener to listen the selection of color.
     */
    class MousePressedListener3 implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("RED")) {
                color = 1;
            } else if (event.getActionCommand().equals("BLUE")) {
                color = 2;
            } else if (event.getActionCommand().equals("YELLOW")) {
                color = 3;
            }
        }
    }
    /**
     Creates the Mouse Listener to listen the selection of size.
     */
    class MousePressedListener4 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            final int SMALL_SIZE = 50;
            final int MEDIUM_SIZE = 120;
            final int BIG_SIZE = 200;
            if (sizeCombo.getSelectedItem() == "Small") {
                size = SMALL_SIZE;
            } else if (sizeCombo.getSelectedItem() == "Medium") {
                size = MEDIUM_SIZE;
            } else if (sizeCombo.getSelectedItem() == "Big") {
                size = BIG_SIZE;
            }

        }
    }
    /**
     Creates the control panel to change the status of image.
     */
    public JPanel createControlPanel()
    {
        JPanel sizePanel = createComboBox();
        JPanel colorPanel = createButtons();
        JPanel shapeGroupPanel = createRadioButtons();


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));
        controlPanel.add(shapeGroupPanel);
        controlPanel.add(colorPanel);
        controlPanel.add(sizePanel);

        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Selection Area"));


        return controlPanel;

    }
    /**
     Creates the combo box with the size of image.
     @return the panel containing the combo box
     */
    public JPanel createComboBox()
    {
        sizeCombo = new JComboBox<String>();
        MousePressedListener4 listener4 = new MousePressedListener4();
        sizeCombo.addItem("Big");
        sizeCombo.addItem("Medium");
        sizeCombo.addItem("Small");
        sizeCombo.setEditable(false);


        sizeCombo.addActionListener(listener4);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Size "));
        panel.add(sizeCombo);
        return panel;
    }
    /**
     Creates the radio buttons to select the shape of image.
     @return the panel containing the radio buttons
     */
    public JPanel createRadioButtons()
    {
        circleButton = new JRadioButton("circle");
        MousePressedListener2 listener2 = new MousePressedListener2();
        circleButton.addActionListener(listener2);


        rectangleButton = new JRadioButton("rectangle");
        rectangleButton.addActionListener(listener2);


        ButtonGroup group = new ButtonGroup();
        group.add(circleButton);
        group.add(rectangleButton);
        circleButton.setSelected(true);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Shape "));
        panel.add(circleButton);
        panel.add(rectangleButton);

        return panel;
    }
    /**
     Creates the buttons to select the color of image.
     @return the panel containing the radio buttons
     */
    public JPanel createButtons(){


        MousePressedListener3 listener3 = new MousePressedListener3();

        buttonRed = new JButton("RED");
        buttonRed.addActionListener(listener3);
        buttonRed.setBackground(Color.red);

        buttonBlue = new JButton("BLUE");
        buttonBlue.addActionListener(listener3);
        buttonBlue.setBackground(Color.blue);

        buttonYellow = new JButton("YELLOW");
        buttonYellow.addActionListener(listener3);
        buttonYellow.setBackground(Color.yellow);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("Color "));
        buttonPanel.add(buttonRed);
        buttonPanel.add(buttonBlue);
        buttonPanel.add(buttonYellow);

        return buttonPanel;

    }
    /**
     Creates the Action Listener to listen the saving activities.
     */
    class SaveItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
                try {
                    PrintWriter f = new PrintWriter("D:\\shapeDrawing.txt");
                    if(component.getFirstPointX() != 0 && component.getFirstPointY() != 0) {
                        f.println(component.getFirstPointX() + " " + component.getFirstPointY() + " " + component.shape[0] + " " + component.color[0] + " " + component.size[0]);
                    }
                    if(component.getSecondPointX() != 0 && component.getSecondPointY() != 0) {
                        f.println(component.getSecondPointX() + " " + component.getSecondPointY() + " " + component.shape[1] + " " + component.color[1] + " " + component.size[1]);
                    }
                    if(component.getThirdPointX() != 0 && component.getThirdPointY() != 0) {
                        f.println(component.getThirdPointX() + " " + component.getThirdPointY() + " " + component.shape[2] + " " + component.color[2] + " " + component.size[2]);
                    }
                    if(component.getFourthPointX() != 0 && component.getFourthPointY() != 0) {
                        f.println(component.getFourthPointX() + " " + component.getFourthPointY() + " " + component.shape[3] + " " + component.color[3] + " " + component.size[3]);
                    }
                    if(component.getFifthPointX() != 0 && component.getFifthPointY() != 0) {
                        f.println(component.getFifthPointX() + " " + component.getFifthPointY() + " " + component.shape[4] + " " + component.color[4] + " " + component.size[4]);
                    }

                    f.close();
                    JOptionPane.showMessageDialog(null, "Drawing successful saved!", "Message",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(NoSuchElementException f){
                    JOptionPane.showMessageDialog(null, "NO saved drawing!", "Message",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(IOException f){
                    JOptionPane.showMessageDialog(null, "NO saved drawing!", "Message",JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
    /**
     Creates the Action Listener to listen the loading activities.
     */
    class LoadItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try {
                File f1 = new File("D:\\shapeDrawing.txt");
                Scanner load = new Scanner(f1);
                for(int i=0; i>=5; i++) {
                    component.createDrawingArea();
                    int xi = load.nextInt();
                    int yi = load.nextInt();
                    component.setFirstPoint(xi, yi);
                    component.shape[i] = load.nextInt();
                    component.color[i] = load.nextInt();
                    component.size[i] = load.nextInt();
                    repaint();
                    load.nextLine();
                }
                load.close();
                JOptionPane.showMessageDialog(null, "Drawing successful loaded!", "Message",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(FileNotFoundException f){
                JOptionPane.showMessageDialog(null, "NO saved drawing!", "Message",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IOException f){
                JOptionPane.showMessageDialog(null, "NO saved drawing!", "Message",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    /**
     Creates the menu to save and load file.
     @return the menu containing the  menu item
     */
    public JMenu createFileMenu()
    {
        JMenu menu = new JMenu("File");
        JMenuItem saveFile = new JMenuItem("Save");
        ActionListener listenerSave = new SaveItemListener();
        saveFile.addActionListener(listenerSave);
        menu.add(saveFile);
        JMenuItem loadFile = new JMenuItem("Load");
        ActionListener listenerLoad = new LoadItemListener();
        loadFile.addActionListener(listenerLoad);
        menu.add(loadFile);
        return menu;
    }

    }







