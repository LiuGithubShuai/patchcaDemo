package com.kaishengit.controller;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.FontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

@WebServlet("/patchca.png")
public class PatchcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
		cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
		
		
		RandomWordFactory rf = new RandomWordFactory();
		rf.setMinLength(4);
		rf.setMaxLength(4);
		rf.setCharacters("[a-z]");
		
		cs.setWordFactory(rf);
		
		FontFactory ff = new FontFactory(){
			@Override
			public Font getFont(int i) {
				return new Font("Î¢ÈíÑÅºÚ",Font.BOLD,34);
			}			
		};
		
		cs.setFontFactory(ff);
		
		OutputStream outputStream = resp.getOutputStream();
		String code = EncoderHelper.getChallangeAndWriteImage(cs, "png", outputStream);
		
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		
		outputStream.flush();
		outputStream.close();
	}
}
