import React from 'react'
import '../AdminHomeComponent/adminHome.css'
import { BrowserRouter, NavLink, Route, Switch, useHistory, useLocation } from 'react-router-dom'
import MyProfile from '../AdminHomeComponent/MyProfile';
import UserProfile from '../AdminHomeComponent/UserProfile';
import ViewStudent from '../StudentComponent/ViewStudent';
import ViewTeacher from '../TeacherComponent/ViewTeacher';
import AddFees from './AddFees';
import ViewSchedule from '../AdminHomeComponent/ViewSchedule';
import ViewMarks from './ViewMarks';
import ViewAttendance from '../AdminHomeComponent/ViewAttendance';

export default function StudentHomeComponent() {
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
                        <NavLink className="nav-link adminHome" to="/viewTeachers">View Teachers</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewStudents">View Students</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/addFees">Fees Payment </NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewSchedule">View Schedule</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewMarks">View Marks</NavLink>
                      </li>
                      <li>
                        <NavLink className="nav-link adminHome" to="/viewAttendance">View Attendance</NavLink>
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
          <Route path='/viewTeachers' component={ViewTeacher} />
          <Route path='/viewStudents' component={ViewStudent} />
          <Route path='/addFees' component={AddFees} />
          <Route path='/viewSchedule' component={ViewSchedule} />
          <Route path='/viewMarks' component={ViewMarks} />
          <Route path='/viewAttendance' component={ViewAttendance} />

        </Switch>
      </BrowserRouter>
    </div>
  )
}
