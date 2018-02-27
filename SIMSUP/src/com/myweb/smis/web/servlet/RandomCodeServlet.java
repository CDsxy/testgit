package com.myweb.smis.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@WebServlet("/randomCode")
public class RandomCodeServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成随机数
        String randomCode = UUID.randomUUID().toString().substring(0, 5);
        //把随机数放进session中
        req.getSession().setAttribute("RANDOMCODE_IN_SESSION", randomCode);

        //创建图片对象
        int width = 80;
        int height = 40;
        int imageType = BufferedImage.TYPE_INT_BGR;
        BufferedImage image = new BufferedImage(width, height, imageType);

        //画板
        Graphics g = image.getGraphics();
        g.setColor(Color.orange);
        //绘制一个实心的矩形
        g.fillRect(1, 1, width - 2, height - 2);

        //把随机数画进图片中
        g.setColor(Color.black);//设置随机数颜色
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
        g.setFont(font);//设置随机数字体和大小
        g.drawString(randomCode, 10, 28);
        //干扰线
        g.setColor(Color.gray);
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            g.fillRect(r.nextInt(width), r.nextInt(height), 2 , 2);
        }
        //关闭
        g.dispose();
        //把图片对象以流的形式保存出去
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
