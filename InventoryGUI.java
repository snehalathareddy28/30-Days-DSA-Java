import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class Item {
    int quantity;
    String imagePath;

    Item(int quantity, String imagePath) {
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
}

public class InventoryGUI extends JFrame {

    public InventoryGUI(HashMap<String, Item> stock) {
        setTitle("Inventory Stock Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        int totalStock = 0;

        for (String itemName : stock.keySet()) {
            Item item = stock.get(itemName);
            totalStock += item.quantity;

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // Load and scale image
            ImageIcon icon = new ImageIcon(item.imagePath);
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(img));

            // Status text
            String status;
            if (item.quantity == 0) {
                status = itemName + " is out of stock";
            } else if (item.quantity < 5) {
                status = itemName + " is low in stock (qty: " + item.quantity + ")";
            } else {
                status = itemName + " is sufficiently stocked (qty: " + item.quantity + ")";
            }

            JLabel textLabel = new JLabel(status);
            textLabel.setFont(new Font("Arial", Font.PLAIN, 16));

            panel.add(imageLabel);
            panel.add(textLabel);
            add(panel);
        }

        JLabel totalLabel = new JLabel("Total inventory stock: " + totalStock);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(totalLabel);

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    public static void main(String[] args) {
        HashMap<String, Item> stock = new HashMap<>();
        stock.put("Apples", new Item(3, "apple.png"));
        stock.put("Bananas", new Item(2, "orange.png"));
        stock.put("Bread", new Item(2, "cherries.png"));
        stock.put("Yogurt", new Item(0, "images/yogurt.png"));

        new InventoryGUI(stock);
    }
}