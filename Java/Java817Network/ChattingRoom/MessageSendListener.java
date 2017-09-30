package WORK.Java.Java817Network.ChattingRoom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Julis on 17/8/17.
 * User:Julis 落叶挽歌
 * Date:17/8/17
 * Time:下午7:32
 */
public class MessageSendListener implements ActionListener {
    private  JTextField textField;
    private Socket client;
    public MessageSendListener(JTextField textField,Socket client) {
        this.textField = textField;
        this.client=client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showMessage();//本地设置聊天内容
        try {
            OutputStream os=client.getOutputStream();
            String text=ChattingClient.getText();
            PrintWriter pw = new PrintWriter(os);
            if(!text.equals("")) {
                pw.println(text);//写出内容
                pw.flush();
            }
            ChattingClient.setText();

        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
    public void showMessage(){
        ChattingClient.showMessage("我说:"+textField.getText());
    }

}











