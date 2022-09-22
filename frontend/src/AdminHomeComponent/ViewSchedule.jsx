import axios from 'axios';
import React, { useState,useEffect } from 'react'
import {useHistory} from 'react-router-dom';

export default function ViewSchedule() {
  const[clas,setClas]=useState("");
  const[schedule,setSchedule]=useState([]);

  const history = useHistory();

  const body = {
    "classid":clas
  } 

  useEffect(()=>{
    Find();
  },[]);


  const Find = async() =>{

    const url = "http://localhost:8080";
    await axios.post(url+"/api/v1/schedule/viewSchedule",body).then(res=>{
        setSchedule(res.data);

    })

}
  return (
    <div>
            <table align="center">
                <tr>
                    <td>Select Class</td>
                    <td><input type="number" onChange={e=>{setClas(e.target.value)}} required/></td>
                    <td><button  className="btn btn-primary" onClick={Find} >find</button></td>
                </tr>
            </table><br></br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>Day</td>
                    <td>Subject Name</td>
                    <td>Starttime</td>
                    <td>Endtime</td>
                    <td>ClassId</td>
                    <td>Teacher Name</td>
                </tr>
                </thead>
                <tbody>
                  {schedule.map((sch,index)=>(
                    <tr>
                      <td>{sch.day}</td>
                      <td>{sch.subjectName}</td>
                      <td>{sch.starttime}</td>
                      <td>{sch.endtime}</td>
                      <td>{sch.classID}</td>
                      <td>{sch.firstName}</td>
                    </tr>
                  ))}
                </tbody>
            </table>
        
    </div>
  )
}
