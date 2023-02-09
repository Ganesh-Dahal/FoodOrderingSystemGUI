import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FoodOrderingSystem {

    private final JFrame frame;
    private final JPanel panel;
    private final JButton burgerButton;
    private final JButton pastaButton;
    private final JButton saladButton;
    private final JButton cancelOrderButton;
    private final JButton quitButton;
    private final JTextArea orderListArea;
    private final JLabel totalLabel;

    private int choice;
    private double total = 0;
    private final ArrayList<String> orderList = new ArrayList<>();

    public FoodOrderingSystem() {
        frame = new JFrame("Food Ordering System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        JButton pizzaButton = new JButton("Pizza - Rs100");
        pizzaButton.setBounds(50, 50, 150, 30);
        panel.add(pizzaButton);

        burgerButton = new JButton("Burger - Rs150");
        burgerButton.setBounds(50, 100, 150, 30);
        panel.add(burgerButton);

        pastaButton = new JButton("Pasta - Rs400");
        pastaButton.setBounds(50, 150, 150, 30);
        panel.add(pastaButton);

        saladButton = new JButton("Salad - Rs200");
        saladButton.setBounds(50, 200, 150, 30);
        panel.add(saladButton);

        cancelOrderButton = new JButton("Cancel Order");
        cancelOrderButton.setBounds(200, 250, 150, 30);
        panel.add(cancelOrderButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(50, 250, 150, 30);
        panel.add(quitButton);

        orderListArea = new JTextArea();
        orderListArea.setBounds(250, 50, 100, 200);
        panel.add(orderListArea);

        totalLabel = new JLabel("Total: Rs" + total);
        totalLabel.setBounds(250, 300, 100, 30);
        panel.add(totalLabel);

        frame.add(panel);
        frame.setVisible(true);

        pizzaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderList.add("Pizza");
                total += 100;
                updateOrderList();
                updateTotal();
            }
        });
        burgerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderList.add("Burger");
                total += 150;
                updateOrderList();
                updateTotal();
            }
        });
        pastaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderList.add("Pasta");
                total += 400;
                updateOrderList();
                updateTotal();
            }
        });
        saladButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderList.add("Salad");
                total += 200;
                updateOrderList();
                updateTotal();
            }
        });
        cancelOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderList.clear();
                total = 0;
                updateOrderList();
                updateTotal();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
         JButton orderButton;
        orderButton = new JButton("Order");

        orderButton.setBounds(50, 300, 150, 30);
        panel.add(orderButton);

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Order List:");
                for (String s : orderList) {
                    System.out.println(s);
                }
            }
        });
    }
    public void updateOrderList() {
        orderListArea.setText(null);
        for (String s : orderList) {
            orderListArea.append(s + "\n");
        }
    }

    public void updateTotal() {
        totalLabel.setText("Total: Rs" + total);
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }

}
