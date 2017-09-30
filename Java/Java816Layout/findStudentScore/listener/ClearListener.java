package WORK.Java.Java816Layout.findStudentScore.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/16.
 * User:Julis 落叶挽歌
 * Date:17/8/16
 * Time:下午9:02
 */
public class ClearListener implements ActionListener {
    JTextField[] tf;

    public ClearListener(JTextField[] tf) {
        this.tf = tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clear(tf);
    }
    public void clear(JTextField[] tf){
        for(int i=0;i<tf.length;i++) {
            tf[i].setText("");
        }
    }
}



