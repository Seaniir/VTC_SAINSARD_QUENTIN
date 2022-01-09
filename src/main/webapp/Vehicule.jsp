<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Véhicules</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/Conducteur.css" rel="stylesheet">
</head>
<body>
<c:import url="header.jsp"/>
<c:if test="${variable.size() != 0 }">
<table class="table container mt-5">
    <thead>
    <tr>
        <th scope="col" class="text-center">id_vehicule</th>
        <th scope="col" class="text-center">marque</th>
        <th scope="col" class="text-center">modele</th>
        <th scope="col" class="text-center">couleur</th>
        <th scope="col" class="text-center">immatriculation</th>
        <th scope="col" class="text-center">modification</th>
        <th scope="col" class="text-center">suppression</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${variable}" var="element">
        <tr>
            <th class="text-center">${element.getId()}</th>
            <td class="text-center">${element.getMarque()}</td>
            <td class="text-center">${element.getModele()}</td>
            <td class="text-center">${element.getCouleur()}</td>
            <td class="text-center">${element.getImmatriculation()}</td>
            <td class="text-center">
                <form action="${pageContext.request.contextPath}/vehicule-servlet" method="post">
                    <input type="hidden" name="purpose" value="R">
                    <input type="hidden" name="idVehicule" value="${element.getId()}">
                    <button>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-pencil-fill" viewBox="0 0 16 16">
                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                        </svg>
                    </button>
                </form>
            </td>
            <td class="text-center">
                <form action="${pageContext.request.contextPath}/vehicule-servlet" method="post">
                    <input type="hidden" name="purpose" value="D">
                    <input type="hidden" name="idVehicule" value="${element.getId()}">
                    <button>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-x-square-fill" viewBox="0 0 16 16">
                            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>
                        </svg>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${variable.size() == 0 }">
        <h1 class="container text-center my-5">Pas de véhicules disponibles</h1>
    </c:if>
    </tbody>
</table>
<form class="container w-25 mb-5" action="${pageContext.request.contextPath}/vehicule-servlet" method="post">
    <input type="hidden" name="purpose" value="C">
    <div class="form-group">
        <label for="marqueField">Marque</label>
        <input type="text" class="form-control" id="marqueField" name="marque"
               value="${currentVehicule != null ? currentVehicule.getMarque() : ""}">
    </div>
    <div class="form-group">
        <label for="modeleField">Modele</label>
        <input type="text" class="form-control" id="modeleField" name="modele"
               value="${currentVehicule != null ? currentVehicule.getModele() : ""}">
    </div>
    <div class="form-group">
        <label for="couleurField">Couleur</label>
        <input type="text" class="form-control" id="couleurField" name="couleur"
               value="${currentVehicule != null ? currentVehicule.getCouleur() : ""}">
    </div>
    <div class="form-group">
        <label for="immatriculationField">Immatriculation</label>
        <input type="text" class="form-control" id="immatriculationField" name="immatriculation"
               value="${currentVehicule != null ? currentVehicule.getImmatriculation() : ""}">
    </div>
    <button type="submit" name="${currentVehicule != null ? "Modify" : "Create"}" value="submit" class="btn btn-primary mt-3">
        ${currentVehicule != null ? "Modifier ce vehicule" : "Ajouter ce vehicule"}
    </button>
    <c:if test="${currentVehicule != null }">
        <button type="submit" name="abort" value="Abort" class="btn btn-primary mt-3">
            Annuler
        </button>
    </c:if>
</form>
<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>