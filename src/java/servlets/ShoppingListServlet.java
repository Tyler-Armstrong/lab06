
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logout = request.getParameter("action");
        if (logout != null && logout.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();           
        }
        
        
        HttpSession session = request.getSession(); 
        String username = (String)session.getAttribute("username");
        
        if(username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
        
        
        
    }

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
       
        
        if(action!=null && action.equals("register")) {
        
            if(username == null || username.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
        }
        
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }  
        
        
        if(action!=null && action.equals("add")) {
            String item = request.getParameter("item");
            HttpSession session = request.getSession();
            ArrayList<String> items;

            if(item == null || item.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;               
            }  
            
            if(session.getAttribute("item")== null ) {
                items = new ArrayList<String>();
                items.add(item);
                session.setAttribute("item", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }else {
            
            items = (ArrayList<String>) session.getAttribute("item");
            items.add(item);
            session.setAttribute("item", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
            
            }           
        }
  
        if(action!=null && action.equals("delete")) {
        
            HttpSession session = request.getSession();
            ArrayList<String> items = new ArrayList<>();
            items = (ArrayList<String>) session.getAttribute("item");
            
            
            if(items == null || items.isEmpty()) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            
            String deleteItem = request.getParameter("button");
            
            if(deleteItem == null && deleteItem.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            
            items.remove(deleteItem);
            session.setAttribute("item", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        
    }
    

}  


