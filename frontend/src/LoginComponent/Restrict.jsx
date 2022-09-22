import React from 'react'
import axios from "axios";
import { useState,useEffect } from "react";
import ReCAPTCHA from "react-google-recaptcha";
import {Link, useHistory} from 'react-router-dom';
import './login.css';

export default function LoginComponent(props) {
  let Cmp=props.Cmp;
  const history = useHistory();
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
    else{
      history.push("/login");
    }
  })

   
  return (
    <div>
<Cmp/>
    </div>
  )
}
