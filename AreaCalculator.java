import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class AreaCalculator extends JFrame {

    private JTextField lengthField, widthField, baseField, heightField, sideField, radiusField, majorAxisField, minorAxisField;
    private JComboBox<String> shapeComboBox, inputUnitComboBox, outputUnitComboBox;
    private JTextArea resultArea;

    private static final double METER_CONVERSION = 1.0;
    private static final double INCH_CONVERSION = 0.0254;
    private static final double FOOT_CONVERSION = 0.3048;
    private static final double MILLIMETER_CONVERSION = 0.001;
    private static final double DECIMETER_CONVERSION = 0.1;
    private static final double KILOMETER_CONVERSION = 1000.0;
    private static final double YARD_CONVERSION = 0.9144;
    private static final double MILE_CONVERSION = 1609.34;
    private static final double CENTIMETER_CONVERSION = 0.01;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AreaCalculator().setVisible(true);
            }
        });
    }

    public AreaCalculator() {
        setTitle("Area Calculator");
        ImageIcon icon = new ImageIcon("priyanka.jpg");
        setIconImage(icon.getImage());
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(0,153,255));
        JLabel shapeLabel = new JLabel("Select Shape:");
        shapeLabel.setBounds(200, 5, 120, 20);

        String[] shapes = {"Circle", "Rectangle","Triangle", "Square", "Trapezoid","Octagon", "Parallelogram"};
        shapeComboBox = new JComboBox(shapes);
        shapeComboBox.setBounds(300, 5, 120, 20);

        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setBounds(5,35, 80, 20);
        lengthField = new JTextField();
        lengthField.setBounds(50,35, 100, 20);

        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setBounds(150,35, 80, 20);
        widthField = new JTextField();
        widthField.setBounds(190,35, 100, 20);

        JLabel baseLabel = new JLabel("Base:");
        baseLabel.setBounds(295,35, 80, 20);
        baseField = new JTextField();
        baseField.setBounds(330,35, 100, 20);

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setBounds(435,35, 80, 20);
        heightField = new JTextField();
        heightField.setBounds(475,35, 100, 20);

        JLabel sideLabel = new JLabel("Side:");
        sideLabel.setBounds(150, 70, 80, 20);
        sideField = new JTextField();
        sideField.setBounds(190, 70, 100, 20);

        JLabel radiusLabel = new JLabel("Radius:");
        radiusLabel.setBounds(5,70, 80, 20);
        radiusField = new JTextField();
        radiusField.setBounds(50,70, 100, 20);
        JLabel inputUnitLabel = new JLabel("Input Unit:");
        inputUnitLabel.setBounds(5,120, 80, 20);
        String[] units = {"m", "in", "ft", "mm", "dm", "km", "yd", "mi", "cm"};
        inputUnitComboBox = new JComboBox(units);
        inputUnitComboBox.setBounds(95, 120, 60, 20);

        JLabel outputUnitLabel = new JLabel("Output Unit:");
        outputUnitLabel.setBounds(5, 170, 80, 20);
        outputUnitComboBox = new JComboBox(units);
        outputUnitComboBox.setBounds(95, 170, 60, 20);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(330, 360, 100, 30);
    
        calculateButton.setBackground(SystemColor.inactiveCaption); 
        resultArea = new JTextArea();
        resultArea.setBounds(227,118, 335, 220);
        resultArea.setEditable(false);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateArea();
            }
        });
        getContentPane().add(shapeLabel);
        getContentPane().add(shapeComboBox);
        getContentPane().add(lengthLabel);
        getContentPane().add(lengthField);
        getContentPane().add(widthLabel);
        getContentPane().add(widthField);
        getContentPane().add(baseLabel);
        getContentPane().add(baseField);
        getContentPane().add(heightLabel);
        getContentPane().add(heightField);
        getContentPane().add(sideLabel);
        getContentPane().add(sideField);
        getContentPane().add(radiusLabel);
        getContentPane().add(radiusField);
        getContentPane().add(inputUnitLabel);
        getContentPane().add(inputUnitComboBox);
        getContentPane().add(outputUnitLabel);
        getContentPane().add(outputUnitComboBox);
        getContentPane().add(calculateButton);
        getContentPane().add(resultArea);
    }

    private void calculateArea() {
        double inputValue = 0;

        try {
            switch (inputUnitComboBox.getSelectedItem().toString()) {
                case "m":
                    inputValue = Double.parseDouble(getSelectedTextField().getText());
                    break;
                case "in":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * INCH_CONVERSION;
                    break;
                case "ft":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * FOOT_CONVERSION;
                    break;
                case "mm":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * MILLIMETER_CONVERSION;
                    break;
                case "dm":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * DECIMETER_CONVERSION;
                    break;
                case "km":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * KILOMETER_CONVERSION;
                    break;
                case "yd":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * YARD_CONVERSION;
                    break;
                case "mi":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * MILE_CONVERSION;
                    break;
                case "cm":
                    inputValue = Double.parseDouble(getSelectedTextField().getText()) * CENTIMETER_CONVERSION;
                    break;
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid number.");
            return;
        }

        double area = 0;
        String outputUnit = outputUnitComboBox.getSelectedItem().toString();

        switch (shapeComboBox.getSelectedItem().toString()) {
            case "Square":
                area = inputValue * inputValue;
                break;
            case "Rectangle":
                area = Double.parseDouble(lengthField.getText()) * Double.parseDouble(widthField.getText());
                break;
            case "Triangle":
                area = 0.5 * Double.parseDouble(baseField.getText()) * Double.parseDouble(heightField.getText());
                break;
            case "Circle":
                area = Math.PI * Math.pow(Double.parseDouble(radiusField.getText()), 2);
                break;
            case "Trapezoid":
                area = 0.5 * (Double.parseDouble(baseField.getText()) + Double.parseDouble(sideField.getText())) *
                        Double.parseDouble(heightField.getText());
                break;
            case "Sector":
                area = (Double.parseDouble(radiusField.getText()) * Double.parseDouble(radiusField.getText()) *
                        Double.parseDouble(majorAxisField.getText())) / 2;
                break;
            case "Octagon":
                area = 2 * (1 + Math.sqrt(2)) * Double.parseDouble(sideField.getText()) * Double.parseDouble(sideField.getText());
                break;
            case "Ellipse":
                area = Math.PI * Double.parseDouble(majorAxisField.getText()) * Double.parseDouble(minorAxisField.getText());
                break;
            case "Parallelogram":
                area = Double.parseDouble(baseField.getText()) * Double.parseDouble(heightField.getText());
                break;
        }

        switch (outputUnit) {
            case "in":
                area /= INCH_CONVERSION;
                break;
            case "ft":
                area /= FOOT_CONVERSION;
                break;
            case "mm":
                area /= MILLIMETER_CONVERSION;
                break;
            case "dm":
                area /= DECIMETER_CONVERSION;
                break;
            case "km":
                area /= KILOMETER_CONVERSION;
                break;
            case "yd":
                area /= YARD_CONVERSION;
                break;
            case "mi":
                area /= MILE_CONVERSION;
                break;
            case "cm":
                area /= CENTIMETER_CONVERSION;
                break;
        }

        resultArea.setText("Area: " + area + " " + outputUnit + "²");
    }

    private JTextField getSelectedTextField() {
        String selectedShape = shapeComboBox.getSelectedItem().toString();
        switch (selectedShape) {
            case "Square":
            case "Rectangle":
            case "Parallelogram":
                return lengthField;
            case "Triangle":
            case "Trapezoid":
                return baseField;
            case "Circle":
            case "Sector":
                return radiusField;
            case "Octagon":
                return sideField;
            case "Ellipse":
                return majorAxisField;
            default:
                return lengthField;
        }
    }

   
}