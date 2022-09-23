import React from 'react'
import './adminHome.css'
import { BrowserRouter, NavLink, Route, Switch, useHistory, useLocation } from 'react-router-dom'
import MyProfile from './MyProfile'
import UserProfile from './UserProfile'
import AddStudent from '../StudentComponent/AddStudent'
import AddTeacher from '../TeacherComponent/AddTeacher'
import AddAdmin from './AddAdmin'
import AddClass from './AddClass'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../../node_modules/bootstrap/dist/js/bootstrap.bundle'
import AddSubject from './AddSubject'
import AddNotice from './AddNotice'
import ViewTeacher from '../TeacherComponent/ViewTeacher'
import ViewStudent from '../StudentComponent/ViewStudent'
import AddSchedule from './AddSchedule'
import ViewSchedule from './ViewSchedule'
import ViewSubject from './ViewSubject'
import ViewAttendance from './ViewAttendance'
import DeleteNotice from './DeleteNotice'
import Restrict from '../LoginComponent/Restrict'

export default function AdminHomeComponent() {

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
                      <li className="nav-item dropdown">
                        <NavLink to="#" className="nav-link dropdown-toggle adminHome" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Add</NavLink>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                          <li className="nav-item">
                            <NavLink className="nav-link " to="/addStudent">Student</NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/addTeacher">Teacher</NavLink>
                          </li>
                          <li>
                            <NavLink className="nav-link " to="/addAdmin">Admin</NavLink>
                          </li>
                        </ul>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addClass">Add Class</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addSubject">Add Subject</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewSubject">View Subject</NavLink>
                      </li>
                      <li>
                        <li>
                          <NavLink className="nav-link adminHome" to="/addNotice">Add Notice</NavLink>
                          <NavLink className="nav-link adminHome" to="/deleteNotice">Delete Notice</NavLink>
                        </li>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewTeachers">View Teachers</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewStudents">View Students</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewAttendance">View Attendance</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addSchedule">Add Schedule</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewSchedule">View Schedule</NavLink>
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
          <Route exact path='/userProfile' component={UserProfile} />
          <Route path='/addStudent' component={AddStudent} />
          <Route path='/addTeacher' component={AddTeacher} />
          <Route path='/addAdmin' component={AddAdmin} />
          <Route path='/addClass' component={AddClass} />
          <Route path='/addSubject' component={AddSubject} />
          <Route path='/addNotice' component={AddNotice} />
          <Route path='/viewTeachers' component={ViewTeacher} />
          <Route path='/viewStudents' component={ViewStudent} />
          <Route path='/addSchedule' component={AddSchedule} />
          <Route path='/viewSchedule' component={ViewSchedule} />
          <Route path='/viewSubject' component={ViewSubject} />
          <Route path='/viewAttendance' component={ViewAttendance} />
          <Route path='/deleteNotice' component={DeleteNotice} />


        </Switch>
      </BrowserRouter>
    </div>
  )
}
