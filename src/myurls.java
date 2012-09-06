import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myurls
 */
@WebServlet("/myurls")
public class myurls extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myurls() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		derby t = new derby();

		String[] URls = new String[3];
		URls = t.doIt();

		// System.out.println(URls);

		if (URls[0].equals(" ")) {

			for (int i = 0; i < URls.length; i++) {

				URls[i] = "no URL";

			}

		}

		JSONObject URL = null;
		JSONObject json = new JSONObject();
		JSONArray URLs = new JSONArray();
		for (int i = 0; i < URls.length; i++) {
			URL = new JSONObject();
			URL.put("URL", URls[i]);

			URLs.put(URL);
		}

		json.put("URLs", URLs);
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
