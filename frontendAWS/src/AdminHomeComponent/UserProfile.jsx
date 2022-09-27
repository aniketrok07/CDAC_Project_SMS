import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory, useLocation } from "react-router"
import './adminHome.css'

import React from 'react'

export default function UserProfile() {

    const location = useLocation()
    const data = location.state
    const history = useHistory()

    const[userid,setUserId] = useState(data.userId);
    const[fname,setFname] = useState(data.fname);
    const[lname,setLname] = useState(data.lname);
    const[email,setEmail] = useState(data.email);
    const[password,setPassword] = useState(data.password);
    const[addressLine,setAddressLine] = useState(data.addressLine);
    const[city,setCity] = useState(data.city);
    const[pincode,setPincode] = useState(data.pincode);
    const[securityCode,setSecurityCode] = useState(data.securityCode);
    const[role,setRole] = useState(data.role);

    useEffect(() =>{
        Defaults()
    },[])

    const UpdateProfile = () =>{

        const data = {
            "userid":userid,
            "fname":fname,
            "lname":lname,
            "email":email,
            "password":password,
            "addressLine":addressLine,
            "city":city,
            "pincode":pincode,
            "role":role,
            "securityCode":securityCode
        }

        const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"

        axios.put(url+'/api/v1/user/updateProfile',data).then(res =>{
            const result = res.data
            if(result.status =="success"){
                window.alert("User Updated successfully")
                history.push('/adminHome')
            }
        })


       
    }

    function Defaults(){
        document.getElementById("fname").defaultValue = data.fname;
        document.getElementById("lname").defaultValue = data.lname;
        document.getElementById("email").defaultValue = data.email;
        document.getElementById("password").defaultValue = data.password;
        document.getElementById("addressLine").defaultValue = data.addressLine;
        document.getElementById("city").defaultValue = data.city;
        document.getElementById("pincode").defaultValue = data.pincode;
        document.getElementById("role").defaultValue = data.role;
        document.getElementById("securityCode").defaultValue = data.securityCode;
    }
  return (
    <div className="container">
        <div className="adminProfile">
        <table>
        <tr>
                <td>User Id : </td>
                <td>
                    <input type="text" onChange={e=>{setUserId(e.target.value)}}  disabled value ={data.userId}/>
                </td>
        </tr>
        <tr>
                <td>First Name : </td>
                <td>
                    <input id="fname" maxlength="30" type="text" onChange={e=>{setFname(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Last Name : </td>
                <td>
                    <input id="lname" maxlength="30" type="text" onChange={e=>{setLname(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Email : </td>
                <td>
                    <input id="email" maxlength="30" type="text" onChange={e=>{setEmail(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Password : </td>
                <td>
                    <input id="password" maxlength="30" type="text" onChange={e=>{setPassword(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Address line : </td>
                <td>
                    <input id="addressLine" maxlength="30" type="text" onChange={e=>{setAddressLine(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>City : </td>
                <td>
                    <input id="city" maxlength="30" type="text" onChange={e=>{setCity(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Pincode: </td>
                <td>
                    <input id="pincode" maxlength="30" type="text" onChange={e=>{setPincode(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Security Code : </td>
                <td>
                    <input id="securityCode" maxlength="30" type="text" onChange={e=>{setSecurityCode(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td>Role : </td>
                <td>
                    <input id="role" maxlength="30" type="text" disabled onChange={e=>{setRole(e.target.value)}}  />
                </td>
        </tr>
        <tr>
                <td colSpan="2" >
                    <button  className="button" onClick={UpdateProfile} >Update</button>
                </td>
                
            </tr>
        </table>
        </div>
    </div>
  )
}
