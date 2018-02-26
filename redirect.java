


RequestDispatcher forward method pass the control of the request to another servlet or jsp without telling anything about the request dispatch to the client browser. Therefore client browser don't know whether the returned resource is from an another servlet/jsp or not. 

sendRedirect method stop further processing of the request and send http status code "301" and URL of the location to be redirected to the client browser in the response header. Server does not have control of this request after sending the redirect related HTTP header to the client browser. Client browser sees http status 301 and then it know it should send a new request to the url in "Location" http header which is set by server. and Client browser sends a new request to the new URL and it will be processed by the server as another normal request. 

Therefore request dispatch happens completely in the server side. 
But sendRedirect is handle through the client browser. 

--Sendredirect and session

public class GetAlienController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		AlienDao dao  = new AlienDao();
		Alien a1 = dao.getAlien(aid);
		
		HttpSession session = request.getSession();
		session.setAttribute("alien", a1);
		
		response.sendRedirect("showAlien.jsp");
	}
  }
  
  
   RequestDispatcher in Servlet
RequestDispatcher Interface
Methods of RequestDispatcher interface
forward method
include method
How to get the object of RequestDispatcher
Example of RequestDispatcher interface
The RequestDispatcher interface provides the facility of dispatching the request to another resource it may be html, servlet or jsp. This interface can also be used to include the content of another resource also. It is one of the way of servlet collaboration.


RequestDispatcher rd=request.getRequestDispatcher("servlet2.jsp");  
//servlet2 is the url-pattern of the second servlet  
  
rd.forward(request, response);//method may be include or forward  
