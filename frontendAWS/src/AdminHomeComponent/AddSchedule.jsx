import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import '../AdminHomeComponent/adminHome.css'

export default function AddSchedule() {
    const [subjectId, setSubjectId] = useState("");
    const [day, setDay] = useState("");
    const [starttime, setStartTime] = useState("");
    const [endtime, setEndTime] = useState("");

    const history = useHistory();
    const Back = () => {
        history.push('/adminHome')
    }

    const body = {
        "day": day,
        "starttime": starttime,
        "endtime": endtime,
        "subjectId": subjectId,
    }

    const empty = "";

    const validate = () => {
        if (day != empty && starttime != empty && endtime != null && subjectId != empty) {
            AddSchedule();
        }
        else {
            window.alert("Fields can't be empty!!!")
        }
    }

    const AddSchedule = () => {
        const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"
        axios.post(url + "/api/v1/schedule/addSchedule", body).then(res => {
            const result = res.data;
            if (result.status == "success") {
                window.alert("Schedule Added Successfully");
                history.push('/adminHome');
            }
        })
    }


    return (
        <div className="container">
            <div className="add">
                <table>
                    <tr>
                        <td>Day: </td>
                        <td>
                            <input maxlength="10" onChange={e => { setDay(e.target.value) }} type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Subject Id: </td>
                        <td>
                            <input onChange={e => { setSubjectId(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Start time: </td>
                        <td>
                            <input onChange={e => { setStartTime(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>End Time: </td>
                        <td>
                            <input onChange={e => { setEndTime(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                </table>
                <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
                <div ><button className="button" onClick={validate}>Add</button></div>
            </div>

        </div>
    )
}
