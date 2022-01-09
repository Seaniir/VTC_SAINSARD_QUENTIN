package servlet;

import dao.AssociationDAO;
import dao.ConducteurDAO;
import dao.VehiculeDAO;
import model.Association;
import model.Conducteur;
import model.Vehicule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "associationServlet", value = "/association-servlet")
public class Asso extends HttpServlet {
    private String message;
    static private Association currentAssociation = null;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        AssociationDAO associationDAO = new AssociationDAO();
        List<Association> associations = new ArrayList<>();
        associations = associationDAO.read();
        ConducteurDAO conducteurDAO = new ConducteurDAO();
        List<Conducteur> conducteurs = new ArrayList<>();
        conducteurs = conducteurDAO.read();
        VehiculeDAO vehiculeDAO = new VehiculeDAO();
        List<Vehicule> vehicules = new ArrayList<>();
        vehicules = vehiculeDAO.read();
        // Hello
        request.setAttribute("variable", associations);
        request.setAttribute("conducteurVariable", conducteurs);
        request.setAttribute("vehiculeVariable", vehicules);
        if (currentAssociation != null) {
            request.setAttribute("currentAssociation", currentAssociation);
        }
        request.getRequestDispatcher("Association.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decisionParam = request.getParameter("purpose");
        String abortParam = request.getParameter("abort");
        String createParam = request.getParameter("Create");
        String modifyParam = request.getParameter("Modify");
        if(decisionParam.equals("C")) {
            if (abortParam == null && createParam != null) {
                String conducteur = request.getParameter("conducteur");
                String vehicule = request.getParameter("vehicule");

                Association association = new Association(Integer.parseInt(conducteur), Integer.parseInt(vehicule));
                AssociationDAO associationDAO = new AssociationDAO();
                associationDAO.create(association);
                currentAssociation = null;
            }
            else if (abortParam == null && modifyParam != null)
            {
                String conducteur = request.getParameter("conducteur");
                String vehicule = request.getParameter("vehicule");

                Association association = new Association(currentAssociation.getId(), Integer.parseInt(conducteur), Integer.parseInt(vehicule));
                AssociationDAO associationDAO = new AssociationDAO();
                associationDAO.update(association);
                currentAssociation = null;
            }
            else
            {
                currentAssociation = null;
            }
        }
        if(decisionParam.equals("D")){
            int idAssociation = Integer.parseInt(request.getParameter("idAssociation"));

            AssociationDAO associationDAO = new AssociationDAO();
            System.out.println(idAssociation);
            associationDAO.delete(idAssociation);
        }
        if(decisionParam.equals("R")){
            int idAssociation = Integer.parseInt(request.getParameter("idAssociation"));
            System.out.println(idAssociation);

            AssociationDAO associationDAO = new AssociationDAO();
            currentAssociation = associationDAO.findById(idAssociation);
        }
        this.doGet(request, response);
    }

    public void destroy() {
    }
}