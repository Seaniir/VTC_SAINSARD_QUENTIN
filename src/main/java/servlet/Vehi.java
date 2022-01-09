package servlet;

import dao.VehiculeDAO;
import model.Vehicule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "vehiculeServlet", value = "/vehicule-servlet")
public class Vehi extends HttpServlet {
    private String message;
    static private Vehicule currentVehicule = null;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        VehiculeDAO vehiculeDAO = new VehiculeDAO();
        List<Vehicule> vehicules = new ArrayList<>();
        vehicules = vehiculeDAO.read();
        // Hello
        request.setAttribute("variable", vehicules);
        if (currentVehicule != null) {
            request.setAttribute("currentVehicule", currentVehicule);
        }
        request.getRequestDispatcher("Vehicule.jsp").forward(
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
                String marque = request.getParameter("marque");
                String modele = request.getParameter("modele");
                String couleur = request.getParameter("couleur");
                String immatriculation = request.getParameter("immatriculation");

                Vehicule vehicule = new Vehicule(marque, modele, couleur, immatriculation);
                VehiculeDAO vehiculeDAO = new VehiculeDAO();
                vehiculeDAO.create(vehicule);
                currentVehicule = null;
            }
            else if (abortParam == null && modifyParam != null)
            {
                String marque = request.getParameter("marque");
                String modele = request.getParameter("modele");
                String couleur = request.getParameter("couleur");
                String immatriculation = request.getParameter("immatriculation");

                Vehicule vehicule = new Vehicule(currentVehicule.getId(), marque, modele, couleur, immatriculation);
                VehiculeDAO vehiculeDAO = new VehiculeDAO();
                vehiculeDAO.update(vehicule);
                currentVehicule = null;
            }
            else
            {
                currentVehicule = null;
            }
        }
        if(decisionParam.equals("D")){
            int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));

            VehiculeDAO vehiculeDAO = new VehiculeDAO();
            System.out.println(idVehicule);
            vehiculeDAO.delete(idVehicule);
        }
        if(decisionParam.equals("R")){
            int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
            System.out.println(idVehicule);

            VehiculeDAO vehiculeDAO = new VehiculeDAO();
            currentVehicule = vehiculeDAO.findById(idVehicule);
        }
        this.doGet(request, response);
    }

    public void destroy() {
    }
}