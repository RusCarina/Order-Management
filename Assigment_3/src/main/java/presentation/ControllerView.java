package presentation;

import bll.OrdersBLL;
import bll.ProductsBLL;
import com.mysql.cj.xdevapi.Client;
import dao.ClientsDAO;
import model.Clients;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

import bll.ClientsBLL;
import model.Orders;
import model.Products;

public class ControllerView extends JFrame{
    private List<Clients> clienti = new ArrayList<Clients>();
    private List<Products> products = new ArrayList<Products>();
    private List<Orders> orders = new ArrayList<Orders>();
    private int i;
    private JButton b1 = new JButton("Clients");
    private JButton b2 = new JButton("Products");
    private JButton b3 = new JButton("Orders");
    private JButton b4 = new JButton("Add");
    private JButton b5 = new JButton("Edit");
    private JButton b6 = new JButton("Delete");
    private JButton b7 = new JButton("ViewAll");
    private JButton b8 = new JButton("ViewOne");
    private JButton b9 = new JButton("Add");
    private JButton b10 = new JButton("Edit");
    private JButton b11 = new JButton("Delete");
    private JButton b12 = new JButton("ViewAll");
    private JButton b13 = new JButton("ViewOne");
    private JTextField tId = new JTextField("", 20);
    private JTextField tIdClient = new JTextField("", 20);
    private JTextField tIdProduct = new JTextField("", 20);
    private JTextField tQuantity = new JTextField("", 20);
    private JButton bAdd = new JButton("Add");
    private JButton bEdit = new JButton("Edit");
    private JButton bDelete = new JButton("Delete");
    private JButton bAll = new JButton("View All");
    private JButton bOne = new JButton("View One");
    private JButton bAddp = new JButton("Add");
    private JButton bEditp = new JButton("Edit");
    private JButton bDeletep = new JButton("Delete");
    private JButton bAllp = new JButton("View All");
    private JButton bOnep = new JButton("View One");
    private JButton bOrder = new JButton("Place order");

    /**
     * interfata
     */
    public ControllerView(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("Choose a table:"));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(Box.createVerticalStrut(10));
        this.setContentPane(panel);
        this.pack();
        this.setSize(150,200);
        this.getContentPane().setBackground(new Color(138,184,187  ));
        this.setTitle("Orders Management");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame fClients = new JFrame();
                JPanel panel1 = new JPanel();
                panel1.add(new JLabel("Choose an operation: "));
                panel1.add(b4);
                panel1.add(b5);
                panel1.add(b6);
                panel1.add(b7);
                panel1.add(b8);
                panel1.add(Box.createVerticalStrut(10));
                fClients.setContentPane(panel1);
                fClients.pack();
                fClients.setSize(150,200);
                fClients.getContentPane().setBackground(new Color(138,184,187  ));
                fClients.setTitle("Orders Management");
                fClients.setLocationRelativeTo(null);
                fClients.setDefaultCloseOperation(fClients.DISPOSE_ON_CLOSE);
                fClients.setResizable(false);
                fClients.setVisible(true);

            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame fProducts = new JFrame();
                JPanel panel2 = new JPanel();
                panel2.add(new JLabel("Choose an operation: "));
                panel2.add(b9);
                panel2.add(b10);
                panel2.add(b11);
                panel2.add(b12);
                panel2.add(b13);
                panel2.add(Box.createVerticalStrut(10));
                fProducts.setContentPane(panel2);
                fProducts.pack();
                fProducts.setSize(150,200);
                fProducts.getContentPane().setBackground(new Color(138,184,187  ));
                fProducts.setTitle("Orders Management");
                fProducts.setLocationRelativeTo(null);
                fProducts.setDefaultCloseOperation(fProducts.DISPOSE_ON_CLOSE);
                fProducts.setResizable(false);
                fProducts.setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame fOrders = new JFrame();
                JPanel panel2 = new JPanel();
                panel2.add(new JLabel("     Select the details of the order:     "));
                panel2.add(new JLabel("   Id   "));
                panel2.add(tId);
                panel2.add(new JLabel("IdClient"));
                panel2.add(tIdClient);
                panel2.add(new JLabel("IdProduct"));
                panel2.add(tIdProduct);
                panel2.add(new JLabel("Quantity"));
                panel2.add(tQuantity);
                panel2.add(bOrder);

