package h20;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class buta {
	final double FRAMTIME=(1.0/60.0);//16.666666[ms]
	final int MAX=10;
	final int X_POS=400;
	final int Y_POS=30;
	final double SPEED=200;

	BufferedImage PNG;// 隱ｭ縺ｿ霎ｼ繧�繝輔ぅ繝ｼ繝ｫ繝牙ｮ｣險�<------------------竭�

	double[] No=new double[MAX]; //繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ縺ｮ繧ｳ繝�
	int[] Ny=new int[MAX]; //逕ｻ蜒上�ｮ遞ｮ鬘�
	double[] y=new double[MAX]; //蠎ｧ讓� Y
	double[] x=new double[MAX]; //蠎ｧ讓� X
	double[] x_sp=new double[MAX]; //蛻晞�溷ｺｦ X
	double[] y_sp=new double[MAX]; //蛻晞�溷ｺｦ Y
	double[] Kaku=new double[MAX];//kakudo




	int[] flag=new int[MAX]; //逕ｻ蜒上�ｮ迥ｶ諷九�ｮ遞ｮ鬘橸ｼ�
                             // 0縺ｮ蝣ｴ蜷� = 蜍輔＞縺ｦ縺�縺ｪ縺�ｼ�
                            // 1縺ｮ蝣ｴ蜷� = 蜍輔＞縺ｦ縺�繧具ｼ�
        // 2縺ｮ蝣ｴ蜷� = 蠖薙◆縺｣縺ｦ縺�繧具ｼ�
        // 3縺ｮ蝣ｴ蜷� = 豁ｻ繧薙〒縺�繧�
        // 4...
        // 5...true/false縺ｧ豎ｺ繧√″繧後↑縺�蝣ｴ蜷医ｂ縺ゅｋ縺ｮ縺ｧ縲∽ｽ募�九ｂ菴ｿ縺�縲�

        double timer; //謨ｵ縺ｮ蜃ｺ迴ｾ繧､繝ｳ繧ｿ繝ｼ繝舌Ν繧定ｨｭ螳壹☆繧句､画焚�ｼ�

	//-----------------------
	//	�ｽｺ�ｾ晢ｽｽ�ｾ�ｾ暦ｽｸ�ｾ�(09遶� 347�ｾ搾ｾ滂ｽｰ�ｽｼ�ｾ�)
	//-----------------------
	public buta(){
		for(int i=0;i<MAX;i++){
			flag[i]=0;

		}

	}

	//-----------------------
	//	蜃ｺ謦�繝｡繧ｽ繝�繝�
	//-----------------------
	public void Req(){

		timer -= FRAMTIME; //縺ｾ縺壹�ｯ蠑輔″邂暦ｼ�
		if(timer > 0) return;

		timer = 0.2; //繧､繝ｳ繧ｿ繝ｼ繝舌Ν繧ｿ繧､繝槭�ｼ繧偵％縺薙〒蜀阪そ繝�繝茨ｼ�


		for(int i=0;i<MAX;i++){
		if(flag[i]==0){ //遨ｺ縺�縺ｦ繧具ｼ�(0縺ｫ縺ｪ縺｣縺ｦ縺ｾ縺吶°�ｼ�)縺ｨ閨槭＞縺ｦ縺�繧九��

		Ny[i]=3; //縺薙％縺ｮ謨ｰ蟄励ｒ螟峨∴繧後�ｰ逕ｻ蜒�(繧ｭ繝｣繝ｩ)縺悟､峨ｏ繧翫∪縺吶��0�ｽ�6縺ｾ縺ｧ縺ｮ7遞ｮ鬘橸ｼ�
		y[i]=540/2-48/2; //謨ｵ縺悟�ｺ縺ｦ縺上ｋY蠎ｧ讓呻ｼ�
		x[i]=960/2-48/2; //謨ｵ縺悟�ｺ縺ｦ縺上ｋX蠎ｧ讓呻ｼ�
		x_sp[i]=SPEED; //+,-縺ｧ蟾ｦ蜿ｳ縺ｫ謨ｵ繧貞�ｺ縺呻ｼ�
		y_sp[i]=SPEED; //+,-縺ｧ荳贋ｸ九↓謨ｵ繧貞�ｺ縺呻ｼ�
		Kaku[i]=0;//houkou
		flag[i]=2;
		break;
		   } //flag縺ｮEND
		} //for縺ｮEND
	}


	//-----------------------
	//	蜍輔″
	//-----------------------
	public void Move(){

		Req();

		for(int i=0;i<MAX;i++){
			if(flag[i]!=0){

		x[i]=x[i]+FRAMTIME * x_sp[i]*Math.cos(Kaku[i]*1/180.0*Math.PI);
		y[i]=y[i]+FRAMTIME * y_sp[i]*Math.sin(Kaku[i]*1/180.0*Math.PI);
		switch(flag[i])
		{
		case 1://Rotates below and disappear
			Kaku[i]+=2.0;
			if(Kaku[i]>=360) {flag[i]=2;}
			
			break;
		
		case 2://Rotates Above and go below 
			Kaku[i]-=2.0;
			if(Kaku[i]<=0) {flag[i]=1;}
			
			break;
		}
		//if(flag[i]==1) {if(Kaku[i]<360){ Kaku[i]+=2.0;flag[i]=2;}}
		


		//逕ｻ髱｢螟門�ｦ逅�縺ｮ繝励Ο繧ｰ繝ｩ繝��ｼ�---------------------

		if(x[i]>960){flag[i]=0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(y[i]>540){flag[i]=0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(x[i]<-48){flag[i]=0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ
		if(y[i]<-48){flag[i]=0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ

		//�ｽｱ�ｾ��ｾ定ｨ育ｮ�----------------
		No[i]=No[i]+FRAMTIME*10;
		if(No[i]>=10)No[i]=0;

                   } //flag縺ｮEND

		} //for縺ｮEND
}




	//-----------------------
	//	繧ｰ繝ｩ繝輔ぅ繝�繧ｯ陦ｨ遉ｺ
	//-----------------------
	public void Draw(JFrame	Wind,Graphics2D 	g){
		for(int i=0;i<MAX;i++){
                    if(flag[i]!=0){

			g.drawImage(PNG,
					(int)x[i],(int)y[i],(int)x[i]+48,(int)y[i]+48,
					48*(int)No[i],48*Ny[i],48*(int)No[i]+48,48*Ny[i]+48,
					Wind);//<------------------竭｢

                            } //flag縺ｮEND
		} //for縺ｮEND
	}

	//-----------------------
	//	繧ｰ繝ｩ繝輔ぅ繝�繧ｯ隱ｭ縺ｿ霎ｼ縺ｿ
	//-----------------------
	public void Load(){

		// 繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ<------------------竭｡
		try {
			PNG = ImageIO.read(getClass().getResource("zako.png"));// 繝輔ぃ繧､繝ｫ蜷�
		} catch (IOException e) {// 隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
			e.printStackTrace();
		}
	}





}//class end