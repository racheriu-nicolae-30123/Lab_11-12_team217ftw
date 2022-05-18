package aut.utcluj.isp.ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View{

    private JLabel enterSum=new JLabel("Enter Sum:");
    private JButton submitSum=new JButton("SUBMIT");
    private JTextField textSum=new JTextField();
    private JFrame frame=new JFrame();
    private User user;
    private JLabel title;

    private JCheckBox c1=new JCheckBox("Salam(10)");
    private JCheckBox c2=new JCheckBox("Susan(2)");
    private JCheckBox c3=new JCheckBox("Mujdei(6)");

    private JTextField q1=new JTextField();
    private JTextField q2=new JTextField();
    private JTextField q3=new JTextField();

    private JButton submit=new JButton("Submit to cart");



    public View()
    {
        frame.setLayout(null);frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        enterSum.setBounds(80,200,150,30);enterSum.setFont(new Font("Serif", Font.PLAIN, 30));
        textSum.setBounds(250,204,100,30);submitSum.setFocusable(false);
        textSum.setFont(new Font("Serif", Font.PLAIN, 30));
        submitSum.setBounds(200,250,80,30);
        submitSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textSum.getText()!=null)
                {
                    user=new User(Double.parseDouble(textSum.getText()));
                    title=new JLabel("Your sum is "+user.userMoney);
                    submitSum.setVisible(false);
                    textSum.setVisible(false);
                    enterSum.setVisible(false);

                    title.setBounds(150,30,300,30);
                    title.setFont(new Font("Serif", Font.PLAIN, 30));

                    c1.setBounds(10,150,150,50);c1.setFont(new Font("Serif", Font.PLAIN, 30));q1.setBounds(170,170,120,20);
                    c2.setBounds(10,190,150,50);c2.setFont(new Font("Serif", Font.PLAIN, 30));q2.setBounds(170,210,120,20);
                    c3.setBounds(10,230,150,50);c3.setFont(new Font("Serif", Font.PLAIN, 30));q3.setBounds(170,250,120,20);

                    submit.setBounds(100,280,200,20);
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(c1.isSelected() && q1!=null)
                                user.addProductToCart(new Product("1",10.0),Integer.parseInt(q1.getText()));
                            if(c2.isSelected() && q2!=null)
                                user.addProductToCart(new Product("2",2.0),Integer.parseInt(q2.getText()));
                            if(c3.isSelected() && q3!=null)
                                user.addProductToCart(new Product("3",6.0),Integer.parseInt(q3.getText()));
                            try {
                                user.submitCart();
                            } catch (NotEnoughMoneyException notEnoughMoneyException) {
                                title.setText("Du-te acasa");
                                notEnoughMoneyException.printStackTrace();

                            }
                            if(user.userMoney>0)
                            title.setText("Your sum is "+user.userMoney);
                            else
                                title.setText("Du-te acasa");

                        }
                    });
                    frame.add(c1);
                    frame.add(c2);
                    frame.add(c3);

                    frame.add(q1);
                    frame.add(q2);
                    frame.add(q3);

                    frame.add(submit);

                    frame.add(title);
                }
            }
        });

        frame.add(enterSum);
        frame.add(submitSum);
        frame.add(textSum);
        frame.setVisible(true);
    }
}
