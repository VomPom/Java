package WORK.Java.Java720SetAndGet;

import javafx.stage.Screen;

import java.security.Key;
import java.util.Date;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午1:12
 */
public class Computer {
    private Key key;
    private Mouse mouse;
    private Screen screen;
    private Date date;

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void getMesssage(){

    }

}
