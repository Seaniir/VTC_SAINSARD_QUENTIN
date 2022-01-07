package servlet;

import dao.ConducteurDAO;
import model.Conducteur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "conducteurServlet", value = "/conducteur-servlet")
public class Condu extends HttpServlet {
    private String message;
    static private Conducteur currentConducteur = null;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ConducteurDAO conducteurDAO = new ConducteurDAO();
        List<Conducteur> conducteurs = new ArrayList<>();
        conducteurs = conducteurDAO.read();
        // Hello
        request.setAttribute("variable", conducteurs);
        if (currentConducteur != null) {
            request.setAttribute("currentConducteur", currentConducteur);
        }
        request.getRequestDispatcher("Conducteur.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decisionParam = request.getParameter("purpose");
        String statusParam = request.getParameter("status");
        if(decisionParam.equals("C")) {
            if (statusParam == null) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");

                Conducteur conducteur = new Conducteur(nom, prenom);
                ConducteurDAO conducteurDAO = new ConducteurDAO();
                conducteurDAO.create(conducteur);
            }
            else
            {
                currentConducteur = null;
            }
        }
        if(decisionParam.equals("D")){
            int idConductor = Integer.parseInt(request.getParameter("idConductor"));

            ConducteurDAO conducteurDAO = new ConducteurDAO();
            System.out.println(idConductor);
            conducteurDAO.delete(idConductor);
        }
        if(decisionParam.equals("R")){
            int idConductor = Integer.parseInt(request.getParameter("idConductor"));
            System.out.println(idConductor);

            ConducteurDAO conducteurDAO = new ConducteurDAO();
            currentConducteur = conducteurDAO.findById(idConductor);
        }
        this.doGet(request, response);
    }

    public void destroy() {
    }
}