package h20;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class buta2 {
	final int MAX=1000;
	final int X_POS=400;
	final int Y_POS=30;
	final double X_SP=5.00;
	final double Y_SP=2.35;

	BufferedImage PNG;// 隱ｭ縺ｿ霎ｼ繧�繝輔ぅ繝ｼ繝ｫ繝牙ｮ｣險�<------------------竭�

	double[] y=new double[MAX];
	double[] x=new double[MAX];
	double[] x_sp=new double[MAX];
	double[] y_sp=new double[MAX];

	//-----------------------
	//	�ｽｺ�ｾ晢ｽｽ�ｾ�ｾ暦ｽｸ�ｾ�(09遶� 347�ｾ搾ｾ滂ｽｰ�ｽｼ�ｾ�)
	//-----------------------
	public buta2(){
		for(int i=0;i<MAX;i++){
			y[i]=Y_POS;
			x[i]=X_POS;
			int SP=new java.util.Random().nextInt(100)+2;
			int SP2=new java.util.Random().nextInt(100)+1;
			x_sp[i]=SP/10.0;
			y_sp[i]=SP2/10.0;
		}

	}

	//-----------------------
	//	蜍輔″
	//-----------------------
	public void Move(){
		for(int i=0;i<MAX;i++){
		x[i]=x[i]+x_sp[i];
		y[i]=y[i]+y_sp[i];

		int SP=new java.util.Random().nextInt(100)+2;

		if(x[i]>=960-50){x_sp[i]=-SP/10.0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(y[i]>=540-50){y_sp[i]=-SP/10.0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(x[i]<0){x_sp[i]=SP/10.0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(y[i]<0){y_sp[i]=SP/10.0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ

		}
	}




	//-----------------------
	//	繧ｰ繝ｩ繝輔ぅ繝�繧ｯ陦ｨ遉ｺ
	//-----------------------
	public void Draw(JFrame	Wind,Graphics2D 	g){
		for(int i=0;i<MAX;i++){

			g.drawImage(PNG,(int)x[i],(int)y[i],Wind);//<------------------竭｢

		}
	}

	//-----------------------
	//	繧ｰ繝ｩ繝輔ぅ繝�繧ｯ隱ｭ縺ｿ霎ｼ縺ｿ
	//-----------------------
	public void Load(){

		// 繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ<------------------竭｡
		try {
			PNG = ImageIO.read(getClass().getResource("buta.png"));// 繝輔ぃ繧､繝ｫ蜷�
		} catch (IOException e) {// 隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
			e.printStackTrace();
		}
	}





}//class end

