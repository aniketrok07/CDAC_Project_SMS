import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';


export default function DeleteNoticeComponent() {


  const NOTICE_API_BASE_URL = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080/api/v1/notice"

  const [notices, setNotices] = useState([]);

  const history = useHistory();

  useEffect(() => {
    loadNotices();

  }, []);

  const loadNotices = async () => {
    const result = await axios.get(NOTICE_API_BASE_URL);
    setNotices(result.data);
  }


   const Delete = (id)=>{
        const url = `http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080/api/v1/notice/${id}`;
        axios.delete(url).then(res=>{
            const result = res.data
            if(result.status=="success")
            {
                window.location.reload(false);
            }
        })

    }


  return (
    <div>
      <table class="table table-light">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Notice</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {notices.map((notice, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{notice.notice}</td>
              <td><button  class="btn btn-danger" onClick={()=>Delete(notice.noticeId)} >Delete</button></td>
            </tr>

          ))}
        </tbody>
      </table>
    </div>

  )
}
