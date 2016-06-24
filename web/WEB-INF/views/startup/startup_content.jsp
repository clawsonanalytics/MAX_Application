<%-- 
    Document   : startup_content
    Created on : Apr 9, 2016, 8:04:35 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <!--<link rel="stylesheet" type="text/css" href="/resources/foundation/css/foundation.css"/>-->
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <!-- Header -->
        <div class="blog-post" align="center">
            <h3>Check out what's new with <app:AppName/>!<small>5/24/2016</small></h3>
            <!--<img class="thumbnail" src="http://placehold.it/850x350">-->
            <img class="thumbnail" src="images/bookstack.jpg"/>
            <p>
                We're introducing a new and exciting school management system. Check out 
                <a><app:Website/></a> to find out about all of the exciting features we offer
                including a clean mobile experience as well as desktop web applications.
                Whether you are a single school, a large district, or a home school family,
                let's have a conversation to see how we can meet your educational needs.
                
                If you already have an account and need to contact tech support, follow
                <a href="${pageContext.request.contextPath}/techsupport.htm">this link</a> and we can help you out! Otherwise, use the menu above
                to login.
                
            </p>
            <div class="callout">
                <ul class="menu simple">
                    <li><a href="#">Author: Andrew Clawson, <app:Developer/></a></li>
                <li><a href="#">Comments: 3</a></li>
                </ul>
            </div>
        </div>
        
    </body>
</html>