                fOrders.setContentPane(panel2);
                fOrders.pack();
                fOrders.setSize(250,300);
                fOrders.getContentPane().setBackground(new Color(138,184,187  ));
                fOrders.setTitle("Orders Management");
                fOrders.setLocationRelativeTo(null);
                fOrders.setDefaultCloseOperation(fOrders.DISPOSE_ON_CLOSE);
                fOrders.setResizable(false);
                fOrders.setVisible(true);

                bOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Orders order;
                        int id=Integer.parseInt(tId.getText());
                        int idClient=Integer.parseInt(tIdClient.getText());
                        int idProduct=Integer.parseInt(tIdProduct.getText());
                        int quantity=Integer.parseInt(tQuantity.getText());

                        Products product = new Products();
                        ProductsBLL productsBLL = new ProductsBLL();
                        product = productsBLL.findById(idProduct);

                        int dif=0;
                        int ok=1;
                        dif= product.getStock() - quantity;
                        product.setStock(dif);
                        if(dif <= 0)
                            ok=0;
                        else ok=1;

                            OrdersBLL ordersBLL = new OrdersBLL();
                            order = new Orders(id, idClient, idProduct, quantity);
                            //ordersBLL.insertOrder(order);
                            ordersBLL.placeOrder(idClient,idProduct,quantity);
                            orders = ordersBLL.findAll();
                            orders.add(order);

