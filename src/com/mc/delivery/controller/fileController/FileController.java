package com.mc.delivery.controller.fileController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionFactory;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/File")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileController() {
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 이미지 파일 가져와서 서버저장소에 넣어두기.
		String encType = "UTF-8";
		String savePath = "images";
		String uploadFilePath = getServletContext().getRealPath(savePath);
		int maxPostSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(req, uploadFilePath, maxPostSize, encType,
				new DefaultFileRenamePolicy());
		req.setAttribute("multi", multi);
		String command = multi.getParameter("command");
		System.out.println("컨트롤러에 입력된 커맨드:" + command);
		ActionFactory af = ActionFactory.getActionFactory();
		Action action = af.getAction(command);
		if (action != null) {
			action.execute(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);

	}
}
