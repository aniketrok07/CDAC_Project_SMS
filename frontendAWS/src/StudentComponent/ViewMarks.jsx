import axios from 'axios';
import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom';

export default function ViewMarks() {

  const [clas, setClas] = useState("");
  const [studId, setStudId] = useState("");
  const [marks, setMarks] = useState([]);

  const body = {
    "classId": clas,
    "studId": studId
  }

  useEffect(() => {
    Find();
  }, []);

  const Find = async () => {

    const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080";
    await axios.post(url + "/api/v1/teacher/viewMarks", body).then(res => {
      setMarks(res.data);

    })

  }
  return (
    <div>
      <table align="center">
        <tr>
          <td>Class</td>
          <td><input type="number" onChange={e => { setClas(e.target.value) }} required /></td>
          <td>StudentId</td>
          <td><input type="number" onChange={e => { setStudId(e.target.value) }} required /></td>
          <td><button className="btn btn-primary" onClick={Find} >find</button></td>
        </tr>
      </table><br></br>
      <table class="table table-striped">
        <thead>
          <tr>
            <td>Subject id</td>
            <td>Subject Name</td>
            <td>Marks</td>
            <td>Firstname</td>
            <td>ClassId</td>
          </tr>
        </thead>
        <tbody>
          {marks.map((sch, index) => (
            <tr>
              <td>{sch.subjectId}</td>
              <td>{sch.subjectName}</td>
              <td>{sch.marks}</td>
              <td>{sch.firstName}</td>
              <td>{sch.classId}</td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  )
}