                            JFrame fadd = new JFrame();
                            JPanel padd = new JPanel();
                            if(ok==1) {
                                padd.setLayout(new GridLayout(orders.size() + 1, 5, 10, 10));
                                padd.add(new JLabel("   Id"));
                                padd.add(new JLabel("IdClient"));
                                padd.add(new JLabel("IdProduct"));
                                padd.add(new JLabel("Quantity"));

                                for (int i = 0; i < orders.size(); i++) {
                                    padd.add(new JLabel(Integer.toString(orders.get(i).getIdOrder())));
                                    padd.add(new JLabel(Integer.toString(orders.get(i).getIdClient())));
                                    padd.add(new JLabel(Integer.toString(orders.get(i).getIdProduct())));
                                    padd.add(new JLabel(Integer.toString(orders.get(i).getQuantity())));
                                }
                            }
                            else {
                                JTextField text = new JTextField("Not enough stock",30);
                                text.setEditable(false);
                                padd.add(text);
                            }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        b4.addActionListener(new ActionListener() { ///////////////////////CLIENTI
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tAddress = new JTextField("", 20);
                JTextField tEmail = new JTextField("", 20);
                JTextField tAge = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Address"));
                panel.add(tAddress);
                panel.add(new JLabel("Email"));
                panel.add(tEmail);
                panel.add(new JLabel("      Age      "));
                panel.add(tAge);
                panel.add(bAdd);
                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);

                bAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clients client;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        String address=tAddress.getText();
                        String email=tEmail.getText();
                        int age=Integer.parseInt(tAge.getText());

                        ClientsBLL clientsBLL = new ClientsBLL();
                        client = new Clients(id,name,address,email,age);
                        clientsBLL.insertClient(client);

                        clienti = clientsBLL.findAll();
                        //clienti.add(client);
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(clienti.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Address"));
                        padd.add(new JLabel("Email"));
                        padd.add(new JLabel("Age"));
                        for(int i=0;i<clienti.size();i++){
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getId())));
                            padd.add(new JLabel(clienti.get(i).getName()));
                            padd.add(new JLabel(clienti.get(i).getAddress()));
                            padd.add(new JLabel(clienti.get(i).getEmail()));
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getAge())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tAddress = new JTextField("", 20);
                JTextField tEmail = new JTextField("", 20);
                JTextField tAge = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Address"));
                panel.add(tAddress);
                panel.add(new JLabel("Email"));
                panel.add(tEmail);
                panel.add(new JLabel("      Age      "));
                panel.add(tAge);
                panel.add(bEdit);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);
                bEdit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clients client;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        String address=tAddress.getText();
                        String email=tEmail.getText();
                        int age=Integer.parseInt(tAge.getText());

                        ClientsBLL clientsBLL = new ClientsBLL();
                        client = new Clients(id,name,address,email,age);
                        clientsBLL.updateClient(client,id);
                        clienti = clientsBLL.findAll();
                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(clienti.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Address"));
                        padd.add(new JLabel("Email"));
                        padd.add(new JLabel("Age"));
                        for(int i=0;i<clienti.size();i++){
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getId())));
                            padd.add(new JLabel(clienti.get(i).getName()));
                            padd.add(new JLabel(clienti.get(i).getAddress()));
                            padd.add(new JLabel(clienti.get(i).getEmail()));
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getAge())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tAddress = new JTextField("", 20);
                JTextField tEmail = new JTextField("", 20);
                JTextField tAge = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Address"));
                panel.add(tAddress);
                panel.add(new JLabel("Email"));
                panel.add(tEmail);
                panel.add(new JLabel("      Age      "));
                panel.add(tAge);
                panel.add(bDelete);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);
                bDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clients client;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        String address=tAddress.getText();
                        String email=tEmail.getText();
                        int age=Integer.parseInt(tAge.getText());

                        ClientsBLL clientsBLL = new ClientsBLL();
                        client = new Clients(id,name,address,email,age);
                        clientsBLL.deleteClient(id);
                        clienti = clientsBLL.findAll();
                        clienti.remove(client);

                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(clienti.size()+1,5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Address"));
                        padd.add(new JLabel("Email"));
                        padd.add(new JLabel("Age"));
                        for(int i=0;i<clienti.size();i++){
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getId())));
                            padd.add(new JLabel(clienti.get(i).getName()));
                            padd.add(new JLabel(clienti.get(i).getAddress()));
                            padd.add(new JLabel(clienti.get(i).getEmail()));
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getAge())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JPanel panel = new JPanel();
                panel.add(bAll);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);
                bAll.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clients client;
                        ClientsBLL clientsBLL = new ClientsBLL();
                        clienti = clientsBLL.findAll();
                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(clienti.size()+1,5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Address"));
                        padd.add(new JLabel("Email"));
                        padd.add(new JLabel("Age"));
                        for(int i=0;i<clienti.size();i++){
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getId())));
                            padd.add(new JLabel(clienti.get(i).getName()));
                            padd.add(new JLabel(clienti.get(i).getAddress()));
                            padd.add(new JLabel(clienti.get(i).getEmail()));
                            padd.add(new JLabel(Integer.toString(clienti.get(i).getAge())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(bOne);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);
                bOne.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clients client;
                        int id=Integer.parseInt(tId.getText());
                        ClientsBLL clientsBLL = new ClientsBLL();
                        client = clientsBLL.findById(id);

                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(2,5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Address"));
                        padd.add(new JLabel("Email"));
                        padd.add(new JLabel("Age"));

                        padd.add(new JLabel(Integer.toString(client.getId())));
                        padd.add(new JLabel(client.getName()));
                        padd.add(new JLabel(client.getAddress()));
                        padd.add(new JLabel(client.getEmail()));
                        padd.add(new JLabel(Integer.toString(client.getAge())));

                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        b9.addActionListener(new ActionListener() { /////////////////////////////// PRODUCTS
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tStock = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Stock"));
                panel.add(tStock);
                panel.add(bAddp);
                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);

                bAddp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Products product;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        int stock=Integer.parseInt(tStock.getText());

                        ProductsBLL productsBLL = new ProductsBLL();
                        product = new Products(id,name,stock);
                        productsBLL.insertProduct(product);
                        products = productsBLL.findAll();

                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(products.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Stock"));

                        for(int i=0;i<products.size();i++){
                            padd.add(new JLabel(Integer.toString(products.get(i).getId())));
                            padd.add(new JLabel(products.get(i).getName()));
                            padd.add(new JLabel(Integer.toString(products.get(i).getStock())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tStock = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Stock"));
                panel.add(tStock);
                panel.add(bEditp);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);

                bEditp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Products product;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        int stock=Integer.parseInt(tStock.getText());

                        ProductsBLL productsBLL = new ProductsBLL();
                        product = new Products(id,name,stock);
                        productsBLL.updateProduct(product,id);
                        products = productsBLL.findAll();

                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(products.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Stock"));

                        for(int i=0;i<products.size();i++){
                            padd.add(new JLabel(Integer.toString(products.get(i).getId())));
                            padd.add(new JLabel(products.get(i).getName()));
                            padd.add(new JLabel(Integer.toString(products.get(i).getStock())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JTextField tName = new JTextField("", 20);
                JTextField tStock = new JTextField("", 20);

                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(new JLabel("Name"));
                panel.add(tName);
                panel.add(new JLabel("Stock"));
                panel.add(tStock);
                panel.add(bDeletep);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);

                bDeletep.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Products product;
                        int id=Integer.parseInt(tId.getText());
                        String name=tName.getText();
                        int stock=Integer.parseInt(tStock.getText());

                        ProductsBLL productsBLL = new ProductsBLL();
                        product = new Products(id,name,stock);
                        productsBLL.deleteProduct(id);
                        products = productsBLL.findAll();
                        products.remove(product);
                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(products.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Stock"));

                        for(int i=0;i<products.size();i++){
                            padd.add(new JLabel(Integer.toString(products.get(i).getId())));
                            padd.add(new JLabel(products.get(i).getName()));
                            padd.add(new JLabel(Integer.toString(products.get(i).getStock())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JPanel panel = new JPanel();
                panel.add(bAllp);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);
                bAllp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Products product;
                        ProductsBLL productsBLL = new ProductsBLL();
                        products = productsBLL.findAll();
                        i++;
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(products.size()+1, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Stock"));

                        for(int i=0;i<products.size();i++){
                            padd.add(new JLabel(Integer.toString(products.get(i).getId())));
                            padd.add(new JLabel(products.get(i).getName()));
                            padd.add(new JLabel(Integer.toString(products.get(i).getStock())));
                        }
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f4 = new JFrame();
                JTextField tId = new JTextField("", 20);
                JPanel panel = new JPanel();
                panel.add(new JLabel("      Id        "));
                panel.add(tId);
                panel.add(bOnep);

                f4.setContentPane(panel);
                f4.pack();
                f4.setSize(250, 300);
                f4.getContentPane().setBackground(new Color(138, 184, 187));
                f4.setTitle("Orders Management");
                f4.setLocationRelativeTo(null);
                f4.setDefaultCloseOperation(f4.DISPOSE_ON_CLOSE);
                f4.setResizable(false);
                f4.setVisible(true);

                bOnep.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Products product;
                        int id=Integer.parseInt(tId.getText());
                        ProductsBLL productsBLL = new ProductsBLL();
                        product = productsBLL.findById(id);
                        JFrame fadd = new JFrame();
                        JPanel padd = new JPanel();
                        padd.setLayout(new GridLayout(2, 5,10,10));
                        padd.add(new JLabel("   Id"));
                        padd.add(new JLabel("Name"));
                        padd.add(new JLabel("Stock"));

                            padd.add(new JLabel(Integer.toString(product.getId())));
                            padd.add(new JLabel(product.getName()));
                            padd.add(new JLabel(Integer.toString(product.getStock())));
                        fadd.setContentPane(padd);
                        fadd.pack();
                        fadd.getContentPane().setBackground(new Color(138, 184, 187));
                        fadd.setTitle("Orders Management");
                        fadd.setLocationRelativeTo(null);
                        fadd.setDefaultCloseOperation(fadd.DISPOSE_ON_CLOSE);
                        fadd.setVisible(true);

                    }
                });
            }
        });
    }
}