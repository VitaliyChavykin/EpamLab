
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Queue" %>
<%@ page import="java.util.ArrayList" %>

<html>


<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//malsup.github.com/jquery.form.js"></script>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#getState').click(function (){
            $.ajax({

                type: "Get",
                // url work only if after "/" any symbol
                url: "/nobody know, how it's rly works",
                success: function(msg){$('#output').html(msg);}
            });
        });

        $('#putState').click(function (){
            $.ajax({
                type: "put",
                url: "/nobody know, how it's rly works",
                success: function(msg){$('#output').html(msg);}
            });
        });

        $('#postState').click(function (){
            $.ajax({
                type: "post",
                url: "/nobody know, how it's rly works",
                success: function(msg){$('#output').html(msg);}
            });
        });

        $('#deleteState').click(function (){
            $.ajax({
                type: "delete",
                url: "/nobody know, how it's rly works",
                success: function(msg){$('#output').html(msg);
                }
            });
        });
    });



</script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body align="center">
</br>
</br>
<input style="height:70px;width:200px" type="button" value="Get" id="getState"/>
<input style="height:70px;width:200px" type="button" value="Put" id="putState"/>
<input style="height:70px;width:200px" type="button" value="Post" id="postState"/>
<input style="height:70px;width:200px" type="button" value="Delete" id="deleteState"/>

<div style="font-size: 50px; margin: 200px; position:center"  id="output"></div>
</body>



</html>