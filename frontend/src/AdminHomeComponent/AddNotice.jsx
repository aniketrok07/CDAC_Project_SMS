import axios from 'axios';
import React from 'react'
import { useState } from "react";
import { useHistory } from 'react-router-dom'
import '../AdminHomeComponent/adminHome.css'

export default function AddNotice() {
  const [notice, setNotice] = useState("");

  const history = useHistory();

  const Back = () => {
    history.push('/adminHome')
  }

  const body = {
    "notice": notice
  }

  const empty = "";

  const validate = () => {
    if (notice != empty) {
      AddNotice();
    }
    else {
      window.alert("Fields can't be empty!!!")
    }
  }


  const AddNotice = () => {
    const url = "http://localhost:8080"
    axios.post(url + "/api/v1/notice/register", body).then(res => {
      const result = res.data;
      if (result.status == "success") {
        window.alert("Notice Added Successfully");
        history.push('/adminHome');
      }
    })
  }

  return (
    <div className="container">
      <div className="add">
        <table>
          <tr>
            <td>Notice: </td>
            <td>
              <input maxlength="20" onChange={e => { setNotice(e.target.value) }} type="text" required />
            </td>
          </tr>
        </table>
        <div className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
        <div ><button className="button" onClick={validate}>Add</button></div>
      </div>
    </div>
  )
}
