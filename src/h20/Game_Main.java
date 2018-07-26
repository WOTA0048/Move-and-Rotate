package h20;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;



public class Game_Main {
	final float FrameTime=1.0f/60.0f;//0.031f;
	final int X_Size=960;//�ｽｹ�ｾ橸ｽｰ�ｾ托ｽｳ�ｽｨ�ｾ晢ｾ�ｾ槭�ｮ讓ｪ�ｽｻ�ｽｲ�ｽｽ�ｾ�
	final int Y_Size=540;//�ｽｹ�ｾ橸ｽｰ�ｾ托ｽｳ�ｽｨ�ｾ晢ｾ�ｾ槭�ｮ邵ｦ�ｽｻ�ｽｲ�ｽｽ�ｾ�
	JFrame	Wind=new JFrame("JavaGame�ｾ鯉ｾ滂ｾ幢ｽｸ�ｾ橸ｾ暦ｾ大渕遉�");//JFrame 縺ｮ蛻晄悄蛹�(�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ陦ｨ遉ｺ�ｾ��ｽｲ�ｾ�ｾ�
	BufferStrategy	offimage;//�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ縺ｧ縺｡繧峨▽縺埼亟豁｢
	Insets sz;//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�

	Font	f=new	Font("Default",Font.BOLD,24);//菴ｿ逕ｨ縺吶ｋ繝輔か繝ｳ繝医け繝ｩ繧ｹ螳｣險�

		Crab c=new Crab();
		buta b=new buta();
		pic p=new pic();
		pic2 p2=new pic2();
		pic3 p3=new pic3();
		pic4 p4=new pic4();
    Game_Main(){


		Wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//髢峨§�ｾ趣ｾ橸ｾ��ｾ晁ｨｱ蜿ｯ
		Wind.setBackground(new Color(0,0,0));//濶ｲ謖�螳�
		Wind.setResizable(false);//�ｽｻ�ｽｲ�ｽｽ�ｾ槫､画峩荳榊庄
		Wind.setVisible(true);//陦ｨ遉ｺor髱櫁｡ｨ遉ｺ

		sz=Wind.getInsets();//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�
		Wind.setSize(X_Size+sz.left+sz.right, Y_Size+sz.top+sz.bottom);//�ｽｳ�ｽｨ�ｾ晢ｾ�ｾ橸ｽｳ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�
		Wind.setLocationRelativeTo(null);//荳ｭ螟ｮ縺ｫ陦ｨ遉ｺ

		//縺｡繧峨▽縺埼亟豁｢縺ｮ險ｭ螳�(�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ�ｾ假ｾ晢ｽｸ�ｾ�)-------------------------------------
		Wind.setIgnoreRepaint(true);//JFrame縺ｮ讓呎ｺ匁嶌縺肴鋤縺亥�ｦ逅�辟｡蜉ｹ
		Wind.createBufferStrategy(2);//2縺ｧ�ｾ��ｾ橸ｾ鯉ｾ橸ｾ�
		offimage=Wind.getBufferStrategy();
		c.Load();
		b.Load();
		p.Load();
		p2.Load();
		p3.Load();
		p4.Load();
		//�ｾ��ｽｲ�ｾ擾ｽｰ�ｾ��ｽｽ�ｽｸ襍ｷ蜍�----------------------------
		Timer	TM=new	Timer();//�ｾ��ｽｲ�ｾ擾ｽｰ�ｽｸ�ｾ暦ｽｽ縺ｮ螳滉ｽ灘喧
		TM.schedule(new timer_TSK(), 17, 17);//17ms蠕後°繧� 17ms縺翫″縺ｫ
						//縺ｩ縺難ｼ溘��縲�縲�17[ms]=繝励Ο繧ｰ繝ｩ繝�縺悟虚縺榊�ｺ縺呎怙蛻昴�ｮ譎る俣
						//            17[ms]縺昴�ｮ蠕後�ｯ17[ms]郢ｰ繧願ｿ斐＠

	}//Main_Game end
	class	timer_TSK extends	TimerTask{

		public void run() {
			c.Move();
			b.Move();
			p.Move();
			p2.Move();
			p3.Move();
			p4.Move();
			Graphics	g2=offimage.getDrawGraphics();//�ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸ蛻晄悄蛹�
			Graphics2D 	g = (Graphics2D) g2;


			if(offimage.contentsLost()==false)
			{//蛻ｩ蜿ｯ閭ｽ??
				g.translate(sz.left, sz.top);//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ櫁｣懈ｭ｣
				g.clearRect(0, 0, X_Size, Y_Size);//逕ｻ髱｢�ｽｸ�ｾ假ｽｱ(蟾ｦ荳街縲∝ｷｦ荳該縲∝承荳休縲∝承荳及)
				g.setColor(Color.black);//濶ｲ謖�螳�
				g.fillRect(0, 0, X_Size, Y_Size);//蝪励ｊ縺､縺ｶ縺�

			//--------------------------------------------------
				//邨ｵ繧�譁�蟄励ｒ陦ｨ遉ｺ
				//c.Draw(Wind, g);
				//b.Draw(Wind, g);
				p.Draw(Wind, g);
				p2.Draw(Wind, g);
				p3.Draw(Wind, g);
				p4.Draw(Wind, g);
				//譁�蟄励�ｮ陦ｨ遉ｺ
				g.setColor(Color.WHITE);//濶ｲ謖�螳�
				g.setFont(f);
				g.drawString("Hendarto Kennely",0, Y_Size-20);

			//---------------------------------------------------
				offimage.show();//�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ縺ｮ蛻�繧頑崛縺�
				g.dispose();//�ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸ�ｽｲ�ｾ晢ｽｽ�ｾ��ｾ晢ｽｽ縺ｮ遐ｴ譽�

			}//if end �ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸOK??



		}//run end
	}//timer task class end

	public static void main(String[] args) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

		Game_Main GM=new Game_Main();


	}

}
