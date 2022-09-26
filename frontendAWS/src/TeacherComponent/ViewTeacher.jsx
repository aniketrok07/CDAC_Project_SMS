import React, { useState, useEffect } from 'react';
import axios from 'axios';
export default function ViewTeacher() {
  const TEACHER_API_BASE_URL = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080/api/v1/teacher/viewTeacher";

  const [teacher, setTeacher] = useState([]);

  useEffect(() => {
    loadTeachers();

  }, []);

  const loadTeachers = async () => {
    const result = await axios.get(TEACHER_API_BASE_URL);
    setTeacher(result.data);
  }
  return (
    <div>
      <br></br>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Teacher Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Designation</th>
            <th scope="col">Monthly Salary</th>
          </tr>
        </thead>
        <tbody>
          {teacher.map((teacher) => (
            <tr>
              <td>{teacher.teacherId}</td>
              <td>{teacher.fname}</td>
              <td>{teacher.lname}</td>
              <td>{teacher.designation}</td>
              <td>{teacher.monthSalary}</td>
            </tr>

          ))}
        </tbody>
      </table>
    </div>
  )
}
