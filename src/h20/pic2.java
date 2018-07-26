package h20;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class pic2
{
  Font f = new Font("Default", 2, 24);
  final int HB = 60;
  final double FrameTime = 0.0166666667D;
  final double Speed = 300.0D;
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

  public pic2()
  {
    for (int i = 0; i < 100; i++) {
      this.flag[i] = 99;
    }
  }

  public void Req()
  {
    this.timer -= 0.0166666667D;
    if (this.timer < 0.0D)
    {
      this.timer = 0.05999999865889549D;
      for (int i = 0; i < 100; i++) {
        if (this.flag[i] == 99)
        {
          this.Nx[i] = 0.0D;
          this.Ny[i] = 6;
          this.Ny[i] += 6 * this.col_no;
          this.X[i] = 960.0D;
          this.Y[i] = 370.0D;
          this.X_sp[i] = 250.0D;
          this.Y_sp[i] = 250.0D;
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
        this.X[i] += 0.0166666667D * this.X_sp[i] * (float)Math.cos(this.Kaku[i] * 3.141592D / 180.0D);
        this.Y[i] += 0.0166666667D * this.Y_sp[i] * (float)Math.sin(this.Kaku[i] * 3.141592D / 180.0D);
        switch (this.flag[i])
        {
        case 0:
          if (this.X[i] < 520.0D)
          {
            this.X[i] = 520.0D;
            this.Kaku[i] = 120.0D;
            this.flag[i] = 1;
          }
          break;
        case 1:
          if (this.X[i] < 450.0D)
          {
            this.X[i] = 450.0D;
            this.Kaku[i] = 240.0D;
            this.flag[i] = 2;
          }
          break;
        case 2:
          if (this.X[i] < 380.0D)
          {
            this.X[i] = 380.0D;
            this.Kaku[i] = 180.0D;this.flag[i] = 3;
          }
          break;
        case 3:
          if (this.X[i] < 240.0D)
          {
            this.X[i] = 240.0D;
            this.Kaku[i] = 300.0D;
            this.flag[i] = 4;
          }
          break;
        case 4:
          if (this.X[i] > 310.0D)
          {
            this.X[i] = 310.0D;
            this.Kaku[i] = 240.0D;
            this.flag[i] = 5;
          }
          break;
        case 5:
          if (this.X[i] < 240.0D)
          {
            this.X[i] = 240.0D;
            this.Kaku[i] = 0.0D;
            this.flag[i] = 6;
          }
          break;
        case 6:
          if (this.X[i] > 380.0D)
          {
            this.X[i] = 380.0D;
            this.Kaku[i] = 300.0D;
            this.flag[i] = 7;
          }
          break;
        case 7:
          if (this.X[i] > 450.0D)
          {
            this.X[i] = 450.0D;
            this.Kaku[i] = 60.0D;
            this.flag[i] = 8;
          }
          break;
        case 8:
          if (this.X[i] > 520.0D)
          {
            this.X[i] = 520.0D;
            this.Kaku[i] = 0.0D;
            this.flag[i] = 9;
          }
          break;
        case 9:
          if (this.X[i] > 660.0D)
          {
            this.X[i] = 660.0D;
            this.Kaku[i] = 120.0D;
            this.flag[i] = 10;
          }
          break;
        case 10:
          if (this.X[i] < 590.0D)
          {
            this.X[i] = 590.0D;
            this.Kaku[i] = 60.0D;
            this.flag[i] = 11;
          }
          break;
        case 11:
          if (this.X[i] > 660.0D)
          {
            this.X[i] = 660.0D;
            this.Kaku[i] = 180.0D;
            this.flag[i] = 0;
          }
          break;
        }
        if ((1056.0D < this.X[i]) || (this.X[i] < -96.0D) ||
          (696.0D < this.Y[i]) || (this.Y[i] < -96.0D)) {
          this.flag[i] = 99;
        }
        this.Nx[i] += 0.166666667D;
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

