package com;

// import the JPanel 
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends javax.swing.JFrame {
	// declare the varibles which I will use
	private JButton Enter;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JTextField BMI;
	private JTextField Name;
	private JTextField Age;
	private JTextField Height;
	private JTextField Weight;
	private String name;
	private int age;
	private double weight; // in pounds
	private double height; // in inches
	public static final double KILOGRAMS_PER_POUND = 0.45359237;
	public static final double METERS_PER_INCH = 0.0254;
	private double bmi;
	private String status;

	// The constructor of this class
	public BMI(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	// The constructor of this class
	public BMI(String name, double weight, double height) {
		this(name, 20, weight, height);
	}

	// The constructor of this class
	public BMI() {
		// set the title
		super("BMI");
		// Let it have default close
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		// Make the Panel GridLayout..
		this.setLayout(new GridLayout(6, 3, 3, 3));

		label1 = new JLabel("姓名 : ");
		// Let the element be contained the Frame
		this.add(label1);

		Name = new JTextField();
		// Let the element be contained the Frame
		this.add(Name);

		label2 = new JLabel("先生 / 小姐");
		// Let the element be contained the Frame
		this.add(label2);

		label3 = new JLabel("年齡 : ");
		// Let the element be contained the Frame
		this.add(label3);

		Age = new JTextField();
		// Let the element be contained the Frame
		this.add(Age);

		label4 = new JLabel("歲");
		// Let the element be contained the Frame
		this.add(label4);

		label5 = new JLabel("身高 : ");
		// Let the element be contained the Frame
		this.add(label5);

		Height = new JTextField();
		// Let the element be contained the Frame
		this.add(Height);

		label6 = new JLabel("英呎");
		// Let the element be contained the Frame
		this.add(label6);

		label7 = new JLabel("體重 : ");
		// Let the element be contained the Frame
		this.add(label7);

		Weight = new JTextField();
		// Let the element be contained the Frame
		this.add(Weight);

		label8 = new JLabel("磅");
		// Let the element be contained the Frame
		this.add(label8);

		label11 = new JLabel("");
		// Let the element be contained the Frame
		this.add(label11);

		Enter = new JButton("確定");
		// Let the element be contained the Frame
		this.add(Enter);

		label12 = new JLabel("");
		// Let the element be contained the Frame
		this.add(label12);

		label9 = new JLabel("BMI : ");
		// Let the element be contained the Frame
		this.add(label9);

		BMI = new JTextField();
		// Let the element be contained the Frame
		this.add(BMI);

		label10 = new JLabel("kg / (m * m)");
		// Let the element be contained the Frame
		this.add(label10);
		// set the event when I click the button Enter
		Enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// set the event when I click the button
				// get the String on the TextField
				name = Name.getText().trim();
				// get the value from those TextField
				age = Integer.parseInt(Age.getText().trim());
				height = Double.parseDouble(Height.getText().trim());
				weight = Double.parseDouble(Weight.getText().trim());
				bmi = getBMI();
				status = getStatus();
				// set the result
				BMI.setText(bmi + "     " + status);
			}
		});

	}

	public static void main(String[] args) {

		try {
			// new the BMI Object
			BMI frame = new BMI();
			// Let JFrame be visible
			frame.setVisible(true);
			// set the JFrame Size
			frame.setSize(500, 400);
			// Let the JFrame center
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {

		}
	}

	// The method that calculate BMI
	public double getBMI() {
		double bmi = weight * KILOGRAMS_PER_POUND
				/ ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100) / 100.0;
	}

	// Show the status
	public String getStatus() {
		double bmi = getBMI();
		if (bmi < 18.5)
			return "Underweight";
		else if (bmi < 25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
	}

	// show Name
	public String showName() {
		return name;
	}

	// show Age
	public int showAge() {
		return age;
	}

	// show Weight
	public double showWeight() {
		return weight;
	}

	// show Height
	public double showHeight() {
		return height;
	}
}
