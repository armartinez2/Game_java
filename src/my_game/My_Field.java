
package my_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


class My_Field {
    
    public static void main(String[] args){
        
        final JTextField field = new JTextField(15);
        InputMap imap = field.getInputMap(JComponent.WHEN_FOCUSED);
        imap.put(KeyStroke.getKeyStroke("SPACE"), "spaceAction");
        ActionMap amap = field.getActionMap();
        amap.put("spaceAction", new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                System.out.println("space bar pressed");
            }
        });
        JOptionPane.showMessageDialog(null,field);
    }
    
}
