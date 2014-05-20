package web.app.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.app.org.Field.Field;
import web.app.org.Player.Player;

/**
 * Servlet implementation class MyServler
 */
public class MyServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DRAW_CARD = "drawCard";
	private static final String SET_FIELD_CARD = "setOnField";
	
	Player realPlayer;
	Field field;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServler() {
        super();
        field = new Field();
        realPlayer = new Player(field);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		this.initAction(action, out, request);
	}
	
	private void initAction(String action, PrintWriter out, HttpServletRequest request) {
		switch (action) {
			case DRAW_CARD:
				out.println(realPlayer.drawCard());
				break;
			case SET_FIELD_CARD:
				out.println(realPlayer.setOnField(out, Integer.parseInt(request.getParameter("id"))));
				break;
		}
	}
	
	
	

}
