import axios from 'axios';
import React, { useState,useEffect } from 'react'
import {useHistory} from 'react-router-dom';

export default function ViewAttendance() {
//   const[clas,setClas]=useState("");
  const[stud,setStud]=useState("");
  const[attendance,setAttendance]=useState([]);

  const history = useHistory();

  const body = {
    // "classId":clas,
    "studId":stud
  } 

  useEffect(()=>{
    Find();
  },[]);


  const Find = async() =>{

    const url = "http://localhost:8080";
    await axios.post(url+"/api/v1/attendance/viewAttendance",body).then(res=>{
        setAttendance(res.data);

    })

}
  return (
    <div>
            <table align="center">
                <tr>
                    {/* <td>Enter Class</td>
                    <td><input type="number" onChange={e=>{setClas(e.target.value)}} required/></td> */}
                    <td>Enter Student Id</td>
                    <td><input type="number" onChange={e=>{setStud(e.target.value)}} required/></td>
                    <td><button  className="btn btn-primary" onClick={Find} >find</button></td>
                </tr>
            </table><br></br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>StudentId</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Class Id</td>
                    <td>Date</td>
                    <td>Status</td>
                </tr>
                </thead>
                <tbody>
                  {attendance.map((sch)=>(
                    <tr>
                      <td>{sch.studentId}</td>
                      <td>{sch.firstName}</td>
                      <td>{sch.lastName}</td>
                      <td>{sch.classId}</td>
                      <td>{sch.date}</td>
                      <td>{sch.status}</td>
                    </tr>
                  ))}
                </tbody>
            </table>
        
    </div>
  )
}
