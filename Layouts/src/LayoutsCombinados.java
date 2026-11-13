package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutsCombinados extends JFrame {

    final static String BUTTONPANEL = "Tab with JButtons";
    final static String TEXTPANEL = "Tab with JTextField";
    final static int extraWindowWidth = 100;

    static final String gapList[] = {"0", "10", "15", "20"};
    final static int maxGap = 20;
    
    JComboBox horGapComboBox;
    JComboBox verGapComboBox;
    JButton applyButton = new JButton("Apply gaps");
    GridLayout experimentLayout = new GridLayout(0, 2);

    // 1. Panel con BoxLayout (Vertical)
    public JPanel crearPanelBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addAButton("Button 1", panel);
        addAButton("Button 2", panel);
        addAButton("Button 3", panel);
        addAButton("Long-Named Button 4", panel);
        addAButton("5", panel);
        
        return panel;
    }

    // 2. Panel con JTabbedPane (Pestañas)
    public JPanel crearPanelTabs() {
        JPanel panelContainer = new JPanel(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel card1 = new JPanel() {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        tabbedPane.addTab(BUTTONPANEL, card1);
        tabbedPane.addTab(TEXTPANEL, card2);

        panelContainer.add(tabbedPane, BorderLayout.CENTER);
        return panelContainer;
    }

    // 3. Panel con GridLayout y controles de Gaps
    public JPanel crearPanelGrid() {
        horGapComboBox = new JComboBox(gapList);
        verGapComboBox = new JComboBox(gapList);

        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 3));

        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension(
                (int) (buttonSize.getWidth() * 2.5) + maxGap,
                (int) (buttonSize.getHeight() * 3.5) + maxGap * 2));

        compsToExperiment.add(new JButton("Grid Btn 1"));
        compsToExperiment.add(new JButton("Grid Btn 2"));
        compsToExperiment.add(new JButton("Grid Btn 3"));
        compsToExperiment.add(new JButton("Long-Named Grid Btn 4"));
        compsToExperiment.add(new JButton("5"));

        controls.add(new JLabel("Horizontal gap:"));
        controls.add(new JLabel("Vertical gap:"));
        controls.add(new JLabel(" "));
        controls.add(horGapComboBox);
        controls.add(verGapComboBox);
        controls.add(applyButton);

        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String horGap = (String) horGapComboBox.getSelectedItem();
                String verGap = (String) verGapComboBox.getSelectedItem();
                experimentLayout.setHgap(Integer.parseInt(horGap));
                experimentLayout.setVgap(Integer.parseInt(verGap));
                experimentLayout.layoutContainer(compsToExperiment);
                compsToExperiment.revalidate();
            }
        });

        JPanel panelGridPrincipal = new JPanel(new BorderLayout());
        panelGridPrincipal.add(compsToExperiment, BorderLayout.NORTH);
        panelGridPrincipal.add(new JSeparator(), BorderLayout.CENTER);
        panelGridPrincipal.add(controls, BorderLayout.SOUTH);

        return panelGridPrincipal;
    }

    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public LayoutsCombinados() {
        setTitle("Mezcla de Layouts Combinados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // El contenedor principal usa BorderLayout para organizar los 3 sub-paneles
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        pane.add(crearPanelTabs(), BorderLayout.NORTH);
        pane.add(crearPanelBox(), BorderLayout.CENTER);
        pane.add(crearPanelGrid(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LayoutsCombinados().setVisible(true);
            }
        });
    }
}