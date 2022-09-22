import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import '../AdminHomeComponent/adminHome.css'


export default function AddMarks() {
  const [studentId, setStudentId] = useState("");
  const [subjectId, setSubjectId] = useState("");
  const [marks, setMarks] = useState("");

  const history = useHistory();
  const Back = () => {
    history.push('/adminHome')
  }

  const body = {
    "studentId": studentId,
    "subjectId": subjectId,
    "marks": marks
  }

  const AddMarks = () => {
    const url = "http://localhost:8080"
    axios.post(url + "/api/v1/teacher/addMarks", body).then(res => {
      const result = res.data;
      if (result.status == "success") {
        window.alert("Marks Added Successfully");
        history.push('/adminHome');
      }
    })
  }
  return (
    <div className="container">
      <div className="add">
        <table>
          <tr>
            <td>Student Id: </td>
            <td>
              <input maxlength="1" onChange={e => { setStudentId(e.target.value) }} type="number" required />
            </td>
          </tr>
          <tr>
            <td>Subject Id: </td>
            <td>
              <input onChange={e => { setSubjectId(e.target.value) }} type="number" required />
            </td>
          </tr>
          <tr>
            <td>Marks: </td>
            <td>
              <input onChange={e => { setMarks(e.target.value) }} type="number" required />
            </td>
          </tr>
        </table>
        <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
        <div ><button className="button" onClick={AddMarks}>Add</button></div>
      </div>

    </div>
  )
}
