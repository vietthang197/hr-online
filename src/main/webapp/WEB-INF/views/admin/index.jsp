<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="org.keycloak.AuthorizationContext" %>
<%@ page import="org.keycloak.KeycloakSecurityContext" %>
<%@ page import="org.keycloak.representations.idm.authorization.Permission" %>

<%
    KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Your permissions are:</h3>

<ul>
    <%
        for (Permission permission : authzContext.getPermissions()) {
    %>
    <li>
        <p>Resource: <%= permission.getResourceName() %></p>
        <p>ID: <%= permission.getResourceId() %></p>
        <p>Scopes: <%= permission.getScopes() %></p>
    </li>
    <%
        }
    %>
</ul>
<%
    if (authzContext.hasPermission("Main Page", "urn:servlet-authz:page:main:actionForAdmin")) {
%>
<button>Test Admin</button>
<%
    }
%>

<%
    if (authzContext.hasPermission("Main Page", "urn:servlet-authz:page:main:actionForAdmin2")) {
%>
<button>Test Admin2</button>
<%
    }
%>

<a href="/sso/logout">Logout</a>
</body>
</html>