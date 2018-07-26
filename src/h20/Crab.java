package h20;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class Crab {
	final double FRAMTIME=(1.0/60.0);//16.666666[ms]
	final int MAX=10;
	final int X_POS=400;
	final int Y_POS=30;
	final double X_SP=5.00;
	final double Y_SP=2.35;

	BufferedImage PNG;// 読み込むフィールド宣言<------------------①

	double[] No=new double[MAX]; //アニメーションのコマ
	int[] Ny=new int[MAX]; //画像の種類
	double[] y=new double[MAX]; //座標 Y
	double[] x=new double[MAX]; //座標 X
	double[] x_sp=new double[MAX]; //初速度 X
	double[] y_sp=new double[MAX]; //初速度 Y
	int[] flag=new int[MAX]; //画像の状態の種類！
                             // 0の場合 = 動いていない！
                            // 1の場合 = 動いている！
        // 2の場合 = 当たっている！
        // 3の場合 = 死んでいる
        // 4...
        // 5...true/falseで決めきれない場合もあるので、何個も使う。

        double timer; //敵の出現インターバルを設定する変数！

	//-----------------------
	//	ｺﾝｽﾄﾗｸﾀ(09章 347ﾍﾟｰｼﾞ)
	//-----------------------
	public Crab(){
		for(int i=0;i<MAX;i++){
			flag[i]=0;

		}

	}

	//-----------------------
	//	出撃メソッド
	//-----------------------
	public void Req(){

		timer -= FRAMTIME; //まずは引き算！
		if(timer > 0) return;

		timer = 0.1; //インターバルタイマーをここで再セット！


		for(int i=0;i<MAX;i++){
		if(flag[i]==0){ //空いてる？(0になってますか？)と聞いている。

		Ny[i]=3; //ここの数字を変えれば画像(キャラ)が変わります。0～6までの7種類！
		y[i]=0; //敵が出てくるY座標！
		x[i]=-48; //敵が出てくるX座標！
		x_sp[i]=300; //+,-で左右に敵を出す！
		y_sp[i]=0; //+,-で上下に敵を出す！
		flag[i]=1;
		break;
		   } //flagのEND
		} //forのEND
	}


	//-----------------------
	//	動き
	//-----------------------
	public void Move(){

		Req();

		for(int i=0;i<MAX;i++){
			if(flag[i]!=0){

		x[i]=x[i]+FRAMTIME * x_sp[i];
		y[i]=y[i]+FRAMTIME * y_sp[i];


		//軌道の切り替えのプログラム！-----------------

		//右端のチェック！(右端まで来たらどうすんの？)
		if(x[i]>960-48){

			//軌道を下に切り替える！
			x_sp[i]=0;
			y_sp[i]=300;
			 
			

		//下のチェック！(下まで来たらどうすんの？)
		if(y[i]>540-48){

			//軌道を左に切り替える！
			x_sp[i]=-300;
			y_sp[i]=0;

		//左端のチェック！(左端に来たらどうすんの？)
		if(x[i]<0 && x_sp[i]<-1){ //この時は[&&]を使って、条件をもう一つ追加する！

			//軌道を上に切り替える！
			x_sp[i]=0;
			y_sp[i]=-300;

			}

		}

	}



		//画面外処理のプログラム！---------------------

		if(x[i]>960){flag[i]=0;}//横座標のチェック
		if(y[i]>540){flag[i]=0;}//縦座標のチェック
		if(x[i]<-48){flag[i]=0;}//横座標のチェック
		if(y[i]<-48){flag[i]=0;}//縦座標のチェック

		//ｱﾆﾒ計算----------------
		No[i]=No[i]+FRAMTIME*10;
		if(No[i]>=10)No[i]=0;

                   } //flagのEND

		} //forのEND
}




	//-----------------------
	//	グラフィック表示
	//-----------------------
	public void Draw(JFrame	Wind,Graphics2D 	g){
		for(int i=0;i<MAX;i++){
                    if(flag[i]!=0){

			g.drawImage(PNG,
					(int)x[i],(int)y[i],(int)x[i]+48,(int)y[i]+48,
					48*(int)No[i],48*Ny[i],48*(int)No[i]+48,48*Ny[i]+48,
					Wind);//<------------------③

                            } //flagのEND
		} //forのEND
	}

	//-----------------------
	//	グラフィック読み込み
	//-----------------------
	public void Load(){

		// ファイルの読み込み<------------------②
		try {
			PNG = ImageIO.read(getClass().getResource("zako.png"));// ファイル名
		} catch (IOException e) {// 読み込みエラーの場合
			e.printStackTrace();
		}
	}





}//class end