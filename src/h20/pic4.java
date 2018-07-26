package h20;



import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class pic4
{
  final float FrameTime = 0.016666668F;
  Font f = new Font("Default", 2, 24);
  final double Speed = 400.0D;
  final int Max = 100;
  BufferedImage PNG;
  double[] ani = new double[100];
  double[] X = new double[100];
  double[] Y = new double[100];
  double[] X_sp = new double[100];
  double[] Y_sp = new double[100];
  double[] Kaku = new double[100];
  double[] Nx = new double[100];
  int[] Ny = new int[100];
  double[] R = new double[100];
  int[] flag = new int[100];
  double timer;
  int counter;
  int col_no;
  char[] name = {
		  'T', 'N', 'W', '.', 'n', 'o', 't', 'a', 'v', 'e', 'r', 'y',

		    '.', 'g', 'o', 'o', 'd', 'p', 'l', 'a', 'c', 'e', 't', 'o', 's', 't',

		    'u', 'd', 'y', 'g', 'a', 'm', 'e', 'p', 'r', 'o', 'g', 'r', 'a', 'm',

		    'm', 'i', 'n', 'g', '.', 't', 'h', 'e', 't', 'e', 'a', 'c', 'h', 'e',

		    'r', 's', 's', 'u', 'c', 'k', 's', '.', '#', 'f', 'm', 'l', '#', 'b',

		    's' };

  public pic4()
  {
    for (int i = 0; i < 100; i++)
    {
      this.flag[i] = 99;
      this.col_no = 0;
    }
  }

  public void Req()
  {
    this.timer -= 0.01666666753590107D;
    if (this.timer < 0.0D)
    {
      this.timer = 0.10000000149011612D;
      for (int i = 0; i < 100; i++) {
        if (this.flag[i] == 99)
        {
          int N = this.name[i];
          if (N == 35)
          {
            this.col_no = 0; break;
          }
          if (N == 58) {
            this.col_no += 1;
          }
          this.Nx[i] = 0.0D;
          this.Ny[i] = 2;
          this.X[i] = 960.0D;
          this.Y[i] = 240.0D;
          this.X_sp[i] = -400.0D;
          this.Y_sp[i] = 400.0D;
          this.Kaku[i] = 180.0D;
          this.flag[i] = 0;
          break;
        }
      }
    }
  }

  public void Move()
  {
    Req();
    for (int i = 0; i < 100; i++) {
      if (this.flag[i] < 99)
      {
        this.X[i] += 0.01666666753590107D * this.X_sp[i];
        this.Y[i] += 0.01666666753590107D * this.Y_sp[i] * (float)Math.sin(this.Kaku[i] * 3.141592D / 180.0D);
        switch (this.flag[i])
        {
        case 0:
          if (this.X[i] < 0.0D)
          {
            this.X_sp[i] = 50.0D;
            this.Y_sp[i] = 150.0D;
            this.Kaku[i] = 280.0D;
            this.flag[i] = 1;
          }
          break;
        case 1:
          this.Kaku[i] += 4.0D;
          this.X_sp[i] += 0.4166666865348816D;
          this.Y_sp[i] += 1.8333333730697632D;
        }
        if ((1056.0D < this.X[i]) || (this.X[i] < -96.0D) ||
          (636.0D < this.Y[i]) || (this.Y[i] < -96.0D)) {
          this.flag[i] = 99;
        }
        this.Nx[i] += 0.5D;
        if (this.Nx[i] > 9.9D) {
          this.Nx[i] = 0.0D;
        }
      }
    }
  }

  public void Draw(JFrame Wind, Graphics2D g)
  {
    for (int i = 0; i < 100; i++) {
      if (this.flag[i] != 99) {
        g.drawImage(this.PNG,
          (int)this.X[i], (int)this.Y[i], (int)this.X[i] + 48, (int)this.Y[i] + 48,
          48 * (int)this.Nx[i], 48 * this.Ny[i], 48 * (int)this.Nx[i] + 48, 48 * this.Ny[i] + 48,
          Wind);
      }
    }
  }

  public void Load()
  {
    try
    {
      this.PNG = ImageIO.read(getClass().getResource("zako.png"));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

