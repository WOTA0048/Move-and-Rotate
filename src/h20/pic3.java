package h20;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class pic3
{
  final float FrameTime = 0.016666668F;
  final float Speed = 400.0F;
  final int Max = 23;
  BufferedImage PNG;
  Font f = new Font("Default", 2, 24);
  float[] No1 = new float[23];
  float[] Mx = new float[23];
  float[] My = new float[23];
  float[] spx = new float[23];
  float[] spy = new float[23];
  float[] spxg = new float[23];
  float[] spyg = new float[23];
  float[] kaku = new float[23];
  int[] flag = new int[23];
  float timer;
  float W_timer;
  int[] Ny = new int[23];
  float[] spx_w = new float[23];
  float[] spy_w = new float[23];
  float N2_No = 0.0F;

  public pic3()
  {
    for (int i = 0; i < 23; i++) {
      this.flag[i] = 0;
    }
  }

  public void Req()
  {
    this.timer -= 0.016666668F;
    if (this.timer > 0.0F) {
      return;
    }
    this.timer = 0.07F;
    for (int i = 0; i < 23; i++) {
      if (this.flag[i] == 0)
      {
        this.flag[i] = 1;
        this.Mx[i] = 350.0F;
        this.My[i] = -50.0F;
        this.spx[i] = 400.0F;
        this.spy[i] = 400.0F;
        this.spxg[i] = 0.0F;
        this.spyg[i] = 0.0F;
        this.kaku[i] = 90.0F;
        this.Ny[i] = 1;
        break;
      }
    }
  }

  public void Move()
  {
    Req();
    for (int i = 0; i < 23; i++) {
      if (this.flag[i] != 0)
      {
        this.Mx[i] += 0.016666668F * this.spx[i] * (float)Math.cos(this.kaku[i] * 3.14D / 180.0D);
        this.My[i] += 0.016666668F * this.spy[i] * (float)Math.sin(this.kaku[i] * 3.14D / 180.0D);
        switch (this.flag[i])
        {
        case 1:
          if (this.My[i] > 100.0F) {
            this.flag[i] = 2;
          }
          break;
        case 2:
          this.kaku[i] -= 3.0F;
          if (this.kaku[0] < -630.0F) {
            Enemy_k2();
          }
          break;
        case 3:
          this.W_timer -= 0.016666668F;
          if (this.W_timer < 0.0F) {
            Enemy_k3();
          }
          break;
        case 4:
          this.kaku[i] -= 3.0F;
          this.My[i] += 2.0F;
          int cc = Enemy_ck();
          if (cc == 23) {
            Enemy_clr();
          }
          break;
        }
        this.No1[i] += 0.33333334F;
        if (this.No1[i] > 9.9D) {
          this.No1[i] = 0.0F;
        }
      }
    }
  }

  void Enemy_clr()
  {
    for (int i = 0; i < 23; i++) {
      this.flag[i] = 0;
    }
  }

  int Enemy_ck()
  {
    int c = 0;
    for (int i = 0; i < 23; i++) {
      if ((this.Mx[i] > 690.0F) || (this.Mx[i] < -48.0F) || (this.My[i] > 528.0F) || (this.My[i] < -48.0F)) {
        c++;
      }
    }
    return c;
  }

  public void Enemy_k3()
  {
    for (int i = 0; i < 23; i++) {
      if (this.flag[i] != 0)
      {
        this.spx[i] = this.spx_w[i];
        this.spy[i] = this.spy_w[i];
        this.flag[i] = 4;
      }
    }
  }

  public void Enemy_k2()
  {
    for (int i = 0; i < 23; i++) {
      if (this.flag[i] != 0)
      {
        this.spx_w[i] = this.spx[i];
        this.spy_w[i] = this.spy[i];

        this.spx[i] = 0.0F;
        this.spy[i] = 0.0F;
        this.spxg[i] = 0.0F;
        this.spyg[i] = 0.0F;
        this.flag[i] = 3;
      }
    }
    this.W_timer = 46.0F;
  }

  public void stop_set(int i)
  {
    this.spx[i] = 0.0F;
    this.spy[i] = 0.0F;
    this.spxg[i] = 0.0F;
    this.spyg[i] = 0.0F;
  }

  int Enemy_ck2()
  {
    int c = 0;
    for (int i = 0; i < 23; i++) {
      if ((this.spx[i] == 0.0F) && (this.flag[i] != 0)) {
        c++;
      }
    }
    return c;
  }

  public void Draw(JFrame Wind, Graphics2D g)
  {
    for (int i = 0; i < 23; i++) {
      if ((this.flag[i] != 99) && (this.flag[i] != 0)) {
        g.drawImage(this.PNG,
          (int)this.Mx[i], (int)this.My[i], (int)this.Mx[i] + 48, (int)this.My[i] + 48,
          48 * (int)this.No1[i], 48 * this.Ny[i], 48 * (int)this.No1[i] + 48, 48 * this.Ny[i] + 48,
          Wind);
      }
    }
    g.setColor(Color.WHITE);
    g.setFont(this.f);
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
