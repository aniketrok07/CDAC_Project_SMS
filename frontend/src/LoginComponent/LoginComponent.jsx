import React from 'react'
import axios from "axios";
import { useState,useEffect } from "react";
import ReCAPTCHA from "react-google-recaptcha";
import {Link, useHistory} from 'react-router-dom';
import './login.css';

export default function LoginComponent() {

  useEffect(()=>{
    let user = JSON.parse(localStorage.getItem("status"));
    if(localStorage.getItem("status"))
    {
      if(user.data=="admin")
      {
        history.push({
          pathname:'/adminHome',
          search:'?query=abc',
          state:user.user
      })
      }
      if(user.data=="teacher")
      {
        history.push({
          pathname:'/teacherHome',
          search:'?query=abc',
          state:user.user
      })
      }
      if(user.data=="student")
      {
        history.push({
          pathname:'/studentHome',
          search:'?query=abc',
          state:user.user
      })
      }
      
    }
  })

    const[email,setEmail] = useState("");
    const[password,setPassword]=useState("");
    const[verified,setVerified]=useState(false);
    const history = useHistory();
    function onChange(value) {
      console.log("Captcha value:", value);
      setVerified(true);
    }

    const login = async ()=>{
        // Body as per the request requirement.
        const body = {
            'email':email,
            'password':password
        }
        // Initail url of the server.
        const url = "http://localhost:8080"
        // Post request is made to send the data and get the response.
           await axios.post(url+"/api/v1/user/login",body).then(Response =>{
                const result = Response.data
                // If it is successful send the result data to Goto function.
                if(result.status == "success" && result.data=="student"){
                  localStorage.setItem("status",JSON.stringify(result));
                    history.push({
                        pathname:'/studentHome',
                        search:'?query=abc',
                        state:result.user
                    })
               
                }
                if(result.status == "success" && result.data=="teacher"){
                  localStorage.setItem("status",JSON.stringify(result));
                  history.push({
                      pathname:'/teacherHome',
                      search:'?query=abc',
                      state:result.user
                  })
             
              }
              if(result.status == "success" && result.data=="admin"){
                localStorage.setItem("status",JSON.stringify(result));
                history.push({
                    pathname:'/adminHome',
                    search:'?query=abc',
                    state:result.user
                })
           
            }
            if(result.status =="error"){
              window.alert(result.error)
            }
                
            })
    }
  return (
    <body class="body">
    <div class="center">
    <h1>Login</h1>
    <form method="#">
      <div class="txt_field">
          {/* Onchange is used to set the Email hook as per the the data collected in from input tag. */}
        <input type="email" required onChange={e=>{setEmail(e.target.value)}} />
        <span></span>
        <label>Email</label>
      </div>
      <div class="txt_field">
        <input type="password" onChange={e=>{setPassword(e.target.value)}}  required/>
        <span></span>
        <label>Password</label>
      </div>
      <ReCAPTCHA
    sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"
    onChange={onChange}
  />
      {/* This is a link to ChangePassword component. */}
      <div class="pass"><Link to="/updatePassword">Forgot Password</Link></div>
        {/* Onclick is used to call the callback funtion login when user clicks on button. */}
      <button type="button"  onClick={login} disabled={!verified}>Login</button>
    </form>
  </div>
  
</body>
  )
}
