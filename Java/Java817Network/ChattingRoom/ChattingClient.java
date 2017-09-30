package WORK.Java.Java817Network.ChattingRoom;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Julis on 17/8/17.
 * User:Julis 落叶挽歌
 * Date:17/8/17
 * Time:下午7:07
 */
public class ChattingClient {
    private static JTextArea textArea;
    private static JTextField textField;
    private static JButton sendMessage;
    private static  Socket client;
    public static void main(String []args){
        initData();//初始化数据
        initView();

    }
    public static void initView(){
        JFrame frame =new JFrame("聊天室");
        frame.setSize(500,350);
        JPanel jPanel=new JPanel(new FlowLayout());
        textArea=new JTextArea(15,40);
        textField=new JTextField(40);
        sendMessage=new JButton("发送");
        sendMessage.addActionListener(new MessageSendListener(textField,client));
        jPanel.add(textArea);
        jPanel.add(textField);
        jPanel.add(sendMessage);
        frame.add(jPanel);
        frame.setVisible(true);
    }

    public static void initData(){
        try {
           client = new Socket("192.168.3.27", 8888);
            new ReadThread(client).start();
            //new WriteThread(client).start();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void showMessage(String text){
        textArea.append(text+"\n");
    }

    public static String getText() {
        return textField.getText();
    }
    public static void setText() {
        textField.setText("");
    }
}


