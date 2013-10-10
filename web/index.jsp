<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
  </head>
  <body>
  <script type="text/javascript" src="script/libs/jquery-1.10.2.js"></script>
  <div style="text-align: center;">
      Welcome to alpha version of 'Social app lite v 0.0.1'
      <br>
      You can:<br>
      <input type="button" id="login" value="Login" data-url="/login.jsp"/>
      <br>OR<br>
      <input type="button" id="rgstr" value="Register" data-url="/registration.jsp"/>
  </div>
    <script type="text/javascript">
        jQuery(document).ready(function(){

            function relocate(element){
                window.location = $(element).attr("data-url");
            }

            jQuery('#login').on('click', function(){
                relocate(this);
            });

            jQuery('#rgstr').on('click', function(){
                relocate(this);
            });

        });
    </script>
  </body>
</html>