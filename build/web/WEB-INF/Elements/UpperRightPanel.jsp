<div id="userDiv" class="backgroundbox" style="width: 250px; height: auto;">
  <form action="./loginServlet" method="POST">         
    <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="USERNAME" value="${user.USERNAME}"/></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="PASSWORD" value="${user.PASSWORD}"/></td>
      </tr>
    </table>
    <input  style="float: right;" type="submit" name="action" value="login"/>
    <input  style="float: right;" type="submit" name="action" value="logout"/>
    <!-- Functionality for this set through Javascript -->
    <button type="button" class="registerButton" style="float: left">Register</button>
  </form>
</div>