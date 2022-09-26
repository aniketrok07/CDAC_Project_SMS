import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import '../AdminHomeComponent/adminHome.css'

export default function AddClass() {
  const [classId, setClassId] = useState("");
  const [teacherId, setTeacherId] = useState("");

  const history = useHistory();

  const body = {
    "classId": classId,
    "teacherId": teacherId
  }

  const Back = () => {
    history.push('/adminHome')
  }

  const AddClass = () => {
    const url = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"
    axios.post(url + "/api/v1/class/addClass", body).then(res => {
      const result = res.data;
      if (result.status == "success") {
        window.alert("Class Added Successfully");
        history.push('/adminHome');
      }
    })

  }



  return (

    <div className="container">
      <div className="add">
        <table>
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
        <div ><button className="button" onClick={AddClass}>Add</button></div>
      </div>

    </div>
  )
}
