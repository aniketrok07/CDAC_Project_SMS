import React, { useState, useEffect } from 'react';
import axios from 'axios';


export default function ListNoticeComponent() {


  const NOTICE_API_BASE_URL = "http://ec2-13-233-128-18.ap-south-1.compute.amazonaws.com:8080"

  const [notices, setNotices] = useState([]);

  useEffect(() => {
    loadNotices();

  }, []);

  const loadNotices = async () => {
    const result = await axios.get(NOTICE_API_BASE_URL);
    setNotices(result.data);
  }


  return (
    <div>Notice Table
      <table class="table table-light">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Notice</th>
          </tr>
        </thead>
        <tbody>
          {notices.map((notice, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{notice.notice}</td>
            </tr>

          ))}
        </tbody>
      </table>
    </div>

  )
}
