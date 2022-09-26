import React from 'react'
import axios from 'axios';
import { useState } from "react";
import { useHistory } from 'react-router-dom'
import '../AdminHomeComponent/adminHome.css'

export default function AddAttendance() {
    const [studentid, setStudentId] = useState("");
    const [date, setDate] = useState("");
    const [status, setStatus] = useState("");

    const history = useHistory();

    const body = {
        "studentid": studentid,
        "date": date,
        "status": status
    }

    const Back = () => {
        history.push('/adminHome')
    }

    const addAttendance = () => {
        const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"
        axios.post(url + "/api/v1/attendance/addAttendance", body).then(res => {
            const result = res.data
            if (result.status == "success") {
                window.alert("Attendance Added");
                history.push('/adminHome');
            }
        })
    }


    return (
        <div className="container ">
            <div className="add">
                <table>
                    <tr>
                        <td>Student Id: </td>
                        <td>
                            <input maxlength="10" onChange={e => { setStudentId(e.target.value) }} type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Date of Attendance: </td>
                        <td>
                            <input onChange={e => { setDate(e.target.value) }} type="date" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Status: </td>
                        <td>
                            <input onChange={e => { setStatus(e.target.value) }} type="text" required />
                        </td>
                    </tr>
                </table>
                <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
                <div ><button className="button" onClick={addAttendance}>Add</button></div>
            </div>
        </div>
    )
}
