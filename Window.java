import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Window extends JFrame 
{
    DefaultTableModel model = new DefaultTableModel();
    final private Font mainFont = new Font("Monospaced", Font.BOLD + Font.ITALIC , 18);   
    JTextField tfName, tfLastName, tfAge; 
    
    public void init()
    {
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        JTable mod = new JTable(model);
        // JScrollPane scroll =new JScrollPane(model);

        JLabel name = new JLabel("Nombre");
        name.setFont(mainFont);

        tfName = new JTextField();
        tfName.setFont(mainFont);

        JLabel lastName = new JLabel("Apellido");
        lastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JLabel age = new JLabel("Edad");
        age.setFont(mainFont);

        tfAge = new JTextField();
        tfAge.setFont(mainFont);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(6, 1, 5, 5));
        textPanel.add(name);
        textPanel.add(tfName);
        textPanel.add(lastName);
        textPanel.add(tfLastName);
        textPanel.add(age);
        textPanel.add(tfAge);

        JButton agregar = new JButton("Añadir");
        agregar.setFont(mainFont);
        agregar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object[] data = new Object[3];
                data[0] = tfName.getText();
                data[1] = tfLastName.getText();
                data[2] = tfAge.getText();
                
                model.addRow(data);
            }
            
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 2, 5, 5));
        buttonPanel.add(agregar);

        JTableHeader header = mod.getTableHeader();
        JPanel container = new JPanel(new BorderLayout());
        container.add(header, BorderLayout.NORTH);
        container.add(mod, BorderLayout.CENTER);
        

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(container, BorderLayout.CENTER);

        add(mainPanel);
        
        setTitle("Welcome"); // Colocamos el título de la ventana.
        setSize(1300, 1000); // Definimos las dimensiones.
        setMinimumSize(new Dimension(300, 400)); // Definimos las dimensiones mínimas.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Indicamos qué se hace con la cruz roja.
        setVisible(true); // Definimos el Frame visible.
    }

    

}
