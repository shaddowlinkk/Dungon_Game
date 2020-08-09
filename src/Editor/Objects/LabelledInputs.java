package Editor.Objects;

import javax.swing.*;
import java.awt.*;

public class LabelledInputs extends JPanel {
    private JTextField input = new JTextField();
    private JLabel lable = new JLabel();
    public LabelledInputs(String lable){
        setVisible(true);
        setLayout(null);
        setSize(150,20);
        this.lable.setText(lable);
        this.lable.setSize((this.getWidth()/3),this.getHeight());
        this.lable.setLocation(0,0);
        input.setSize(((this.getWidth()/3)*2),this.getHeight());
        input.setLocation((this.getWidth()/3),0);
        add(this.lable);
        add(input);
    }
    public String getInput(){
        return input.getText();
    }

    public void setInput(String text){
        input.setText(text);
    }
}
