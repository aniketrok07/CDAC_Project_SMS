import axios from 'axios';
import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom';

export default function ViewSubject() {
  const [clas, setClas] = useState("");
  const [subject, setSubject] = useState([]);

  const history = useHistory();

  const body = {
    "classId": clas
  }

  useEffect(() => {
    Find();
  }, []);


  const Find = async () => {

    const url = "http://localhost:8080";
    await axios.post(url + "/api/v1/subject/viewSubject", body).then(res => {
      setSubject(res.data);

    })

  }
  return (
    <div>
      <table align="center">
        <tr>
          <td>Select Class</td>
          <td><input type="number" onChange={e => { setClas(e.target.value) }} required /></td>
          <td><button className="btn btn-primary" onClick={Find} >find</button></td>
        </tr>
      </table><br></br>
      <table class="table table-striped">
        <thead>
          <tr>
            <td>SubjectId</td>
            <td>SubjectName</td>
            <td>TotalMarks</td>
            <td>ClassId</td>
            <td>Teacher Name</td>
          </tr>
        </thead>
        <tbody>
          {subject.map((sch) => (
            <tr>
              <td>{sch.subjectId}</td>
              <td>{sch.subjectName}</td>
              <td>{sch.totalMark}</td>
              <td>{sch.classId}</td>
              <td>{sch.fname}</td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  )
}
