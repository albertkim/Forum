<!-- Register popup -->
<link rel="stylesheet" type="text/css" href="css/popup.css">

<div class="popup-background" hidden></div>
<div class="register-popup-wrapper" hidden>
  <div class="popupCloseButton" style="float: right">Close</div>
  <h4>Register</h4>
  <form action="./postServlet" method="POST">         
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
    <input  style="float: right" type="submit" name="action" value="register" />
  </form>
</div>