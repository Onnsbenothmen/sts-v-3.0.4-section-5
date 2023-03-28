<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorator="template.html">
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<head>
<meta charset="utf-8">
<title>Liste des Produits</title>
</head>
<body>
<div layout:fragment="Mycontent">
<div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des Produits
 </div>
 <div class="card-body"> 
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Nom Produit</th><th>Prix</th>
 </tr> 
 <tr th:each="p:${produits.content}">
 <td th:text="${p.idProduit}"></td>
 <td th:text="${p.nomProduit}"></td>
 <td th:text="${p.prixProduit}"></td> 
 <td><a class="btn btn-danger" onclick="return confirm('Etes-vous s�r ?')"
 th:href="@{supprimerProduit(id=${p.idProduit}, 
page=${currentPage},size=${size})}">Supprimer</a></td>
 </tr> 
 </table>
 <ul class="nav nav-pills">
 <li th:each="page,status:${pages}">
 <a th:class="${status.index==currentPage?'btn btn-primary':'btn' }"
 th:href="@{ ListeProduits(page=${status.index}, size=${size} ) }"
 th:text="${status.index }"></a>
 </li>
 </ul>
 </div>
</div>
</div>
</div>
</body>
</html>