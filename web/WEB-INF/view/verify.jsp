<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.awt.Graphics"%>
<%@page import="javax.imageio.*"%>
<%@page import="java.awt.*"%>
<%@page import="java.awt.image.BufferedImage"%>
<%
	final char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8','9'};
	/* final char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
		'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z' }; */
	int width = 42, height = 16;
	BufferedImage bi = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	Graphics g = bi.getGraphics();
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, width, height);
	Random rnd = new Random();
	StringBuffer sb = new StringBuffer("");
	
	//产生四位数的字母数字验证码，各个数字的颜色也随即
	for (int i = 0; i < 4; i++) {
		int num = rnd.nextInt(str.length);
		Color c = new Color((new Double(Math.random() * 128)).intValue(),
				(new Double(Math.random() * 128)).intValue(),(new Double(Math.random() * 128)).intValue());
		g.setColor(c);
		g.setFont(new Font("", Font.BOLD + Font.ITALIC, 16));
		g.drawString(str[num] + "", 10*i, 15);
		sb.append(str[num]);
	}
	//划干扰线
	/* for (int i = 0; i < 2; i++) {
		Color c = new Color(rnd.nextInt(256), rnd.nextInt(256),
				rnd.nextInt(256));
		g.setColor(c);
		g.drawLine(rnd.nextInt(width), rnd.nextInt(height),
				rnd.nextInt(width), rnd.nextInt(height));
	} */
	String s = new String(sb);
	/*
	若是产生四位数字，则nextInt(8999) + 1000;
	然后String.valueOf转换为String
	 */
	//验证码存入session里，方便在登陆校检页比对
	session.setAttribute("image", s);
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	//输出到页面
	ImageIO.write(bi, "JPEG", response.getOutputStream());
	/*
	加入下面这两句什么作用呢？
	否则报异常: java.lang.IllegalStateException: getOutputStream() 
	has already been called for this response 
	不管原因了
	 */
	out.clear();
	out = pageContext.pushBody();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片生成</title>
</head>
<body>
</body>
</html>