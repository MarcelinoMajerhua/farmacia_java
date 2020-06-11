package control;

import javax.swing.JPanel;

public class CambiaPanel {
    //
    private JPanel padre;
    private JPanel hijo;


    /**
     * Constructor de clase
     */
    public CambiaPanel(JPanel padre, JPanel hijo) {
        this.padre = padre;
        this.hijo = hijo;
        this.padre.removeAll();
        this.padre.revalidate();
        this.padre.repaint();
        this.padre.add(this.hijo);
        this.padre.revalidate();
        this.padre.repaint();

    }

}//--> fin clase
