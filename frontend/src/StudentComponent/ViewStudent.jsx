import axios from 'axios';
import React, { useState,useEffect } from 'react'
import {useHistory} from 'react-router-dom';

export default function () {

    const[clas,setClas]=useState("");
    const[student,setStudent]=useState([]);

    const history = useHistory();

    const body = {
        "classid":clas
    }

    useEffect(()=>{
        Find();
    },[]);

    const Find = async() =>{

        const url = "http://localhost:8080";
        await axios.post(url+"/api/v1/student/findStudent",body).then(res=>{
            setStudent(res.data);

        })

    }

    // const Delete = (id)=>{
    //     const url = `http://localhost:8080/api/v1/student/${id}`;
    //     axios.delete(url).then(res=>{
    //         const result = res.data
    //         if(result.status=="success")
    //         {
    //             history.push("#");
    //         }
    //     })
        
    // }
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
                    <td>student Id</td>
                    <td>first name</td>
                    <td>last name</td>
                    <td>Class ID</td>
                    <td>Fees paid</td>
                    {/* <td>Action</td> */}
                </tr>
                </thead>
                <tbody>
                    {student.map((stud,index)=>(
                        <tr>
                            <td>{stud.student_id}</td>
                            <td>{stud.first_name}</td>
                            <td>{stud.last_name}</td>
                            <td>{stud.class_id}</td>
                            <td>{stud.fees_paid}</td>
                            {/* <td><button onClick={()=>Delete(stud.student_id)} >Delete</button></td> */}
                        </tr>
                    ))}

                </tbody>
            </table>
        
    </div>
  )
}
