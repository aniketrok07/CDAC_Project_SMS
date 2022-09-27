import axios from 'axios';
import React, { useRef } from 'react'
import emailjs from "emailjs-com";
import { useState } from "react";
import { useHistory } from 'react-router-dom'
import '../AdminHomeComponent/adminHome.css'

export default function AddStudent() {

    const form = useRef();

    const [fname, setFname] = useState("");
    const [lname, setlname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [addressLine, setAddressLine] = useState("");
    const [city, setCity] = useState("");
    const [pincode, setPincode] = useState("");
    const [securityCode, setSecurityCode] = useState("");
    const [classId, setClassId] = useState("");
    const [role, setRole] = useState("");

    const history = useHistory()

    const body = {

        "fname": fname,
        "lname": lname,
        "email": email,
        "password": password,
        "addressLine": addressLine,
        "city": city,
        "pincode": pincode,
        "role": role,
        "securityCode": securityCode,
        "classId": classId
    }

    const Back = () => {
        history.push('/adminHome')
    }

    function sendEmail(e) {

        e.preventDefault();

        emailjs.sendForm('service_ixdiu8c', 'template_tc6gx4o', e.target, 'eRD0ouy28qgvssypq')
            .then((result) => {
                console.log(result.text);
            }, (error) => {
                console.log(error.text);
            });


    }


    const Register = () => {
        const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"
        axios.post(url + "/api/v1/student/addStudent", body).then(res => {
            const result = res.data
            if (result.status == "success") {
                window.alert("Registration Successful");
                history.push('/adminHome');
            }else{
                window.alert("email id already used");
            }
        })
    }


    return (
        <div className="container ">
            <div className="add">
                <form onSubmit={sendEmail}>
                    <table >
                        <tr>
                            <td>fname: </td>
                            <td>
                                <input maxlength="10" onChange={e => { setFname(e.target.value) }} type="text" required name="fname" />
                            </td>
                        </tr>
                        <tr>
                            <td>Lname: </td>
                            <td>
                                <input maxlength="10" onChange={e => { setlname(e.target.value) }} type="text" required name="lname" />
                            </td>
                        </tr>
                        <tr>
                            <td>email: </td>
                            <td>
                                <input onChange={e => { setEmail(e.target.value) }} type="email" required name="email" />
                            </td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td>
                                <input onChange={e => { setPassword(e.target.value) }} type="text" required name="password" />
                            </td>
                        </tr>
                        <tr>
                            <td>Address Line: </td>
                            <td>
                                <input onChange={e => { setAddressLine(e.target.value) }} type="text" required name="address" />
                            </td>
                        </tr>
                        <tr>
                            <td>City: </td>
                            <td>
                                <input onChange={e => { setCity(e.target.value) }} type="text" required name="city" />
                            </td>
                        </tr>
                        <tr>
                            <td>Pincode: </td>
                            <td>
                                <input onChange={e => { setPincode(e.target.value) }} type="text" required name="pincode" />
                            </td>
                        </tr>
                        <tr>
                            <td>Role: </td>
                            <td>
                                <input onChange={e => { setRole(e.target.value) }} type="text" required name="role" />
                            </td>
                        </tr>
                        <tr>
                            <td>Security Code: </td>
                            <td>
                                <input onChange={e => { setSecurityCode(e.target.value) }} type="text" required name="scode" />
                            </td>
                        </tr>
                        <tr>
                            <td>Class Id: </td>
                            <td>
                                <input onChange={e => { setClassId(e.target.value) }} type="text" required name="class" />
                            </td>
                        </tr>
                    </table>
                    <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
                    <div ><button className="button" onClick={Register}>Add</button></div>
                </form>
            </div>
        </div>
    )
}
