package h20;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class pic
{
  Font f = new Font("Default", 2, 24);
  final double FrameTime = 0.0166666667D;
  final double Speed = 1000D;
  final int Max = 26;
  BufferedImage PNG;
  double[] ani = new double[26];
  double[] X = new double[26];
  double[] Y = new double[26];
  double[] X_sp = new double[26];
  double[] Y_sp = new double[26];
  double[] Kaku = new double[26];
  double[] Nx = new double[26];
  int[] Ny = new int[26];
  double[] R = new double[26];
  int[] flag = new int[26];
  double timer;
  int counter;
  int col_no;
  char[] name = {
    'y', 'o', 'u', 'd', 'o', 'n', 't', 'k', 'n', 'o', 'w', 'h', 'o', 't',
    'o', 't', 'e', 'a', 'c', 'h', 'd', 'o', 'n', 't', 'y', 'o',
    'u' };

  public pic()
  {
    for (int i = 0; i < 26; i++)
    {
      this.flag[i] = 99;
      this.col_no = 3;
    }
  }

  public void Req()
  {
    this.timer -= 0.0166666667D;
    if (this.timer < 0.0D)
    {
      this.timer = 0.03200000151991844D;
      for (int i = 0; i < 26; i++) {
        if (this.flag[i] == 99)
        {
          int N = this.name[i];
          if (N == 35)
          {
            this.col_no = 0; break;
          }
          this.Nx[i] = 0.0D;
          this.Ny[i] = 3;

          this.X[i] = 400D;
          this.Y[i] = -50D;
          this.X_sp[i] = 600.0D;
          this.Y_sp[i] = 600.0D;
          this.Kaku[i] = 90.0D;
          this.flag[i] = 0;
          break;
        }
      }
    }
  }

  public void Req2()
  {
    float[] k1 = { 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F, 90.0F,
      270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F, 270.0F };
    float[] k2 = { 13.0F, 12.0F, 11.0F, 10.0F, 9.0F, 8.0F, 7.0F, 6.0F, 5.0F, 4.0F, 3.0F, 2.0F, 1.0F, 0.0F,
      1.0F, 2.0F, 3.0F, 4.0F, 5.0F, 6.0F, 7.0F, 8.0F, 9.0F, 10.0F, 11.0F, 12.0F, 13.0F };
    for (int i = 0; i < 26; i++)
    {
      this.R[i] = (20F * k2[i]);
      this.X_sp[i] = 500.0D;
      this.Y_sp[i] = 500.0D;
      this.Kaku[i] = k1[i];
      this.flag[i] = 1;
    }
  }

  public void Move()
  {
    Req();
    for (int i = 0; i < 26; i++)
    {
      if (this.flag[i] < 99)
      {
        switch (this.flag[i])
        {
        case 0:
          this.X[i] += 0.0166666667D * this.X_sp[i] * (float)Math.cos(this.Kaku[i] * 3.141592D / 180.0D);
          this.Y[i] += 0.0166666667D * this.Y_sp[i] * (float)Math.sin(this.Kaku[i] * 3.141592D / 180.0D);
          if (this.Y[11] > 276.0D) {
            Req2();
          }
          break;
        case 1:
          this.Kaku[i] += 1.66666667D;

          this.X[i] = (this.R[i] * (float)Math.cos(this.Kaku[i] * 3.141592D / 180.0D) + 400.0D - 10.0D);
          this.Y[i] = (this.R[i] * (float)Math.sin(this.Kaku[i] * 3.141592D / 180.0D) + 270.0D - 10.0D);
        }
        if ((1056.0D < this.X[i]) || (this.X[i] < -96.0D) ||
          (636.0D < this.Y[i]) || (this.Y[i] < -96.0D)) {
          this.flag[i] = 99;
        }
      }
      this.Nx[i] += 0.500000001D;
      if (this.Nx[i] > 9.9D) {
        this.Nx[i] = 0.0D;
      }
    }
  }

  public void Draw(JFrame Wind, Graphics2D g)
  {
    for (int i = 0; i < 26; i++) {
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
