<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Register</title>
    <style>
        body{
            text-align: center;
            background-color:lavenderblush;
        }
        td{
            padding-top: 7.5px;
            padding-left: 32px;
            text-align: left;
            font-weight: bolder;
           color: honeydew;
          
        }
        input{
        width:200px;
        
        }
        .table{
            text-align: center;
            background-color:darkolivegreen;
            margin-left: 350px;
            margin-right: 350px;
            border-radius: 10px;
            box-shadow: 3px 3px 3px black;
        }
        td a{
            text-decoration: none;
            color:darkblue;
            background-color: beige;
           

        }
      
    </style>
</head>
<body>
    
    <form action="AddEmpServlet" method="post">
        <div class="table">
        <table>
      			 <tr><td><h2><u>Add Employee</u></h2></td></tr>
                 <tr><td>Employee Name</td><td><input type="text" name="EmpName" id="" placeholder="Enter Employee Name"></td></tr>
                 <tr><td>Employee Id</td><td><input type="text" name="Empid" id="" placeholder="Enter Employee ID"></td></tr>
                 <tr><td>Password</td><td><input type="password" name="password" id="" placeholder="Enter Password"></td></tr>
                 <tr><td>Gender</td> <td><input type="text" name="gender" id="" placeholder="Enter Gender (M/F/O)"> </td></tr>
                 <tr><td>E-mail</td><td><input type="email" name="email" id="" placeholder="Enter Employee Email"></td></tr> 
                 <tr><td>Mobile</td><td><input type="text" name="mobile" id="" placeholder="Enter Employee Mobile Number"></td></tr>
                 <tr><td>Country</td>
                    <td>
                        <select name="country" id="">
                            <option value="India">India</option>
                            <option value="USA">USA</option>
                            <option value="UK">UK</option>
                            <option value="Russia">Russia</option>
                            <option value="NewZeeland">NewZeeland</option>
                            <option value="UAE">UAE</option>

                        </select>
                    </td>
                </tr>
                 <tr><td></td><td><input width=30px; type="submit" value="save" ></td></tr>
                 <tr><td><a href="ViewDetails">View Details</a></td></tr>
        </table>
    </div>
    </form>
    
</body>
</html>