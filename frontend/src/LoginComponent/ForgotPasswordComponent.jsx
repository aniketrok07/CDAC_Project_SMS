import React from 'react'
import axios from "axios";
import { useState } from "react";
import { Link, useHistory } from 'react-router-dom';
import './login.css';

export default function ForgotPasswordComponent() {

  const [email, setEmail] = useState("");
  const [secretkey, setSecretKey] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const history = useHistory();

  const updatePassword = () => {

    const body = {
      "email": email,
      "securitycode": secretkey,
      "newPassword": newPassword
    }

    const url = "http://localhost:8080"
    axios.post(url + "/api/v1/user/updatePassword", body).then(Response => {
      const result = Response.data
      if (result.status == "success") {
        window.alert(result.status)
        history.push({
          pathname: '/login',
          search: '?query=abc',
          state: result.data
        })
      } else {
        window.alert(result.status)
      }
    })


  }




  return (
    <body class="body">
      <div class="center">
        <h1>Change Password</h1>
        <form method="#">
          <div class="txt_field">
            {/* Onchange is used to set the Email hook as per the the data collected in from input tag. */}
            <input type="email" required onChange={e => { setEmail(e.target.value) }} />
            <span></span>
            <label>Email</label>
          </div>
          <div class="txt_field">
            <input type="text" onChange={e => { setSecretKey(e.target.value) }} required />
            <span></span>
            <label>Secret Code</label>
          </div>
          <div class="txt_field">
            <input type="password" onChange={e => { setNewPassword(e.target.value) }} required />
            <span></span>
            <label>New Password</label>
          </div>
          <div id="showError"></div>

          {/* This is a link to ChangePassword component. */}
          {/* Onclick is used to call the callback funtion login when user clicks on button. */}
          <button type="button" onClick={updatePassword}>Change</button>
        </form>
      </div>

    </body>
  )
}
