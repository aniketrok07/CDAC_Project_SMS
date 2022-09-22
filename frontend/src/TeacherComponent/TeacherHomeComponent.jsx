import React from 'react'
import '../AdminHomeComponent/adminHome.css'
import { BrowserRouter, NavLink, Route, Switch, useHistory, useLocation } from 'react-router-dom'
import AddNotice from '../AdminHomeComponent/AddNotice';
import MyProfile from '../AdminHomeComponent/MyProfile';
import UserProfile from '../AdminHomeComponent/UserProfile';
import ViewStudent from '../StudentComponent/ViewStudent';
import ViewTeacher from './ViewTeacher';
import AddAttendance from './AddAttendance';
import AddMarks from './AddMarks';

export default function TeacherHomeComponent() {
  const location = useLocation()
  const user = location.state

  const histroy = useHistory();
  const Logout = () => {
    localStorage.clear();
    histroy.push('/')
  }
  return (
    <div>
      <BrowserRouter>
        <div className="container-fluid nav-bg">
          <div className="row">
            <div className="col-12 mx-auto">
              <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                <div className="container-fluid">
                  <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                      <li>
                        <NavLink className="nav-link adminHome" to={{ pathname: '/profile', aboutProps: { id: { user } } }}>My Profile</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addNotice">Add Notice</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewTeachers">View Teachers</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewStudents">View Students</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addAttendance">Add Attendance</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addMarks">Add Marks</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/uploadFiles">Upload files</NavLink>
                      </li>
                      <li className=" navbutton">
                        <a className="adminHome" onClick={Logout}>Logout</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </nav>
            </div>
          </div>
        </div>

        <Switch>
          <Route path='/profile' component={MyProfile} />
          <Route path='/userProfile' component={UserProfile} />
          <Route path='/addNotice' component={AddNotice} />
          <Route path='/viewTeachers' component={ViewTeacher} />
          <Route path='/viewStudents' component={ViewStudent} />
          <Route path="/addAttendance" component={AddAttendance} />
          <Route path="/addMarks" component={AddMarks} />

        </Switch>
      </BrowserRouter>
    </div>
  )
}
