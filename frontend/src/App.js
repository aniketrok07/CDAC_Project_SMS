import './App.css';
import {BrowserRouter,Link,Redirect,Route,Switch} from 'react-router-dom'
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import NavBar from './HomeComponent/NavBar';
import Home from './HomeComponent/Home';
import LoginComponent from './LoginComponent/LoginComponent';
import AdminHomeComponent from './AdminHomeComponent/AdminHomeComponent';
import ForgotPasswordComponent from './LoginComponent/ForgotPasswordComponent';
import TeacherHomeComponent from './TeacherComponent/TeacherHomeComponent';
import StudentHomeComponent from './StudentComponent/StudentHomeComponent';
import Restrict from "./LoginComponent/Restrict";



const App=()=> {
  
  return (
      <BrowserRouter>
      <NavBar/>
     
        <Switch> 
          
          
            <Route exact path='/' component={Home}/>
            <Route exact path='/login' component={LoginComponent}/>
            <Route exact path='/adminHome'><Restrict Cmp={AdminHomeComponent}/></Route>
            <Route exact path='/teacherHome'><Restrict Cmp={TeacherHomeComponent}/></Route>
            <Route exact path='/studentHome'><Restrict Cmp={StudentHomeComponent}/></Route>
            <Route exact path='/updatePassword' component={ForgotPasswordComponent}/>//check backend error
           
         
        </Switch>
      
      </BrowserRouter>
      
  );
}

export default App;
