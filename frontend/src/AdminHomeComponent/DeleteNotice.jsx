import axios from 'axios';
import React from 'react'
import { useState } from "react";
import {useHistory} from 'react-router-dom'
import '../AdminHomeComponent/adminHome.css'

export default function DeleteNotice() {
    const[notice,setNotice]=useState("");

    const history = useHistory();

    const Back = () =>{
        history.push('/adminHome')
      }

      const body = {
        "noticeId":notice
    }    

    const DeleteNotice = () =>{
        const url = "http://localhost:8080"
        axios.post(url+"/api/v1/notice/delete",body).then(res =>{
            const result = res.data;
      if(result.status=="success"){
        window.alert("Notice deleted Successfully");
        history.push('/adminHome');
    }
        })
    }

  return (
    <div className="container">
        <div className="add">
        <table>
        <tr>
        <td>Enter Notice no: </td>
        <td>
        <input maxlength="20" onChange={e=>{setNotice(e.target.value)}} type="text" required />
        </td>
        </tr>
        </table>
        <div  className="b-spacing"><button className="button" onClick={Back}>Back</button></div>
        <div ><button className="button" onClick={DeleteNotice}>Delete</button></div>
        </div>
    </div>
  )
}
