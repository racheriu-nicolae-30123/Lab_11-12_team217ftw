package aut.utcluj.isp.ex3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends StockController{
    private JFrame frame=new JFrame("Stock");
    private JLabel product=new JLabel("Product");
    private JLabel category=new JLabel("Category");
    private JLabel quantity=new JLabel("Quantity");
    private JLabel pret=new JLabel("Pret");
    private JTextField textFieldProduct=new JTextField();
    private JTextField textFieldCategory=new JTextField();
    private JTextField textFieldQuantity=new JTextField();
    private JTextField textFieldPret=new JTextField();
    private JButton submit=new JButton("Submit");
    private JTable table;
    private DefaultTableModel defaultTableModel;
    private JScrollPane scrollPane;

    public UI()
    {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        product.setBounds(30,30,100,30);textFieldProduct.setBounds(170,35,150,30);
        product.setVisible(true);textFieldProduct.setVisible(true);
        product.setFont(new Font("Serif", Font.PLAIN, 30));textFieldProduct.setFont(new Font("Serif", Font.PLAIN, 30));

        category.setBounds(30,80,120,35);textFieldCategory.setBounds(170,85,150,30);
        category.setVisible(true);textFieldCategory.setVisible(true);
        category.setFont(new Font("Serif", Font.PLAIN, 30));textFieldCategory.setFont(new Font("Serif", Font.PLAIN, 30));

        quantity.setBounds(30,135,120,35);textFieldQuantity.setBounds(170,140,150,30);
        quantity.setVisible(true);
        quantity.setFont(new Font("Serif", Font.PLAIN, 30));textFieldQuantity.setFont(new Font("Serif", Font.PLAIN, 30));

        pret.setBounds(30,190,120,35);textFieldPret.setBounds(170,195,150,30);textFieldPret.setFont(new Font("Serif", Font.PLAIN, 30));
        pret.setFont(new Font("Serif", Font.PLAIN, 30));

        submit.setBounds(190,300,100,30);
        submit.setFocusable(false);

        defaultTableModel=new DefaultTableModel();
        table=new JTable(defaultTableModel);
        defaultTableModel.addColumn("Product");defaultTableModel.addColumn("Category");

        scrollPane=new JScrollPane(table);
        scrollPane.setVisible(true);
        scrollPane.setBounds(400,30,200,300);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(quantity.getText()!=null && category.getText()!=null && product.getText()!=null)
                {    for(int i=1;i<=Integer.parseInt(textFieldQuantity.getText());i++) {
                    String[] row = {textFieldProduct.getText(), textFieldCategory.getText()};
                    defaultTableModel.addRow(row);
                }
                addProductToCatalogue(new Product(textFieldProduct.getText(),Double.parseDouble(textFieldPret.getText())),Integer.parseInt(textFieldQuantity.getText()));
                    System.out.println("Inserted into catalogue");
                }

            }
        });



        frame.add(product);frame.add(textFieldProduct);
        frame.add(category);frame.add(textFieldCategory);
        frame.add(quantity);frame.add(textFieldQuantity);
        frame.add(submit);frame.add(scrollPane);
        frame.add(pret);frame.add(textFieldPret);




    }
}
