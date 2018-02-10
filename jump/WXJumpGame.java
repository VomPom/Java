package jump;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
public class WXJumpGame extends JFrame{
	private static final long serialVersionUID = 1L;
	private PhoneImagePanel phoneImgPanel = null;
	private boolean isFirst = true;
	private Point prePoint = new Point();
	private Point curPoint = new Point();

	public WXJumpGame(){
		phoneImgPanel = new PhoneImagePanel();
		this.add(phoneImgPanel);
		this.setSize(540, 960);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		phoneImgPanel.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent event) {
				if(isFirst){
					prePoint.x = event.getX();
					prePoint.y = event.getY();
					isFirst = false;
					return;
				}
				System.out.println("之前的位置："+prePoint.x+","+prePoint.y);
				System.out.println("点击了："+event.getX()+","+event.getY());
				curPoint.x = event.getX();
				curPoint.y = event.getY();
				int distance = Utils.calDistance(prePoint, curPoint);
				int time = (int)(distance/0.37);
				Utils.jump(time);
				System.out.println("distance:"+distance+",time:"+time);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isFirst = true;
				phoneImgPanel.validate();
				phoneImgPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent event) { }
			@Override
			public void mouseExited(MouseEvent event) { }
			@Override
			public void mouseEntered(MouseEvent event) { }
			@Override
			public void mouseClicked(MouseEvent event) { }
		});
	}

	public static void main(String[] args){
		new WXJumpGame();
	}

}

