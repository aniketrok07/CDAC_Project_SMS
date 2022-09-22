import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import '../AdminHomeComponent/adminHome.css'

export default function AddFees() {
  const [studentId, setStudentId] = useState("");
  const [feeamount, setFeeAmount] = useState("");
  const history = useHistory();
  const Back = () => {
    history.push('/adminHome')
  }

  const body = {
    "studentId": studentId,
    "feeamount": feeamount
  }

  const AddFees = () => {
    const url = "http://localhost:8080"
    axios.post(url + "/api/v1/student/addFees", body).then(res => {
      const result = res.data;
      if (result.status == "success") {
        window.alert("Fees Added Successfully");
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
            <td>Fees amount </td>
            <td>
              <input onChange={e => { setFeeAmount(e.target.value) }} type="number" required />
            </td>
          </tr>
        </table>
        <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
        <div ><button className="button" onClick={AddFees}>Add</button></div>
      </div>

    </div>
  )
}
