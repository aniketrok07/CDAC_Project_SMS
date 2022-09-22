import React from "react";
import mylogo from './images/mylogo.png';
import { NavLink } from "react-router-dom";

const NavBar = ()=>{


  const change = () =>{
    document.getElementById("login").innerHTML=""
  }



    return(
        <>
        <div className="container-fluid nav-bg">
            <div className="row">
                <div className="col-11 mx-auto">

                
        <nav className="navbar navbar-expand-lg navbar-light bg-white">
  <div className="container-fluid">
    <a className="navbar-brand" href="/home"><img className="logosize" src={mylogo} alt="logo"></img></a>
    <NavLink className="navbar-brand name " to="#"><h2 >School Management System</h2></NavLink>

    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
       

       
        <li className="nav-item" id="login" >
          <NavLink  onClick={change} className="nav-link" to="/login">Login</NavLink>
        </li>
        
    
        
      </ul>
      
    </div>
  </div>
</nav>
</div>
            </div>
        </div>
       
        </>
        
    )
}

export default NavBar;