package archetype;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.ProgressMonitor;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static net.mindview.util.SwingConsole.*;

/**
 * @author CKM-KING
 * @date 2017年12月6日:下午7:53:21
 * <p>describe:</p>
 * <p>context:</p>
 * @version 1.0.0
 */
public class Progress extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7589065400239541929L;
	
	//创建显示边界但没有进度字符串的水平进度条。初始值和最小值为0，最大值为100。
	private JProgressBar jPb = new JProgressBar();
	
	//一个监视某个操作进程的类。如果看起来操作需要一段时间，就会弹出一个进度对话框。
	//当progressmonitor创建它是一个特定的数值范围和描述性字符串。
	//随着操作的进行，调用设置任务的进度方法表示多远[ min，max ]范围操作。
	//最初，没有进度对话框。在第一millistodecidetopopup毫秒（默认500）
	//进度监视器将预测多久将采取的行动。如果是超过millistopopup（默认2000, 2秒）
	//一个进度对话框将弹出。从时间到时间，当对话框是可见的，进度条将被更新时，设置任务的进度被称为。
	private ProgressMonitor pm =new ProgressMonitor(
			this,"Monitor Progress","test",0,100
			);
	
	private JSlider js = new JSlider(JSlider.HORIZONTAL,0,100,60);
	
	public Progress(){
		setLayout(new GridLayout(2, 1));
		add(jPb);
		pm.setProgress(0);
		//弹出监视器最大时间,超过就不弹出
		pm.setMillisToPopup(1000);
		js.setValue(0);
		js.setPaintTicks(true);
		//显示刻度
		js.setMajorTickSpacing(20);
		js.setMinorTickSpacing(5);
		js.setBorder(new TitledBorder("Slider Me"));
		jPb.setModel(js.getModel());
		add(js);
		
		//设置监听器
		js.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				pm.setProgress(js.getValue());
			}
		});
		
	}
	
	public static void main(String[] args){
		run(new Progress(),300,200);
	}
	
}
