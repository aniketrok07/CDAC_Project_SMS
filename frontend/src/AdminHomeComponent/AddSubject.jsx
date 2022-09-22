import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import '../AdminHomeComponent/adminHome.css'

export default function AddSubject() {
    const [classId, setClassId] = useState("");
    const [teacherId, setTeacherId] = useState("");
    const [subjectName, setSubjectName] = useState("");
    const [totalmark, setTotalmark] = useState("");
    const history = useHistory();
    const Back = () => {
        history.push('/adminHome')
    }

    const body = {
        "subjectName": subjectName,
        "totalmark": totalmark,
        "classId": classId,
        "teacherId": teacherId
    }

    const empty = "";

    const validate = () => {
        if (subjectName != empty && totalmark != empty && classId != null && teacherId != empty) {
            AddSub();
        }
        else {
            window.alert("Fields can't be empty!!!")
        }
    }

    const AddSub = () => {
        const url = "http://localhost:8080"
        axios.post(url + "/api/v1/subject/addSubject", body).then(res => {
            const result = res.data;
            if (result.status == "success") {
                window.alert("Subject Added Successfully");
                history.push('/adminHome');
            }
        })
    }


    return (
        <div className="container">
            <div className="add">
                <table>
                    <tr>
                        <td>Subject Name: </td>
                        <td>
                            <input maxlength="20" onChange={e => { setSubjectName(e.target.value) }} type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Total Mark: </td>
                        <td>
                            <input maxlength="11" onChange={e => { setTotalmark(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Class Id: </td>
                        <td>
                            <input maxlength="1" onChange={e => { setClassId(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Teacher Id </td>
                        <td>
                            <input maxlength="2" onChange={e => { setTeacherId(e.target.value) }} type="number" required />
                        </td>
                    </tr>
                </table>
                <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
                <div ><button className="button" onClick={validate}>Add</button></div>
            </div>

        </div>
    )
}
